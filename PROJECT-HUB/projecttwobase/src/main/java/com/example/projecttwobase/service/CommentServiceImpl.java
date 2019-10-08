package com.example.projecttwobase.service;


import com.example.projecttwobase.config.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheableOperation;
import org.springframework.http.ResponseEntity;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.repository.CommentRepository;
import com.example.projecttwobase.repository.PostRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(@RequestBody Comment comment, Long postId ){
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ExceptionHandler("PostId " + postId + " not found"));
    }

    public List<Comment> getCommentByUsername (String username){
        return commentRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<Object> deleteCommentByCommentId (Long commentId){
        return commentRepository.findById(commentId).map(comment ->{
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId));

    }
}
