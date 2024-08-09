package com.patricklima.myapp.notifications.dto;

import java.time.LocalDateTime;

import com.patricklima.myapp.notifications.entities.MessageDispatch;

public class MessageDispatchViewDto {
	UserViewDto user;
	NotificationChannelViewDto channel;
	LocalDateTime createdAt;
	LocalDateTime deliveredAt;

	public MessageDispatchViewDto() {
	}

	public MessageDispatchViewDto(MessageDispatch messageDispatch) {
		user = new UserViewDto(messageDispatch.getUser());
		channel = new NotificationChannelViewDto(messageDispatch.getChannel());
		createdAt = messageDispatch.getCreatedAt();
		deliveredAt = messageDispatch.getDeliveredAt();
	}

	public UserViewDto getUser() {
		return user;
	}

	public void setUser(UserViewDto user) {
		this.user = user;
	}

	public NotificationChannelViewDto getChannel() {
		return channel;
	}

	public void setChannel(NotificationChannelViewDto channel) {
		this.channel = channel;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(LocalDateTime deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
}
