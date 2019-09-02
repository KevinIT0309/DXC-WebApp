package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.Product;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.repository.ProductRepository;
import com.techzone.springmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	
	@Override
	@Transactional
	public Product getProduct(int theId) throws ResourceNotFoundException {
		
		return productRepository.findById(theId).orElseThrow(() -> new ResourceNotFoundException(theId));
		
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		productRepository.save(theProduct);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId){
		productRepository.deleteById(theId);
	}

	
	@Override
	@Transactional
	public void updateProduct(Product theProduct) {
		productRepository.saveAndFlush(theProduct);
		
	}

	@Override
	@Transactional
	public Product findProductByName(String nameProduct) {
		return productRepository.findProductByName(nameProduct);
	}

}
