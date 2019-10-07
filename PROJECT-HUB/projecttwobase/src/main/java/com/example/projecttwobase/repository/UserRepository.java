package com.example.projecttwobase.repository;


import com.example.projecttwobase.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername (String username);

    @Query("FROM User u WHERE u.username = ?1 and u.password = ?2")
    public User login(String username, String password);


}
