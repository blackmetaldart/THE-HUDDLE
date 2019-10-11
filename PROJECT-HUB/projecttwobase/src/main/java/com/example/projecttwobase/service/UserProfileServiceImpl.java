package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;
import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    private UserProfileRepository userProfileRepository;

    private UserService userService;


    //SETS A USER FOR A PROFILE BASED ON A USERNAME AND SAVES THE PROFILE IN THE REPOSITORY
    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        User user = userService.getUser(username);
        newProfile.setUser(user);
        user.setUserProfile(newProfile);
        return userProfileRepository.save(newProfile);
    }

    //FINDS A USER PROFILE BASED ON A USERNAME
    @Override
    public UserProfile getUserProfile(String username) {
        return userProfileRepository.findProfileByUsername(username);
    }


    @Autowired
    public UserProfileServiceImpl(UserService userService, UserProfileRepository userProfileRepository){
        this.userService = userService;
        this.userProfileRepository = userProfileRepository;
    }
}
