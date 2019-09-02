package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.springmvc.entity.Brand;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.repository.BrandRepository;
import com.techzone.springmvc.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand getBrand(int theId) throws ResourceNotFoundException {
		return brandRepository.findById(theId).orElseThrow(()-> new ResourceNotFoundException(theId));
	}

	@Override
	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}

	@Override
	public void saveBrand(Brand theBrand) {
		brandRepository.save(theBrand);
		
	}

	@Override
	public void deleteBrand(int theId) {
		brandRepository.deleteById(theId);
		
	}

}
