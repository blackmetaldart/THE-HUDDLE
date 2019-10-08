package com.example.projecttwobase.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.model.User;
import com.example.projecttwobase.repository.CommentRepository;
import com.example.projecttwobase.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public class CommentServiceImpl {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(@RequestBody Comment comment, Long postId ){
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElse(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    public Comment getCommentByUser (User user){
        return null;
    }

    public Comment getCommentByPostId (Long postId){
        return null;
    }

    public void deleteCommentByCommentId (Long commentId){
        return commentRepository.findById(commentId).map(comment ->{
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and postId " + postId));

    }
}
