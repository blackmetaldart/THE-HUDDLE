package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.service.UserProfileServiceStub;
import org.junit.Before;

public class UserProfileControllerTest {
    private UserProfileController userProfileController;

    @Before
    public void initializeUserProfileController(){
        userProfileController = new UserProfileController();
        userProfileController.setUserProfileService(new UserProfileServiceStub());
    }

}
