package com.javamailsender.java_mail_sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JavaMailSenderApplication
{
	
	@Autowired
	private SendEmailService sendEmailService;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(JavaMailSenderApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerWhenStarts()
	{
		sendEmailService.sendEmail("rishabhakans@gmail.com", "Hi There !!", "Test");
	}

}
