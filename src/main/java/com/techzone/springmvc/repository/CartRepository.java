package com.techzone.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.CartDB;

@Repository("cartRepository")
public interface CartRepository extends JpaRepository<CartDB,Integer> {

	List <CartDB> findAllCartDBsByUserId(int theUserId);
	
	List <CartDB> findAllCartDBsByProductId(int theProductId);
	
	
}
