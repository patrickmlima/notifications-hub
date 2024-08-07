package com.patricklima.myapp.notifications.dto;

import java.time.LocalDateTime;

import com.patricklima.myapp.notifications.entities.Message;

public class MessageViewDto {
	private Long id;
	private String body;
	private CategoryViewDto category;
	private LocalDateTime createdAt;

	public MessageViewDto(Message message) {
		this.id = message.getId();
		this.body = message.getBody();
		this.createdAt = message.getCreatedAt();
		this.category = new CategoryViewDto(message.getCategory());
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

}
