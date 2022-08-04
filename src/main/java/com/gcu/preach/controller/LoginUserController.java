package com.gcu.preach.controller;

import javax.validation.Valid;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.Business.UserBusinessServiceInterface;
import com.gcu.preach.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.preach.model.LoginModel;

@Controller

public class LoginUserController {



	@GetMapping("/login")
	public String display( Model model) {
		
		// Display login form view
		model.addAttribute("message1", "Welcome to Preach Blog");
		model.addAttribute("message2", "Login");
		model.addAttribute("loginModel", new LoginModel());
	
		return "login";
	}

}
