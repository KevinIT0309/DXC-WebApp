package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.Product;
import com.techzone.springmvc.exception.ResourceNotFoundException;

public interface ProductService {
	
	public Product getProduct(int theId) throws ResourceNotFoundException;
	
	public List<Product> getProducts();
	
	public void saveProduct(Product theProduct);
	
	public void deleteProduct(int theId);
	
	public void updateProduct(Product theProduct);
	
	public Product findProductByName(String nameProduct);

}
