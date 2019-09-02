package com.techzone.springmvc.service;

import com.techzone.springmvc.entity.ProductDetail;

public interface ProductDeTailService {
	
	public void saveProductDetail(ProductDetail theProductDetail);
	
	public void deleteProductDetailByProductId(int theProductId);
	
	public void updateProductDetail(ProductDetail theProductDetail);

}
