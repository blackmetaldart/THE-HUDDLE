package com.example.projecttwobase.model;

import javax.persistence.*;

@Entity
@Table(name = "userProfile")
public class UserProfile {
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

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getAddtEmail() {return addtEmail;}
    public void setAddtEmail(String addtEmail) {this.addtEmail = addtEmail;}

    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
}
