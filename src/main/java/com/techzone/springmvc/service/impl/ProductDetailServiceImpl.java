package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.ProductDetail;
import com.techzone.springmvc.repository.ProductDetailRepository;
import com.techzone.springmvc.service.ProductDeTailService;

@Service
public class ProductDetailServiceImpl implements ProductDeTailService {
	
	@Autowired
	private ProductDetailRepository productDetailRepository;

	@Override
	@Transactional
	public void saveProductDetail(ProductDetail theProductDetail) {
		productDetailRepository.save(theProductDetail);
	}

	@Override
	@Transactional
	public void deleteProductDetailByProductId(int theProductId) {
//		productDetailRepository.deleteById(theId);
		List<ProductDetail> list = productDetailRepository.findAll();
		for (int i = 0 ; i < list.size() ; i++) {
			if (list.get(i).getProduct().getId() == theProductId) {
				productDetailRepository.delete(list.get(i));
				break;
			}
		}
		
	}

	@Override
	@Transactional
	public void updateProductDetail(ProductDetail theProductDetail) {
		productDetailRepository.saveAndFlush(theProductDetail);
	}
	


}
