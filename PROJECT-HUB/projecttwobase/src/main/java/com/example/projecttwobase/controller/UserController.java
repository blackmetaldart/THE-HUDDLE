package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.User;
import com.example.projecttwobase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //LIST ALL USERS
//    @GetMapping("/user/list")
//    public List<User> listUsers(){
//        return userService.findAll();
//    }

//    //MAKE POST
//    @PutMapping("/{username}/{postId}")
//    public User addPost(@PathVariable String username, @PathVariable Long postId){
//        return userService.addPost(username, postId);
//    }

}
