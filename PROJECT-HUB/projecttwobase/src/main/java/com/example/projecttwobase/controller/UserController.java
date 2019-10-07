package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.User;
import com.example.projecttwobase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //SIGN UP
    @PostMapping("/signup")
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    //LOG IN
    //@PostMapping("/login")

    //GET COMMENT BY USER ID
    //@GetMapping("/{username}/comment")

    //GET POST BY USER ID
    //@GetMapping("/{username}/post")
}
