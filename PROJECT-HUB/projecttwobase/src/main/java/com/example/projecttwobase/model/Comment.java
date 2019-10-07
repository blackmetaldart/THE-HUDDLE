package com.example.projecttwobase.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}
}
