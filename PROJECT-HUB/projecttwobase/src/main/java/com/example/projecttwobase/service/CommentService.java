package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;

public interface CommentService {
    public Comment createComment(Comment comment);
    public Comment getCommentByUser (Long user);
    public Comment getCommentByPostId (Long postId);
    public void deleteCommentByCommentId (Long commentId);
}
