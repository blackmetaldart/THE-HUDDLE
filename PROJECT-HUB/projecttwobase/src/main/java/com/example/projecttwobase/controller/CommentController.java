package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    //CREATE A COMMENT FOR A POST
    @PostMapping("/{postId}/comment")
    public Comment createComment(@RequestBody Comment comment, @PathVariable Long postId) {
        return commentService.createComment(comment, postId);
    }

    //GET COMMENTS BY POST ID
    @GetMapping("/post/{postId}/comments")
    public List<Comment> getCommentByPostId(@PathVariable Long postId) { return commentService.getCommentsByPostId(postId);
   }

    //GET COMMENT BY USERNAME
//    @GetMapping("/{username}/comment")
//    public List<Comment> getCommentByUsername(@PathVariable String username) {
//        return commentService.getCommentByUsername(username);
//    }

    //DELETE A COMMENT
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Object> deleteCommentByCommentId(@PathVariable Long commentId) {
        return commentService.deleteCommentByCommentId(commentId);
    }

}