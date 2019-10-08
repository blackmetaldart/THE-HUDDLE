package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {


}
