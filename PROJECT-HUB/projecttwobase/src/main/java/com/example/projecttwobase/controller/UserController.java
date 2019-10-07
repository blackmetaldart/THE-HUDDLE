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

    @PostMapping("/signup")

    @PostMapping("/login")

    @GetMapping("/{username}/comment")

    @GetMapping("/{username}/post")
}
