package com.gd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "Spring Boot, reporting for duty!<br><a href='http://localhost:8181/actuator/health/custom'>http://localhost:8181/actuator/health/custom</a>";
	}

}
