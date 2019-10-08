package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("FROM Post popo WHERE popo.username = ?1")
    List<Post> findAllByUser (String username);

    @Query("FROM Post popo WHERE popo.id = ?1")
    Post getPostById (Long postId);

}
