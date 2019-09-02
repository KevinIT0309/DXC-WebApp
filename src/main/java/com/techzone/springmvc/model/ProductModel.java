package com.techzone.springmvc.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.techzone.springmvc.entity.Product;
import com.techzone.springmvc.entity.ProductDetail;

/** MODEL **/
public class ProductModel implements Serializable {
	
	private static final long serialVersionUID = 74458L;

	private Product product;

	private ProductDetail productDetail;
	
	private List<MultipartFile> images;
	

	public ProductModel() {

	}

	public ProductModel(Product product, ProductDetail productDetail, List<MultipartFile> images) {
		super();
		this.product = product;
		this.productDetail = productDetail;
		this.images = images;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public ProductDetail getProductDetail() {
		return productDetail;
	}


	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}


	public List<MultipartFile> getImages() {
		return images;
	}


	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

}
