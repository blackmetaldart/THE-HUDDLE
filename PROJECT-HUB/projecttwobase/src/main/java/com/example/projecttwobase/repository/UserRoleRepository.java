package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer>  {
    public UserRole findByName(String name);
}