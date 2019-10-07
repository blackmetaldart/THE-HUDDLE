package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;
import com.example.projecttwobase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User newUser){
       return userRepository.save(newUser);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.login(username, password);
    }

    public User getUser(String username) {
        return null;
    }

    @Override
    public User addPost(String username, Long postId) {
        return null;
    }
}
