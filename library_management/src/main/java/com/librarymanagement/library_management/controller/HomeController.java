package com.librarymanagement.library_management.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.librarymanagement.library_management.dao.UserRepository;
import com.librarymanagement.library_management.entity.User;
import com.librarymanagement.library_management.helper.Message;

@Controller
public class HomeController 
{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title", "Home - Library Management System");
		return "home";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title", "Registeration Page");
		model.addAttribute("user",new User());
		return "signup";
	}
	
	// this handler is used for register user
	// PostMapping("/do_register") this is also same.
	@RequestMapping(value = "/do_register",method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1,@RequestParam(value = "agreement",defaultValue = "false")boolean agreement,Model model,HttpSession session)
	{
		// if Binding result is declare in the last after httpsession then changes not reflected in page so paste it in after user model attribute
		try 
		{
			if(result1.hasErrors())
			{
				System.out.println("Error "+result1.toString());
				model.addAttribute("user", user);
				return "signup";
			}
			if(!agreement)
			{
				System.out.println("you have not agreed the terms and condition !!");
				throw new Exception("You have not agreed the terms and condition !!");
			}			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			System.out.println("Agreement "+agreement);
			System.out.println("User "+user);
			userRepository.save(user);
			//new user() for when register and hit submit button then form clean and ready for again register.
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
			return "signup";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new  Message("Something went wrong !! "+e.getMessage(), "alert-danger"));
			return "signup";
		}	
	}
	
	// handler for the custom login
	@GetMapping("/signin")
	public String customLogin(Model model)
	{
		model.addAttribute("title", "Login Page");
		return "login";
	}
}