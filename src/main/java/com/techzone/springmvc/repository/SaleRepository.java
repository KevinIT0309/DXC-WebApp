package com.techzone.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.Sale;

@Repository("saleRepository")
public interface SaleRepository extends JpaRepository<Sale,Integer>{

}
