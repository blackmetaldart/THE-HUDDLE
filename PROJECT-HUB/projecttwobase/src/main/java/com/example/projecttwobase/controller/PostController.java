package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Post postsById(@Valid @PathVariable Long id) {
        return postService.getPostByPostId(id);
    }

    //GET COMMENT BY POST ID
    @GetMapping("/{id}/comment")
    public List<Comment> getCommentByPostId(@PathVariable Long id) {
        return postService.getCommentByPostId(id);
    }

    //DELETE POST BY ID
    @DeleteMapping ("/{id}")
    public ResponseEntity deletePostByPostId(@PathVariable Long id) {
        return postService.deletePostByPostId(id);
    }
}

