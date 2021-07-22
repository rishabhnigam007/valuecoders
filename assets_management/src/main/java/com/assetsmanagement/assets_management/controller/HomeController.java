package com.assetsmanagement.assets_management.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.assetsmanagement.assets_management.entity.User;
import com.assetsmanagement.assets_management.service.UserService;

@RestController
public class HomeController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/do_register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user)
	{
		User u=this.userService.register(user);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
}