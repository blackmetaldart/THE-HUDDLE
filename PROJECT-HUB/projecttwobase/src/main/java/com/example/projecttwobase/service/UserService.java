package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;

public interface UserService {
    public User createUser(User newUser);
    public String login(User user);
    public User getUser(String username);
    public User addPost(String username, Long postId);
}
