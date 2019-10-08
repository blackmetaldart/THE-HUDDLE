package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //POST(create) COMMENT
    @PostMapping("/post/{postId}")
    public Comment createComment(@RequestBody Comment comment, @PathVariable Long postId) {
        return commentService.createComment(comment, postId);
    }

    //GET COMMENT
    @GetMapping("/{username}")
    public List<Comment> getCommentByUsername(@PathVariable String username) {
        return commentService.getCommentByUsername(username);
    }

    //DELETE COMMENT
    //@DeleteMapping("/{id}")
}
