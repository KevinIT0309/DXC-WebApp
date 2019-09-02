package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.Sale;
import com.techzone.springmvc.exception.ResourceNotFoundException;

public interface SaleService {
	
	public Sale getSale(int theId) throws ResourceNotFoundException;
	
	public List<Sale> getSales();
	
	public void saveSale(Sale theSale);
	
	public void deleteSale(int theId);
	

}
