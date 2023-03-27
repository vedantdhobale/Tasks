package com.blog.service;

import java.util.List;

import com.blog.payload.CategoryDto;

public interface CategoryService {

	// create

	CategoryDto createCategory(CategoryDto categoryDto);

	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// delete

	void deleteCategory(Integer categoryId);
	// get

	CategoryDto getCategoryById(Integer categoryId);

	// getall

	List<CategoryDto> getAllCategory();

}
