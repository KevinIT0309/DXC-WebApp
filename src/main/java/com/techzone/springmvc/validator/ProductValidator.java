package com.techzone.springmvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.techzone.springmvc.entity.Product;
import com.techzone.springmvc.model.ProductModel;
import com.techzone.springmvc.service.ProductService;

@Component
public class ProductValidator implements Validator {
	
	@Autowired
	private ProductService productService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		ProductModel productModel = (ProductModel)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.name", "ProductModel.NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.price", "ProductModel.NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productDetail.info", "ProductModel.NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productDetail.warranty", "ProductModel.NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.inventory", "ProductModel.NotEmpty");
		
		if (productModel.getProduct().getPrice() <= 0) {
			errors.rejectValue("product.price", "ProductModel.Price");
		}
		if (productModel.getProduct().getInventory() <= 0) {
			errors.rejectValue("product.inventory", "ProductModel.Inventory");
		}

//		if ( productModel.getProduct().getName().compareTo("") == 0) {
//			String nameProduct = productModel.getProduct().getName();
//			if (productService.findProductByName(nameProduct) != null) {
//				errors.rejectValue("product.name", "ProductModel.Duplicate");
//			}
//		}
//		if (productModel.getImages().size() == 0) {
//			errors.rejectValue("images", "ProductModel.FileSelected");
//		}
		
	}

}
