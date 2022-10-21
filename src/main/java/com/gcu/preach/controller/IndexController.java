package com.gcu.preach.controller;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.gcu.preach.Business.UserBusinessService.userName;

@Controller
public class IndexController {

	@Autowired
	private BlogPostsBusinessInterface blogPostsBusinessService;

	@GetMapping(value = {"/" , "/index"})
	public String display(Model model) {

		// Display login form view
		model.addAttribute("loggedInMessage", "Welcome to Preach Blog");
		model.addAttribute("userName", userName);
		model.addAttribute("loginPrompt", " Login to access blog");
		model.addAttribute("blogPosts", blogPostsBusinessService.getAllBlogPosts());

		return "index";
	}
}
