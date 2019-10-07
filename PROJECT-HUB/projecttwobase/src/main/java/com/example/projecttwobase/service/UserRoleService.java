package com.example.projecttwobase.service;

import com.example.projecttwobase.model.UserRole;

public interface UserRoleService {
    public UserRole createRole(UserRole newRole);

    public UserRole getRole(String roleName);
}
