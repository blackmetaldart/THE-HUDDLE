package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
