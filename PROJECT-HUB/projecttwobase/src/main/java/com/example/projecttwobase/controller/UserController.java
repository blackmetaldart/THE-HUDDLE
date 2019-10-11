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

    //ALLOWS A USER TO SIGN UP / REFER TO USER SERVICE
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        //return userService.createUser(newUser);
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    //ALLOWS A USER TO LOG IN / REFER TO USER SERVICE
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }


    //SHOWS A USER LIST / REFER TO USER SERVICE
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users/list")
    public Iterable<User> listUsers(){
        return userService.listUsers();
    }


    //THE ALMIGHTY HELLO WORLD / REFER TO 101
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
