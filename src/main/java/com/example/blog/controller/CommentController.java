package com.example.blog.controller;

import com.example.blog.model.Comment;
import com.example.blog.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/comments")
@Controller
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }

    @PostMapping("")
    public String create (@ModelAttribute Comment comment){
        commentRepository.save(comment);                        //save to database
        return "redirect:/posts/"+comment.getPost().getId();
    }

}
