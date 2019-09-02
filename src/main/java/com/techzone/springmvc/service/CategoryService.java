package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.Category;
import com.techzone.springmvc.exception.ResourceNotFoundException;

public interface CategoryService {
	
	public Category getCategory(int theId) throws ResourceNotFoundException;
	
	public List<Category> getCategorys();
	
	public void saveCategory(Category theCategory);
	
	public void deleteCategory(int theId);

}
