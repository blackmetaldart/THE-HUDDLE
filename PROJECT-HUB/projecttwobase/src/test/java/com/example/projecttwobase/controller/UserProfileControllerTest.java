package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.service.UserProfileServiceStub;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {
    private UserProfileController userProfileController;

    @Before
    public void initializeUserProfileController(){
        userProfileController = new UserProfileController();
        userProfileController.setUserProfileService(new UserProfileServiceStub());
    }

    @Test
    public void createUserProfile_SaveUserProfile_Success(){
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("batman@superhero.com");

        UserProfile newProfile = userProfileController.createUserProfile("batman", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
    }

}
