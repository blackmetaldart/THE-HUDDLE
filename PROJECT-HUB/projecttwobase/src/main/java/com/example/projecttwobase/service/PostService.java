package com.example.projecttwobase.service;

import com.example.projecttwobase.model.Post;
import com.example.projecttwobase.model.User;

public interface PostService {
    public Post createPost(Post post);
    public void deletePostByPostId(Long postId);
    public Post getPostByUser(User user);
    public Iterable<Post> listAllPosts();

}
