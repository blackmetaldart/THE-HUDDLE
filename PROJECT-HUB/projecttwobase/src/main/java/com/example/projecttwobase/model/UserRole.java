package com.example.projecttwobase.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

@Entity
@Table(name = "user_role")
public class UserRole {
    //Role 1 = Admin
    //Role 2 = General
    //Role 3 = DBA

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    public UserRole() {}

    @OneToMany(mappedBy = "userRole",
            cascade = CascadeType.ALL)
    private List<User> users;

    public void setUsers(List<User> users){ this.users = users; }

    public List<User> getUsers(){ return users; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}