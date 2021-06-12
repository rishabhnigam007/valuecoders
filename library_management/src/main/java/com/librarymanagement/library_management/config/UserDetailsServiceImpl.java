package com.librarymanagement.library_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.librarymanagement.library_management.dao.UserRepository;
import com.librarymanagement.library_management.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		// fetching user from database
		
		User user=userRepository.getUserByUserName(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("could not found user !!");
		}
		
		CustomUserDetails customUserDetails=new CustomUserDetails(user);
		return customUserDetails;
	}
	
}