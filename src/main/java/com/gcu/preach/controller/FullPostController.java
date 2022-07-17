package com.gcu.preach.controller;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fullpost")
public class FullPostController {

    @Autowired
    private BlogPostsBusinessInterface blogPostsBusinessService;

    @GetMapping("/{id}")
    public String getPost(@PathVariable int id, Model model) {

        // Display Full Blog Post form view
        model.addAttribute("blogPost", blogPostsBusinessService.getAllBlogPosts().get(id));
        return "fullpost";
    }
}
