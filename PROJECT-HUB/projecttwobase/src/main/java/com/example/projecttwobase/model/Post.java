package com.example.projecttwobase.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.xml.ws.BindingType;

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

    public Post(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}
