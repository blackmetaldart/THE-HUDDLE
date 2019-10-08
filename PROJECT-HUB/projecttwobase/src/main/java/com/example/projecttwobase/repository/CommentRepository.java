package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    public List<Comment> findByPostId(Long postId);
    public List<Comment> findByUsername(String username);
}
