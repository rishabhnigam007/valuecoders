package com.assetsmanagement.assets_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assetsmanagement.assets_management.entity.User;
import com.assetsmanagement.assets_management.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	// method for all common response
	
	@GetMapping("/list-customer")
	public ResponseEntity<Object> listCustomer()
	{
		List<User> users=this.userService.listAll();
		return ResponseEntity.ok(users);
	}
	
//	@RequestMapping("/add-librarian")
//	public String openAddLibrarianForm(Model model)
//	{
//		model.addAttribute("title", "Add Librarian");
//		
//		return "admin/add_librarian_form";
//	}
	
//	@RequestMapping("/delete-librarian")
//	public String deleteLibrarianForm(Model model)
//	{
//		model.addAttribute("title", "Delete Librarian");
//		
//		List<User> users=this.userRepository.findAll();
//		
//		for(int i=0;i<users.size();i++)
//		{
//			if(users.get(i).getRole().equalsIgnoreCase("ROLE_ADMIN"))
//				users.remove(i);
//		}
//
//		model.addAttribute("users", users);
//		
//		return "admin/delete_librarian_form";
//	}
//	
//	@GetMapping("/delete-librarian/{id}")
//	@Transactional
//	public String deleteLibrarian(@PathVariable("id") Integer id,Model model,HttpSession session,Principal principal)
//	{
//		User deleteUser=this.userRepository.findById(id).get();
//		
//		this.userRepository.delete(deleteUser);
//		
//		return "redirect:/admin/delete-librarian";
//	}
	
}