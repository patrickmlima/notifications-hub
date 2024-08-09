package com.patricklima.myapp.notifications.dto;

import com.patricklima.myapp.notifications.entities.User;

public class UserViewDto {
	Long id;
	String name;
	
	public UserViewDto() {
		
	}
	
	public UserViewDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
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
