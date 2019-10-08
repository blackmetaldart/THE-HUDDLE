package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.model.User;
import com.example.projecttwobase.service.CommentService;
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

    @PutMapping("/{username}/{postId}")
    public User addPost(@PathVariable String username, @PathVariable Long postId){
        return userService.addPost(username, postId);
    }

    //GET COMMENT BY USER NAME
    @GetMapping("/{username}/comment")
    public List<Comment> getCommentByUsername (@PathVariable String username) {
        CommentService commentService = null;
        return commentService.getCommentByUsername(username);
    }

    //GET POST BY USER ID
    //@GetMapping("/{username}/post")
}
