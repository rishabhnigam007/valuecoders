package com.spring_oauth2.spring_oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
public class UserManageConfig extends WebSecurityConfigurerAdapter
{
	@Bean
	public UserDetailsService userDetailsService() 
	{
		InMemoryUserDetailsManager user=new InMemoryUserDetailsManager();
		user.createUser(User.withUsername("Mark")
				.password("1234")
				.authorities("read").build());
		return user;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}
	
}

/*
 	
 	Testing Link for PostMan :  localhost:8080/oauth/token?grant_type=password&username=Mark&password=1234&scopes=read
  	and before select auth in and pick basic auth and give username :rishabh and password: 1234
  	and request is must be post and then hit submit then you will get access token for this. 
  
 */