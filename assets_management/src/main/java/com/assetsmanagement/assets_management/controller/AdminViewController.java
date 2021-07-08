package com.assetsmanagement.assets_management.controller;

import java.security.Principal;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.assetsmanagement.assets_management.entity.User;
import com.assetsmanagement.assets_management.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminViewController 
{
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void addCommonData(Model model,Principal principle)
	{
		String userName=principle.getName();
		
		userService.getUserByUserName(userName);
		
		// This is for new Customer
		model.addAttribute("user", new User());
	}
	
	@RequestMapping(value = "/index" ,method = RequestMethod.GET)
	public String dashboard(Model model,Principal principal)
	{
		model.addAttribute("title", "Admin DashBoard");
		return "admin/admin_dashboard";
	}
	
	@GetMapping("/show-customer")
	public String showCustomers(Model model,Principal principal)
	{
		model.addAttribute("title", "All Customer");
		
		List<User> users=this.userService.listAll();
		
		model.addAttribute("users", users);
		
		return "admin/show_customers";
	}
	
	@RequestMapping("/delete-customer")
	public String deleteCustomerForm(Model model)
	{
		model.addAttribute("title", "Delete Customer");
		
		List<User> users=this.userService.listAll();

		model.addAttribute("users", users);
		
		return "admin/delete_customer_form";
	}
	
	@GetMapping("/delete-customer/{uid}")
	@Transactional
	public String deleteLibrarian(@PathVariable("uid") Integer uid)
	{
		User deleteUser=(User) this.userService.findById(uid);
		
		this.userService.delete(deleteUser);
		
		return "redirect:/admin/delete-customer";
	}
	
}