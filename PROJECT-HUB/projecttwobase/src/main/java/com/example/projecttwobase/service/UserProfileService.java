package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserProfile;

public interface UserProfileService {
    UserProfile createUserProfile (UserProfile newProfile, String username);
    UserProfile findByUsername (String username);
    UserProfile updateUserProfile (String unknown );
}