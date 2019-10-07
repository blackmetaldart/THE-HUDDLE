package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserProfile;

public interface UserProfileService {
    public UserProfile createUserProfile (String username, UserProfile newProfile);
    public UserProfile getUserProfile (String username);
    public UserProfile updateUserProfile (String );
}