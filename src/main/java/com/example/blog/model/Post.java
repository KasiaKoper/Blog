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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    //it is required to say which field in Comment class this should be related to
    private List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content +"}";
    }

}
