package com.example.projecttwobase.service;

import com.example.projecttwobase.model.User;
import com.example.projecttwobase.model.UserProfile;
import com.example.projecttwobase.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{


    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserService userService;

    @Override
    public UserProfile createUserProfile(UserProfile newProfile, String username) {
        User user = userService.getUser(username);
        user.setUserProfile(newProfile);

        return user.getUserProfile();
    }

    @Override
    public UserProfile findByUsername(String username) {
        return userProfileRepository.findByUsername(username);
    }

    public UserProfile updateUserProfile (String unknown) { return null; }


}
