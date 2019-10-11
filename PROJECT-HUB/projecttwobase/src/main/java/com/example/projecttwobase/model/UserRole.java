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

    // ID / NAME COLUMNS FOR TABLE
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    //MAPPING THE ROLES TO THE USERS
    @OneToMany(mappedBy = "userRole",
            cascade = CascadeType.ALL)
    private List<User> users;

    //EMPTY USERROLE CONSTRUCTOR
    public UserRole() {}

    public void setUsers(List<User> users){ this.users = users; }
    public List<User> getUsers(){ return users; }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
