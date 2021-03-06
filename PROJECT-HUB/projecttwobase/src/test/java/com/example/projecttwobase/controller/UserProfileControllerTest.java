package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.repository.UserProfileRepositoryStub;
import com.example.projecttwobase.service.UserProfileService;
import com.example.projecttwobase.service.UserProfileServiceImpl;
import com.example.projecttwobase.service.UserProfileServiceStub;
import com.example.projecttwobase.service.UserServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {
    private UserProfileServiceImpl userProfileService;

    @Before
    public void initializeUserProfile(){
        userProfileService = new UserProfileServiceImpl(new UserServiceStub(), new UserProfileRepositoryStub());
    }

    @Test
    public void createUserProfile_AddsProfile_Success(){

        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("batman@superhero.com");

        UserProfile newProfile = userProfileService.createUserProfile("batman", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
    }

    @Test
    public void getUserProfile_RetrievesProfileByUsername_Success(){

    }

}
