package com.librarymanagement.library_management.controller;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.librarymanagement.library_management.dao.UserRepository;
import com.librarymanagement.library_management.entity.User;
import com.librarymanagement.library_management.helper.Message;

@Controller
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// method for all common response
	@ModelAttribute
	public void addCommonData(Model model,Principal principle)
	{
		String userName=principle.getName();
		System.out.println("ADMIN "+userName);
		
		User user=userRepository.getUserByUserName(userName);
		System.out.println("ADMIN "+user);
		
		// This is for new user
		model.addAttribute("user", new User());
	}
	
	@RequestMapping(value = "/index" ,method = RequestMethod.GET)
	public String dashboard(Model model,Principal principal)
	{
		model.addAttribute("title", "Admin DashBoard");
		return "admin/admin_dashboard";
	}
	
	@GetMapping("/show-librarian")
	public String showLibrarians(Model model,Principal principal)
	{
		model.addAttribute("title", "All Librarians");
		
		List<User> users=this.userRepository.findAll();
		
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getRole().equalsIgnoreCase("ROLE_ADMIN"))
				users.remove(i);
		}

		model.addAttribute("users", users);
		
		return "admin/show_librarians";
	}
	
	@RequestMapping("/add-librarian")
	public String openAddLibrarianForm(Model model)
	{
		model.addAttribute("title", "Add Librarian");
		
		return "admin/add_librarian_form";
	}
	
	@RequestMapping(value = "/do_register_librarian",method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1,@RequestParam(value = "agreement",defaultValue = "false")boolean agreement,Model model,HttpSession session)
	{
		// if Binding result is declare in the last after httpsession then changes not reflected in page so paste it in after user model attribute
		try 
		{
			model.addAttribute("title", "Add Librarian");
			if(result1.hasErrors())
			{
				System.out.println("Error "+result1.toString());
				model.addAttribute("user", user);
				return "admin/add_librarian_form";
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
			session.setAttribute("message", new Message("Successfully Registered !!", "success"));
			return "admin/add_librarian_form";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new  Message("Something went wrong !!"+e.getMessage(), "danger"));
			return "admin/add_librarian_form";
		}	
	}	
	
	@RequestMapping("/delete-librarian")
	public String deleteLibrarianForm(Model model)
	{
		model.addAttribute("title", "Delete Librarian");
		
		List<User> users=this.userRepository.findAll();
		
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getRole().equalsIgnoreCase("ROLE_ADMIN"))
				users.remove(i);
		}

		model.addAttribute("users", users);
		
		return "admin/delete_librarian_form";
	}
	
	@GetMapping("/delete-librarian/{id}")
	@Transactional
	public String deleteLibrarian(@PathVariable("id") Integer id,Model model,HttpSession session,Principal principal)
	{
		User deleteUser=this.userRepository.findById(id).get();
		
		this.userRepository.delete(deleteUser);
		
		session.setAttribute("message", new Message("Librarian deleted successfully !!", "success"));
		return "redirect:/admin/delete-librarian";
	}
	
}