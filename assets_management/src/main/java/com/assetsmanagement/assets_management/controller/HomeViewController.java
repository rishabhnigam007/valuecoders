package com.assetsmanagement.assets_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.assetsmanagement.assets_management.entity.User;

@Controller
public class HomeViewController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - Assets Management");
		return "home";
	}

	@RequestMapping("/signup")
	public String signup(@ModelAttribute("user") User user,BindingResult result,Model model) {
		model.addAttribute("title", "Registeration Page");
		
		if(result.hasErrors())
		{
			
			model.addAttribute("user",user);
			return "signup";
		}
		
		model.addAttribute("user", new User());
		return "signup";
	}

	@GetMapping("/signin")
	public String customLogin(Model model) {
		model.addAttribute("title", "Login Page");
		return "login";
	}
}