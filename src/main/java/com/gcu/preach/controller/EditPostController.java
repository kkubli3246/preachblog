package com.gcu.preach.controller;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/editpost")
public class EditPostController {

        @Autowired
        private BlogPostsBusinessInterface blogPostsBusinessService;

        @GetMapping("/{id}")
        public String getPost(@PathVariable int id, Model model) {
            model.addAttribute("editPostMessage", "Edit Post");

            BlogPost blogPost = blogPostsBusinessService.getBlogPostById(id);
            // Display Full Blog Post form view
            model.addAttribute("blogPost", blogPost);

            return "editpost";
        }

    @PostMapping("/doEditPost")
    public String doEditPost(@Valid BlogPost blogPost, BindingResult bindingresult, Model model) {

        if (bindingresult.hasErrors()) {
            model.addAttribute("title", "Login");
            model.addAttribute("loggedInMessage", "Welcome ");
            return "editpost";
        } else {
            blogPostsBusinessService.updateBlogPosts(blogPost);
            blogPostsBusinessService.updateUserBlogPosts(blogPost);
            return "redirect:/profile/";
        }
    }
}
