package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;

public interface UserService {
    User createUser(User newUser);
    User login(String username, String password);
    User getUser(String username);
    User addPost(String username, Long postId);
}
