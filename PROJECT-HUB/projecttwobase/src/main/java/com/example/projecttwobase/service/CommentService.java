package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;

import java.util.List;

public interface CommentService {
    public Comment createComment(Comment comment, Long postId);
    public List<Comment> getCommentByUsername (String username);
    public void deleteCommentByCommentId (Long commentId);
}
