package com.example.blog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)             //IDENTITY so that to have separate independent ID
    Integer id;

    private String description;

    @ManyToOne                      // relation type
    private Post post;              //comment is for the specific post

    @Override
    public String toString() {
        return getDescription();
    }
}
