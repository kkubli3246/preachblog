package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginUserController {
	
	
	@GetMapping("/")
	public String display( Model model) {
		
		// Display login form view
		model.addAttribute("message1", "Welcome to Preach Blog");
		model.addAttribute("message2", "Login");
		model.addAttribute("loginModel", new LoginModel());
	
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doRegister(@Valid LoginModel loginModel, BindingResult bindingresult, Model model) {
		
		if(bindingresult.hasErrors()) {
			model.addAttribute("title", "Login");
			return "login";
		}
		
		
		return "index";
	}

}
