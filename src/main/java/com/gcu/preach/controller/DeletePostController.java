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
@RequestMapping("/deletepost")
public class DeletePostController {
	@Autowired
	private BlogPostsBusinessInterface blogPostsBusinessService;

	@GetMapping("/{id}")
	public String getPost(@PathVariable int id, Model model) {
		model.addAttribute("editPostMessage", "Edit Post");

		BlogPost blogPost = blogPostsBusinessService.getBlogPostById(id);
		// Display Full Blog Post form view
		model.addAttribute("blogPost", blogPost);

		return "deletepost";
	}

	@PostMapping("/doDeletePost")
	public String doDeletePost(BlogPost blogPost) {
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
