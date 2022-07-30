package com.gcu.preach.controller;


import com.gcu.preach.Business.UserBusinessServiceInterface;
import com.gcu.preach.dao.UserRepository;
import com.gcu.preach.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserBusinessServiceInterface userBusinessService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String display( Model model) {
        UserModel userModel = userBusinessService.getUserByUsername();

        model.addAttribute("message1", "Welcome to Your Profile ");
        model.addAttribute("userModel", userModel);
        model.addAttribute("sidebarBottomLabel", "User Options");

        return "profile";
    }
}
