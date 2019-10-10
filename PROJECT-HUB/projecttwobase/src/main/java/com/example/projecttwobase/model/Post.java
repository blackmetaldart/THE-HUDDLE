package com.example.projecttwobase.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="post")
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String title;


    @Column
    private String description;

    public Post() {
    }

    @Column
    private String username;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_post",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    public String getUsername() {return username; }
    public void setUsername(String username) { this.username = getUsername();}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

}
