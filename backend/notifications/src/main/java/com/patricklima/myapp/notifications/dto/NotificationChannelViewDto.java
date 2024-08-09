package com.patricklima.myapp.notifications.dto;

import com.patricklima.myapp.notifications.entities.NotificationChannel;

public class NotificationChannelViewDto {
	Long id;
	String name;
	
	public NotificationChannelViewDto() {}
	
	public NotificationChannelViewDto(NotificationChannel notificationChannel) {
		this.id = notificationChannel.getId();
		this.name = notificationChannel.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
