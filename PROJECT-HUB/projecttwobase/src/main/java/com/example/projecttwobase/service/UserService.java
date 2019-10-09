package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User createUser(User newUser);
    User login(String username, String password);
    User getUser(String username);
    User addPost(String username, Long postId);
    public Iterable<User> listUsers();
}
