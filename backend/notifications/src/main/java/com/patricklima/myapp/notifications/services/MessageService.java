package com.patricklima.myapp.notifications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.patricklima.myapp.notifications.dto.CreateMessageRequest;
import com.patricklima.myapp.notifications.entities.Message;
import com.patricklima.myapp.notifications.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;

	public Message createMessage(CreateMessageRequest request) {
		Message message = new Message(request.body, request.categoryId);

		message = messageRepository.save(message);

		return message;
	}

	public List<Message> getMessages() {
		return messageRepository.findAll(Sort.by("createdAt").descending());
	}
}
