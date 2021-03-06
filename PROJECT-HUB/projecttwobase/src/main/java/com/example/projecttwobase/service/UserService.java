package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    String createUser(User newUser);
    String login(User user);
    User getUser(String username);
    public Iterable<User> listUsers();
}
