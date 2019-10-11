package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserRole;
import com.example.projecttwobase.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    //SAVES A ROLE IN THE USER ROLE REPOSITORY
    @Override
    public UserRole createRole(UserRole newRole) {
        return userRoleRepository.save(newRole);
    }

    //GETS A ROLE NAME USING THE STRING PASSED
    @Override
    public UserRole getRole(String roleName) {
        return userRoleRepository.findByName(roleName);
    }
}
