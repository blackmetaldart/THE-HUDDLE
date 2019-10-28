package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment, Long postId);
    List<Comment> getCommentsByPostId (Long postId);
    List<Comment> getCommentsByUsername (String username);
    ResponseEntity<Object> deleteCommentByCommentId (Long commentId);
}
