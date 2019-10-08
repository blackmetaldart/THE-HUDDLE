package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserRole;

public interface UserRoleService {
    UserRole createRole(UserRole newRole);
    UserRole getRole(String roleName);
}
