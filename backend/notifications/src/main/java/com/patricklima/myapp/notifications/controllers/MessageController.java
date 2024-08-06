package com.patricklima.myapp.notifications.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patricklima.myapp.notifications.dto.CreateMessageRequest;
import com.patricklima.myapp.notifications.entities.Message;
import com.patricklima.myapp.notifications.services.MessageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/messages")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@GetMapping
	@Operation(summary = "List all messages on the system", responses = {
			@ApiResponse(responseCode = "200", description = "Success")

	})
	public List<Message> listMessages() {
		return messageService.getMessages();
	}

	@PostMapping
	@Operation(summary = "Creates a message and triggers its delivery", responses = {
			@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	public Message createMessage(@RequestBody CreateMessageRequest request) {
		return messageService.createMessage(request);
	}
}
