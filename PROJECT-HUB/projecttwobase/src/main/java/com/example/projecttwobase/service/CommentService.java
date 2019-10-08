package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;

import java.util.List;

public interface CommentService {
    public Comment createComment(Comment comment);
    public List<Comment> getCommentByUser (Long user);
    public List<Comment> getCommentByPostId (Long postId);
    public void deleteCommentByCommentId (Long commentId);
}
