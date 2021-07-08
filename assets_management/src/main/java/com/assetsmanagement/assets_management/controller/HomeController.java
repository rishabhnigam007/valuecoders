package com.assetsmanagement.assets_management.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.assetsmanagement.assets_management.entity.User;
import com.assetsmanagement.assets_management.service.UserService;

@RestController
public class HomeController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/do_register",method = RequestMethod.POST)
	public ResponseEntity<Object> registerUser(@Valid @RequestBody User user)
	{
		User u=this.userService.register(user);
		return ResponseEntity.ok(u);
	}
}