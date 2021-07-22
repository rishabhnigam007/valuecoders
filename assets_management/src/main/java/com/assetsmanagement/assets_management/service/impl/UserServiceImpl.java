package com.assetsmanagement.assets_management.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.assetsmanagement.assets_management.entity.User;
import com.assetsmanagement.assets_management.repository.UserRepository;
import com.assetsmanagement.assets_management.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User register(@RequestBody User user) 
	{
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> listAll() 
	{
		return this.userRepository.listAll();
	}

	@Override
	public void getUserByUserName(String userName)
	{
		this.userRepository.getUserByUserName(userName)	;
	}

	@Override
	public Object findById(Integer uid) 
	{
		return this.userRepository.findById(uid).get();
	}

	@Override
	public void delete(User deleteUser) 
	{
		this.userRepository.delete(deleteUser);
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getCustomer(@Valid User user) 
	{
		return (User)this.userRepository.getOne(user.getUid());
	}

}