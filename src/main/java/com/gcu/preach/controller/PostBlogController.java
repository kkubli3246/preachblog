package com.gcu.preach.controller;


import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/postBlog")
public class PostBlogController {

    @Autowired
    private BlogPostsBusinessInterface blogPostsBusinessService;

    @RequestMapping("/")
    public String display(Model model) {
        // Display post blog form view

        return "postBlog";
    }

    @PostMapping("/doPost")
    public String doPost(@Valid BlogPost blogPost, BindingResult bindingresult, Model model) {
        if(bindingresult.hasErrors()) {
            model.addAttribute("title", "Preach It!!");
            model.addAttribute("loggedInMessage", "Welcome ");
            return "postBlog";
        }
        else {
            blogPostsBusinessService.addBlogPost(blogPost);
            return "redirect:/index/";
        }
    }

}
