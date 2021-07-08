package com.assetsmanagement.assets_management.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.assetsmanagement.assets_management.entity.User;

public interface UserService 
{
	public User register(@RequestBody User user);

	public List<User> listAll();

	public void getUserByUserName(String userName);

	public Object findById(Integer uid);

	public void delete(User deleteUser);
}