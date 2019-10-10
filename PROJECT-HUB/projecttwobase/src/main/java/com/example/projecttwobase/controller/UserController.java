package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.User;
import com.example.projecttwobase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //SIGN UP
    @PostMapping("/signup")
    public String createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    //LOG IN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users/list")
    public Iterable<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }

//    //MAKE POST
//    @PutMapping("/{username}/{postId}")
//    public User addPost(@PathVariable String username, @PathVariable Long postId){
//        return userService.addPost(username, postId);
//    }

}
