package com.patricklima.myapp.notifications.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
	
	@GetMapping()
	public String hello() {
		return "Hello, dear";
	}
	
}
