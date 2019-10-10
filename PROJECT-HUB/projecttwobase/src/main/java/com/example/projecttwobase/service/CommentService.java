package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment, Long postId);
   // List<Comment> getCommentByUsername (String username);
    void deleteCommentByCommentId (Long commentId);
}
