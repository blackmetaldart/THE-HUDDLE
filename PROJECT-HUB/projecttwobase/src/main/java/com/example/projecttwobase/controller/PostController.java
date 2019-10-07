package com.example.projecttwobase.controller;

import com.example.projecttwobase.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    //POST
    @PostMapping

    //GET POST LIST
    @GetMapping("/list")

    //GET POST BY POST ID
    @GetMapping("/{id}")

    //GET COMMENT BY POST ID
    @GetMapping("/{id}/comment")

    //DELETE POST BY ID
    @DeleteMapping ("/{id}")
}

