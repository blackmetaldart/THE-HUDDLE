package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserProfile;

public class UserProfileServiceStub implements UserProfileService {
    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("batman@superhero.com");
        return userProfile;
    }
    @Override
    public UserProfile getUserProfile(String username) {
        return null;
    }


    public UserProfile updateUserProfile(String unknown) {
        return null;
    }
}