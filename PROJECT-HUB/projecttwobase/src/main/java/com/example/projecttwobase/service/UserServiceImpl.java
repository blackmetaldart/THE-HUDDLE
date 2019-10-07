package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;

public class UserServiceImpl implements UserService {
    public String createUser(User newUser){
        if(userRepository.save(newUser)!=null){

        }
        return "hello";
    }

    public String login(User user){
        return "hello";
    }

    public User getUser(String username) {
        return
    }

    @Override
    public User addPost(String username, Long postId) {
        return null;
    }
}
