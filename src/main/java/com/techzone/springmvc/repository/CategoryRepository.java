package com.techzone.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	

}
