package com.techzone.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.ProductDetail;

@Repository("productDetailRepository")
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {

}
