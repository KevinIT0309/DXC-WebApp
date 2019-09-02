package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.Brand;
import com.techzone.springmvc.exception.ResourceNotFoundException;

public interface BrandService {
	
	public Brand getBrand(int theId) throws ResourceNotFoundException;
	
	public List<Brand> getBrands();
	
	public void saveBrand(Brand theBrand);
	
	public void deleteBrand(int theId);

}
