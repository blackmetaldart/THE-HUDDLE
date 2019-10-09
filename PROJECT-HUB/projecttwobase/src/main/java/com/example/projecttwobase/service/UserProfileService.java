package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserProfile;

public interface UserProfileService {
    UserProfile createUserProfile (UserProfile newProfile, String username);
    UserProfile getUserProfile (String username);
    UserProfile updateUserProfile (String unknown );
}