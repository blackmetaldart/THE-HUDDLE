package com.example.projecttwobase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    // ID / ADDTEMAIL / MOBILE / ADDRESS COLUMNS FOR TABLE
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String addtEmail;

    @Column
    private String mobile;

    @Column
    private String address;

    //MAPPING THE PROFILES TO THE USERS
    @JsonIgnore
    @OneToOne(mappedBy = "userProfile", fetch = FetchType.LAZY, cascade={CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    //EMPTY CONSTRUCTOR FOR USER PROFILE
    public UserProfile(){}

    //GETTERS AND SETTERS FOR FIELDS
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getAddtEmail() {return addtEmail;}
    public void setAddtEmail(String addtEmail) {this.addtEmail = addtEmail;}

    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public void setEmail(String s) {
    }
    public Long getEmail() {
        return null;
    }
}
