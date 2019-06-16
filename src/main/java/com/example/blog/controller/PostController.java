package com.example.blog.controller;

import com.example.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/posts")
@Controller
public class PostController {

    @GetMapping("/add")
    public String addPost(ModelMap modelMap) {
        modelMap.put("post",new Post());
        return "posts/add";             //new directory ("posts") created in templates
    }





}
