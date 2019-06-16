package com.example.blog.controller;

import com.example.blog.PostRepository.PostRepository;
import com.example.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/posts")
@Controller
public class PostController {

    private PostRepository postRepository;

    //alternatively @Autowired, however constructor is more recommended
    public PostController(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    @GetMapping("/add")
    public String addPost(ModelMap modelMap) {
        modelMap.put("post",new Post());
        return "posts/add";             //new directory ("posts") created in templates
    }

    @PostMapping("")
    public String createPost(@ModelAttribute Post post, ModelMap modelMap){
        postRepository.save(post);
        modelMap.put("post",post);
        return "posts/show";
    }



}
