package com.example.projecttwobase.controller;


import com.example.projecttwobase.model.UserRole;
import com.example.projecttwobase.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class UserRoleController {
    @Autowired
    UserRoleService roleService;

    //ENDPOINT THAT ALLOWS A USER TO CREATE A ROLE
    @PostMapping
    public UserRole createRole(@RequestBody UserRole role) {
        return roleService.createRole(role);
    }

    //ENDPOINT THAT ALLOWS A USER TO GET A ROLE
    @GetMapping("/{rolename}")
    public UserRole getRole(@PathVariable String rolename) {
        return roleService.getRole(rolename);
    }
}
