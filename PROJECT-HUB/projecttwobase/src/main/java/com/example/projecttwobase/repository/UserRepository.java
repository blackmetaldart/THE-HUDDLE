package com.example.projecttwobase.repository;


import com.example.projecttwobase.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
