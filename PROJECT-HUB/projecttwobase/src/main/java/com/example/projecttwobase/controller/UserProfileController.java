package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
//    @Autowired
//    UserProfileService userProfileService;

    //ENDPOINT THAT ALLOWS A USER TO CREATE PROFILE
    @PostMapping("/{username}")
    public UserProfile makeUserProfile(@RequestBody UserProfile userProfile, @PathVariable String username) {
        return userProfileService.createUserProfile(username, userProfile);
    }

    //ENDPOINT THAT ALLOWS A USER TO GET PROFILE
    @GetMapping("/{username}")
    public UserProfile getUserProfile(@PathVariable String username) {
        return userProfileService.getUserProfile(username);
    }

    private UserProfileService userProfileService;

    @Autowired
    public void setUserProfileService(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    public UserProfile createUserProfile(String batman, UserProfile userProfile) {
        return null;
    }
}
