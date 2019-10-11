package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserProfile;

public interface UserProfileService {
    UserProfile createUserProfile (String username, UserProfile newProfile);
    UserProfile getUserProfile (String username);
}
