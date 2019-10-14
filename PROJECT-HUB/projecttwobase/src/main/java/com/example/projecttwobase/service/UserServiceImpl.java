package com.example.projecttwobase.service;

import com.example.projecttwobase.config.JwtUtil;
import com.example.projecttwobase.model.User;
import com.example.projecttwobase.model.UserRole;
import com.example.projecttwobase.repository.PostRepository;
import com.example.projecttwobase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    //CREATES A USER AND GENERATES A JWT TOKEN FOR AUTHENTICATION
    @Override
    public String createUser(User newUser) {
        UserRole userRole = userRoleService.getRole("ROLE_ADMIN");
        newUser.setUserRole(userRole);
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        if(userRepository.save(newUser) != null){
            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    //COMPARES THE USER PASSED AS A PARAMETER TO THE INFORMATION IN THE USER REPOSITORY AND
    // GENERATES A JWT TOKEN ON APPROVAL
    @Override
    public String login(User user){
        User newUser = userRepository.findByUsername(user.getUsername());
        if(newUser != null && bCryptPasswordEncoder.matches(user.getPassword(), newUser.getPassword())){
            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    //FINDS A PROFILE BY THE USERNAME FROM THE USER REPOSITORY
    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    //FINDS A USER BY THE USERNAME
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if(user==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, new ArrayList<>());
    }

    //GRANTS A USER AUTHORITY
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole().getName()));
        return authorities;
    }

    //FINDS ALL THE USERS IN THE USER REPOSITORY
    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

}