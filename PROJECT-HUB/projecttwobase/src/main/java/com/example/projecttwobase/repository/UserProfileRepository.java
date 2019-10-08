package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    @Query("from UserProfile up left join User u on u.username = ?1 and up.id = u.userProfile.id")
    UserProfile findProfileByUsername(String username);
}
