package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;

public interface CommentService {
    public Comment createComment(Comment comment);
    public Comment getCommentByCommentId (Long commentId);
    public Comment getCommentByPostId (Long postId);
    public Comment deleteCommentByCommentId (Long commentId);
}
