package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("FROM Comment comm WHERE comm.post = ?1")
    List<Comment> findByPostId(Long postId);
}
