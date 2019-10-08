package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    //POST
    @PostMapping
    public Post createPost(@Valid @RequestBody Post post){
        return postService.createPost(post);
    }

    //GET POST LIST
    @GetMapping("/list")
    public Iterable<Post> listPosts(){
        return postService.listAllPosts();
    }

    //GET POST BY POST ID
    @GetMapping("/{id}")
    public List<Post> postsById(@Valid @PathVariable Long postId) {
        return postService.getPostByPostId()
    }

    //GET COMMENT BY POST ID
    //@GetMapping("/{id}/comment")

    //DELETE POST BY ID
    //@DeleteMapping ("/{id}")
}

