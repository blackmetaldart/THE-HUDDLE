package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.repository.CommentRepository;
import com.example.projecttwobase.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostByPostId (Long postId) {
        return postRepository.getPostByPostId(postId);}

    public ResponseEntity<?> deletePostByPostId(Long postId){
       return postRepository.findById(postId).map (post -> {
            postRepository.delete(post);
           return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    public List<Post> getPostByUsername(String username) {
        return postRepository.findPostByUsername(username);
    }

    public List<Comment> getCommentByPostId (Long postId){
        CommentRepository commentRepository = null;
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Iterable<Post> listAllPosts(){
        return postRepository.findAll();
    }
}
