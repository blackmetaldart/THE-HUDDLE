package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.User;
import com.example.projecttwobase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password) {
        return userService.login(username, password);
    }

    //GET COMMENT BY USER ID
    //@GetMapping("/{username}/comment")

    //GET POST BY USER ID
    //@GetMapping("/{username}/post")
}
