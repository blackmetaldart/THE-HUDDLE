package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserProfile;

public interface UserProfileService {
    public UserProfile createUserProfile (UserProfile newProfile);
    public UserProfile getUserProfile (String username);
    public UserProfile updateUserProfile (String unknown );

}