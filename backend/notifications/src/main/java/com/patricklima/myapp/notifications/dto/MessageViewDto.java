package com.patricklima.myapp.notifications.dto;

import java.time.LocalDateTime;

import com.patricklima.myapp.notifications.entities.Category;
import com.patricklima.myapp.notifications.entities.Message;

public class MessageViewDto {
	private String body;
	private CategoryViewDto category;
	private LocalDateTime createdAt;
	
	public MessageViewDto(Message message) {
		this.body = message.getBody();
		this.createdAt = message.getCreatedAt();
		Category category = message.getCategory();
		this.category = new CategoryViewDto(category.getId(), category.getName());
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
	
	
}
