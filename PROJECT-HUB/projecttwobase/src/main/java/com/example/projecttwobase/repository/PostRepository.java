package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    public List<Post> findPostByUsername (String username);

}
