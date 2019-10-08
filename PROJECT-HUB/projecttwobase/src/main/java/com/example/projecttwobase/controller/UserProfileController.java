package com.example.projecttwobase.controller;

import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;

    //CREATE
    @PostMapping("/{username}/profile")
    public UserProfile makeUserProfile(@RequestBody UserProfile userProfile, @PathVariable String username) {
        return userProfileService.createUserProfile(username, userProfile);
    }

    //UPDATE
    //@PostMapping("/{username}")

    //GET
    @GetMapping("/{username}/profile")
    public UserProfile getUserProfile(@PathVariable String username) {
        return userProfileService.getUserProfile(username);
    }

}
