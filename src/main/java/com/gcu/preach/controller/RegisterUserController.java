package com.gcu.preach.controller;

import javax.validation.Valid;

import com.gcu.preach.Business.UserBusinessServiceInterface;
import com.gcu.preach.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

	@Autowired
	private UserBusinessServiceInterface service;

	@GetMapping("/")
	public String display(Model model) {

		// Display login form view
		model.addAttribute("message1", "Welcome to Preach Blog");
		model.addAttribute("message2", "Register New User");
		model.addAttribute("userModel", new UserModel());

		return "register";
	}

	@PostMapping("/doRegister")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingresult, Model model) {

		String password = userModel.getUserPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		
		
		
		userModel.setUserPassword(hashedPassword);

		if (bindingresult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		} else if (service.registerUser(userModel)) {
			return "redirect:/login/";
		} else {
			model.addAttribute("message3", "A User With That Username Already Exists");
			model.addAttribute("message2", "Please try again");
			model.addAttribute("registerModel", new UserModel());
			return "register";
		}
	}

}
