package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.model.User;
import com.example.projecttwobase.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePostByPostId(Long postId){
    }

    public Post getPostByUser(User user) {
        return null;
    }

    @Override
    public Iterable<Post> listAllPosts(){
        return postRepository.findAll();
    }
}
