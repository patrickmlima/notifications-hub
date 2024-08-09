package com.patricklima.myapp.notifications.dto;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.patricklima.myapp.notifications.entities.Message;
import com.patricklima.myapp.notifications.entities.MessageDispatch;

public class MessageDetailDto {
	Long id;
	String body;
	CategoryViewDto category;
	LocalDateTime createdAt;

	List<MessageDispatchViewDto> messageDispatches;
	
	public MessageDetailDto(Message message) {
		this.id = message.getId();
		this.body = message.getBody();
		this.category = new CategoryViewDto(message.getCategory());
		this.createdAt = message.getCreatedAt();
		
		messageDispatches = new LinkedList<MessageDispatchViewDto>();
		for(MessageDispatch messageDispatch : message.getMessageDispatches()) {
			messageDispatches.add(new MessageDispatchViewDto(messageDispatch));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public CategoryViewDto getCategory() {
		return category;
	}

	public void setCategory(CategoryViewDto category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<MessageDispatchViewDto> getMessageDispatches() {
		return messageDispatches;
	}

	public void setMessageDispatches(List<MessageDispatchViewDto> messageDispatches) {
		this.messageDispatches = messageDispatches;
	}
}
