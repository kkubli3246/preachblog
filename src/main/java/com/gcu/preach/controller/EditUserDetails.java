package com.gcu.preach.controller;

import com.gcu.preach.Business.UserBusinessServiceInterface;
import com.gcu.preach.entity.BlogPost;
import com.gcu.preach.entity.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.gcu.preach.Business.UserBusinessService.userName;

@Controller
@RequestMapping("/edituserdetails")
public class EditUserDetails {

	@Autowired
	private UserBusinessServiceInterface service;

	@GetMapping("/{userName}")
	public String getUser(@PathVariable String userName, Model model) {
		
		model.addAttribute("editPostMessage", "Edit User Details");
		UserModel userModel = service.getUserByUsername(userName);
		userModel.setUserName(userName);
		// Display Full Blog Post form view
		model.addAttribute("userModel", userModel);

		return "edituserdetails";
	}

	@PostMapping("/doEditUserDetails")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingresult, Model model) {
		userModel.setUserName(userName);
		if (bindingresult.hasErrors()) {
			model.addAttribute("editPostMessage", "There was an error editing your details");
			return "edituserdetails";
		} else if (service.update(userModel)) {
			return "redirect:/profile/";
		} else {
			model.addAttribute("message3", "A User With That Username Already Exists");

			model.addAttribute("userModel", userModel);
			return "edituserdetails";
		}
	}
}
