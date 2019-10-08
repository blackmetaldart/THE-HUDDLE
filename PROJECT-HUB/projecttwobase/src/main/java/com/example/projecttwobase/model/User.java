package com.example.projecttwobase.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    public User(){}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="users_profile_id")
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "users_role_id", nullable = false)
    private UserRole userRole;

    public UserRole getUserRole() { return userRole; }
    public void setUserRole(UserRole userRole) { this.userRole = userRole; }

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "users_post",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> posts;

    public List<Post> getPosts(){ return posts; }

    public void setPosts(List<Post> posts) { this.posts = posts; }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public List<Post> addPost(Post post){
        if(posts == null)
            posts = new ArrayList<>();
        posts.add(post);

        return posts;
    }

}
