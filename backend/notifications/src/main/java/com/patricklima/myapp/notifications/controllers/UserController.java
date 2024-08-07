package com.patricklima.myapp.notifications.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patricklima.myapp.notifications.entities.User;
import com.patricklima.myapp.notifications.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	@Operation(summary = "List all users", responses = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public List<User> listUsers() {
		return userService.getUsers();
	}
	
}
