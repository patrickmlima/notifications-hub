package com.patricklima.myapp.notifications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patricklima.myapp.notifications.entities.Category;
import com.patricklima.myapp.notifications.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> listCategories() {
		return categoryRepository.findAll();
	}
}
