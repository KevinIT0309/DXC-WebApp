package com.techzone.springmvc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.springmvc.dao.ProductModelDao;
import com.techzone.springmvc.model.ProductModel;
import com.techzone.springmvc.service.ProductModelService;

@Service
@Transactional
public class ProductModelServiceImpl implements ProductModelService {
	
	@Autowired
	private ProductModelDao productModelDao;

	@Override
	public ProductModel getById(int theId) {
		
//		return new ProductModel(productModelDao.getById(theId),null);
		return null;
		
	}

}
