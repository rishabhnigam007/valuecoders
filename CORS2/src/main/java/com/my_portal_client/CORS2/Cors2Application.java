package com.my_portal_client.CORS2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Cors2Application {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	/*
	 * Access to XMLHttpRequest at 'http://localhost:8080/access' from origin
	 * 'http://localhost:9090' has been blocked by CORS policy: No
	 * 'Access-Control-Allow-Origin' header is present on the requested resource.
	 */

	public static void main(String[] args) {
		SpringApplication.run(Cors2Application.class, args);
	}

}
