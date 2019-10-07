package com.example.projecttwobase.controller;

import com.example.projecttwobase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //SIGN UP
    @PostMapping("/signup")

    //LOG IN
    @PostMapping("/login")

    //GET COMMENT BY USER ID
    @GetMapping("/{username}/comment")

    //GET POST BY USER ID
    @GetMapping("/{username}/post")
}
