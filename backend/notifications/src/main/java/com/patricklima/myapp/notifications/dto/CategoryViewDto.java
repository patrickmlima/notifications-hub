package com.patricklima.myapp.notifications.dto;

import com.patricklima.myapp.notifications.entities.Category;

public class CategoryViewDto {
	private Long id;
	private String name;
	
	public CategoryViewDto(Category category){
		this.id = category.getId();
		this.name = category.getName();
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
