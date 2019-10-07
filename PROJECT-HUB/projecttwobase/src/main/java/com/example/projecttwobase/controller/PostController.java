package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Post;
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
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    //GET POST LIST
    @GetMapping("/list")
    public Iterable<Post> listPosts(){
        return postService.listAllPosts();
    }

    //GET POST BY POST ID
    //@GetMapping("/{id}")

    //GET COMMENT BY POST ID
    //@GetMapping("/{id}/comment")

    //DELETE POST BY ID
    //@DeleteMapping ("/{id}")
}

