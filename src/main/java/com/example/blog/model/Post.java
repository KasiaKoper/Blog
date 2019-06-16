package com.example.blog.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;

    @OneToMany(mappedBy = "post")           //it is required to say which field in Comment class this should be related to
    private List<Comment> comments=new ArrayList<>();

}
