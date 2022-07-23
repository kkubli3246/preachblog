package com.gcu.preach.controller;

import javax.validation.Valid;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.Business.UserBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.preach.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginUserController {

	@Autowired
	private UserBusinessServiceInterface security;

	@Autowired
	private BlogPostsBusinessInterface blogPostsBusinessService;
	
	@GetMapping("/")
	public String display( Model model) {
		
		// Display login form view
		model.addAttribute("message1", "Welcome to Preach Blog");
		model.addAttribute("message2", "Login");
		model.addAttribute("loginModel", new LoginModel());
	
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingresult, Model model) {
		
		if(bindingresult.hasErrors()) {
			model.addAttribute("title", "Login");
			model.addAttribute("loggedInMessage", "Welcome ");
			return "login";
		}
		else if(security.authenticateUser(loginModel.getUserName(), loginModel.getPassword())) {
			blogPostsBusinessService.createBlogPosts();
			return "redirect:/index/";
		} else {
			model.addAttribute("message3", "Login Failed");
			model.addAttribute("message2", "Please try again");
			model.addAttribute("loginModel", new LoginModel());
			return "login";
		}
	}


}
