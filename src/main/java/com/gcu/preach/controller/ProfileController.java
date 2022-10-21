package com.gcu.preach.controller;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.Business.UserBusinessServiceInterface;
import com.gcu.preach.dao.UserRepository;
import com.gcu.preach.entity.BlogPost;
import com.gcu.preach.entity.UserModel;
import com.gcu.preach.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.gcu.preach.Business.UserBusinessService.userName;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private UserBusinessServiceInterface userBusinessService;

	@Autowired
	private BlogPostsBusinessInterface blogPostsBusinessService;

	@GetMapping("/")
	public String display(Model model) {
		UserModel userModel = userBusinessService.getUserByUsername(userName);

		model.addAttribute("feedHeaderText", "Welcome to Your Profile ");
		model.addAttribute("userModel", userModel);
		model.addAttribute("sidebarBottomLabel", "User Options");
		model.addAttribute("userBlogPosts", blogPostsBusinessService.getAllUserBlogPosts());

		return "profile";
	}

	@PostMapping("/doDeletePost")
	public String doDeletePost(@Valid BlogPost blogPost) {
		if (blogPost.getId() == 0 || blogPost.getTitle() == null) {

			return "redirect:/profile/";
		} else {
			int id = blogPost.getId();
			blogPostsBusinessService.deleteBlogPosts(id);
			blogPostsBusinessService.deleteUserBlogPosts(id);
			return "redirect:/profile/";
		}

	}

}
