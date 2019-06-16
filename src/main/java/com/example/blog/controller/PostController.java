package com.example.blog.controller;

import com.example.blog.repository.PostRepository;
import com.example.blog.model.Comment;
import com.example.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String createPost(@ModelAttribute Post post,ModelMap modelMap){
        postRepository.save(post);
        return "redirect:/posts/"+post.getId();
    }

    @GetMapping("/{id}")
    public String showPost(@PathVariable Integer id, ModelMap modelMap){
        Post post =postRepository.findById(id).get();
        modelMap.put("post",post);
        Comment comment=new Comment();
        comment.setPost(post);
        modelMap.put("comment", comment);
        modelMap.put("comments",post.getComments());
        return "posts/show";
    }
}
