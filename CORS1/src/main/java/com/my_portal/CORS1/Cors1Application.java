package com.my_portal.CORS1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
/* @CrossOrigin(origins="*") */
public class Cors1Application {
	// This is Method level cross origin policy
	// if we want to this on class level then use @CrossOrigin(origins="*") in after
	// controller.
	@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping("/access")
	public String greeting() {
		return "Welcome to Spring CORS";
	}

	public static void main(String[] args) {
		SpringApplication.run(Cors1Application.class, args);
	}

	// if we use this for B2B (Business-To-Business) then must enable this
	/*
	 * @Bean public WebMvcConfigurer configure() { return new WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/*").allowedOrigins("http://localhost:9090"); } };
	 * 
	 * }
	 */

	// This is for you make application and deploy to customer and set his/her
	// domain in cross origin so that he/she used this.
}
