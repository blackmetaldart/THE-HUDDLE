package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    //CREATE POST
    @PostMapping("{username}/makepost")
    public Post createPost(@Valid @RequestBody Post post, @Valid @PathVariable String username){
        return postService.createPost(username, post);
    }

    //GET LIST OF ALL POSTS
    @GetMapping("/posts/list")
    public Iterable<Post> listPosts(){
        return postService.listAllPosts();
    }

    //GET POST BY POST ID
    @GetMapping("/post/{postId}")
    public Post postsById(@Valid @PathVariable Long postId) {
        return postService.getPostByPostId(postId);
    }

    //DELETE POST BY POST ID
    @DeleteMapping ("/post/{postId}")
    public ResponseEntity<Object> deletePostByPostId(@PathVariable Long postId) { return postService.deletePostByPostId(postId);
    }

    //GET POST BY USER ID
    @GetMapping("/{username}/post")
    public List<Post> postByUsername (@PathVariable String username) {
        return postService.getPostsByUsername(username);
    }
}

