package com.patricklima.myapp.notifications.controllers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patricklima.myapp.notifications.dto.CreateMessageRequest;
import com.patricklima.myapp.notifications.dto.MessageViewDto;
import com.patricklima.myapp.notifications.entities.Message;
import com.patricklima.myapp.notifications.services.MessageDispatchService;
import com.patricklima.myapp.notifications.services.MessageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/messages")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageDispatchService messageDispatchService;

	@GetMapping
	@Operation(summary = "List all messages on the system", responses = {
			@ApiResponse(responseCode = "200", description = "Success")

	})
	public ResponseEntity<List<MessageViewDto>> listMessages() {
		List<Message> messages = messageService.getMessages();
		List<MessageViewDto> response = new LinkedList<MessageViewDto>();

		for (Iterator<Message> iterator = messages.iterator(); iterator.hasNext();) {
			Message message = iterator.next();
			response.add(new MessageViewDto(message));
		}

		return ResponseEntity.ok(response);
	}

	@PostMapping
	@Operation(summary = "Creates a message and triggers its delivery", responses = {
			@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	public ResponseEntity<Message> createMessage(@RequestBody CreateMessageRequest request) {
		Message newMessage = messageService.createMessage(request);
		messageDispatchService.sendMessageNotifications(newMessage);
		return ResponseEntity.status(201).body(newMessage);
	}
	
	@GetMapping("{messageId}")	
	@Operation(summary = "Return complete data for a message", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Bad request"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	public ResponseEntity<Message> getMessage(@RequestParam Long messageId) {
		Optional<Message> message = messageService.getMessage(messageId);
		
		if(message.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(message.get());
	}
}
