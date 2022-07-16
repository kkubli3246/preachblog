package com.gcu.preach.controller;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private BlogPostsBusinessInterface blogPostsBusinessService;

    @GetMapping("/")
    public String display( Model model) {

        // Display login form view
        model.addAttribute("loggedInMessage", "Welcome to Preach Blog admin");
        model.addAttribute("sideBarHeader", "Search");
        model.addAttribute("blogPosts", blogPostsBusinessService.getAllBlogPosts());

        return "index";
    }
}
