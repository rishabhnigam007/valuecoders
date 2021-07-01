package com.librarymanagement.library_management.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.librarymanagement.library_management.dao.UserRepository;
import com.librarymanagement.library_management.entity.User;
import com.librarymanagement.library_management.helper.Message;

@RestController
public class HomeRestController 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/do_register",method = RequestMethod.POST)
	public ResponseEntity<Object> registerUser(@RequestBody User user)//,@RequestParam(value = "agreement",defaultValue = "false")boolean agreement,Model model,HttpSession session)
	{
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok(user);

	}
	
	@RequestMapping(value = "/admin/do_register_librarian",method = RequestMethod.POST)
	public ResponseEntity<Object> registerUser1(@RequestBody User user)//,@RequestParam(value = "agreement",defaultValue = "false")boolean agreement,Model model,HttpSession session)
	{
		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		userRepository.save(user);
		return ResponseEntity.ok(user);

	}
	
}