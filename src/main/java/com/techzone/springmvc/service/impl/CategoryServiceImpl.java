package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.Category;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.repository.CategoryRepository;
import com.techzone.springmvc.service.CategoryService;

@Service
//@PersistenceContext(type = PersistenceContextType.EXTENDED)
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public Category getCategory(int theId) throws ResourceNotFoundException {
		return categoryRepository.findById(theId).orElseThrow(()-> new ResourceNotFoundException(theId));
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Category> getCategorys() {
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCategory(Category theCategory) {
		categoryRepository.save(theCategory);
		
	}

	@Override
	@Transactional
	public void deleteCategory(int theId) {
		categoryRepository.deleteById(theId);
		
	}

}
