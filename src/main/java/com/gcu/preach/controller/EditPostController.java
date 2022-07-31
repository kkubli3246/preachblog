package com.gcu.preach.controller;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editpost")
public class EditPostController {

        @Autowired
        private BlogPostsBusinessInterface blogPostsBusinessService;

        @GetMapping("/{id}")
        public String getPost(@PathVariable int id, Model model) {
            model.addAttribute("editPostMessage", "Edit Post");

            BlogPost blogPost = blogPostsBusinessService.getAllBlogPosts().get(id);
            // Display Full Blog Post form view
            model.addAttribute("blogPost", blogPost);

            return "editpost";
        }
}
