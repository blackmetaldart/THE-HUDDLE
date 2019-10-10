package com.example.projecttwobase.repository;

import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.repository.UserProfileRepositoryStub;

import com.example.projecttwobase.service.UserProfileServiceImpl;
import com.example.projecttwobase.service.UserServiceStub;
import org.junit.Before;

public class UserProfileServiceTest {
    @Before
    public void initializeUserProfile(){
        UserProfileServiceImpl userProfileService = new UserProfileServiceImpl(new UserServiceStub(), new UserProfileRepositoryStub());
    }
}