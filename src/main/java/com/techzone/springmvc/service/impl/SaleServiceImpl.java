package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.springmvc.entity.Sale;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.repository.SaleRepository;
import com.techzone.springmvc.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	private SaleRepository saleRepository;

	@Override
	public Sale getSale(int theId) throws ResourceNotFoundException {
		return saleRepository.findById(theId).orElseThrow(()-> new ResourceNotFoundException(theId));
	}

	@Override
	public List<Sale> getSales() {
		return saleRepository.findAll();
	}

	@Override
	public void saveSale(Sale theSale) {
		saleRepository.save(theSale);
		
	}

	@Override
	public void deleteSale(int theId) {
		saleRepository.deleteById(theId);
		
	}

}
