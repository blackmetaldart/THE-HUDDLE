package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Post;

public interface PostService {
    public Post createPost(Post post);
    public void deletePost(Long postId);
    public Post getPost();
    public Iterable<Post> listPost();

}
