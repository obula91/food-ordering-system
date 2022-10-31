package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodControoller {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBAckMethod() {
		return "User service taking long time please wait ........";
	}
	
	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallBAckMethod() {
		return "department service taking long time please wait ........";
	}
}
