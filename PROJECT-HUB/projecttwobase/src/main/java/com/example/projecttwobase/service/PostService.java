package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    public Post createPost(Post post);
    public ResponseEntity deletePostByPostId(Long postId);
    public List<Post> getPostByUsername(String username);
    public Post getPostByPostId (Long postId);
    public List<Comment> getCommentByPostId (Long postId);
    public Iterable<Post> listAllPosts();
}
