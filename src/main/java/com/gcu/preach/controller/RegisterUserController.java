package com.gcu.preach.controller;


import javax.validation.Valid;

import com.gcu.preach.Business.UserBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.preach.model.RegisterModel;


@Controller
@RequestMapping("/register")
public class RegisterUserController {

	@Autowired
	private UserBusinessServiceInterface security;
	
	@GetMapping("/")
	public String display( Model model) {

		// Display login form view
		model.addAttribute("message1", "Welcome to Preach Blog");
		model.addAttribute("message2", "Register");
		model.addAttribute("registerModel", new RegisterModel());
	
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid RegisterModel registerModel, BindingResult bindingresult, Model model) {
		
		if(bindingresult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		}

		else if(security.registerUser(registerModel.getUserName(), registerModel.getUserPassword())) {

			return "redirect:/index/";
		} else {
			model.addAttribute("message3", "Registration Failed");
			model.addAttribute("message2", "Please try again");
			model.addAttribute("registerModel", new RegisterModel());
			return "register";
		}
	}
	
}
