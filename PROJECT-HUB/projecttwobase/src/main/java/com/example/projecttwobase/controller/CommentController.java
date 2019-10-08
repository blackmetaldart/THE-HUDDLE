package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    //POST(create) COMMENT
    @PostMapping
    public Comment createComment(@RequestBody Comment comment, Long postId){
        return CommentService.createComment(comment, postId);
    }

    //GET COMMENT
    //@GetMapping("/{id}")

    //DELETE COMMENT
    //@DeleteMapping("/{id}")
}
