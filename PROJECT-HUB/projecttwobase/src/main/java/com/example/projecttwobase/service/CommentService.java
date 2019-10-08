package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    public Comment createComment(Comment comment, Long postId);
    public List<Comment> getCommentByUsername (String username);
    public ResponseEntity<Object> deleteCommentByCommentId (Long commentId);
}
