package com.techzone.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.Brand;

@Repository("brandRepository")
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
