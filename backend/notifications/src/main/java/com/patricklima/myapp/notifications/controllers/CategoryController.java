package com.patricklima.myapp.notifications.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patricklima.myapp.notifications.dto.CategoryViewDto;
import com.patricklima.myapp.notifications.entities.Category;
import com.patricklima.myapp.notifications.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	@Operation(summary = "List all categories", responses = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public ResponseEntity<List<CategoryViewDto>> listCategories() {
		List<Category> categories = categoryService.listCategories();
		
		List<CategoryViewDto> response = new LinkedList<CategoryViewDto>();
		for (Category category : categories) {
			response.add(new CategoryViewDto(category));
		}
		
		return ResponseEntity.ok(response);
	}
}
