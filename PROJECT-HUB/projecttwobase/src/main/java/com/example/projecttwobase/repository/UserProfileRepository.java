package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
}
