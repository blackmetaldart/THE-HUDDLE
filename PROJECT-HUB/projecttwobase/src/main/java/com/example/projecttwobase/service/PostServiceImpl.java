package com.example.projecttwobase.service;

import com.example.projecttwobase.config.ExceptionHandler;
import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(String username, Post post) {
        post.setUsername(username);
        return postRepository.save(post);
    }

    //GETS A POST FROM THE POST REPOSITORY USING THE POST ID
    public Post getPostByPostId (Long postId) {
        return postRepository.getPostById(postId);
    }

    //DELETES A POST FROM THE POST REPOSITORY
    public ResponseEntity<Object> deletePostByPostId(Long postId){
       return postRepository.findById(postId).map (post -> {
            postRepository.delete(post);
           return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ExceptionHandler("PostId " + postId + " not found"));
    }

    //GETS A POST USING FROM THE POST REPOSITORY USING THE USERNAME
    public List<Post> getPostsByUsername(String username) {
        return postRepository.findAllByUsername(username);
    }

    //LISTS ALL THE POSTS IN THE REPOSITORY
    @Override
    public Iterable<Post> listAllPosts(){
        return postRepository.findAll();
    }
}
