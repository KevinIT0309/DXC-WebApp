package com.techzone.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository < Product,Integer > {

	Product findProductByName(String nameProduct);
	
}
