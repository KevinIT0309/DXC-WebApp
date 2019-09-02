package com.techzone.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name = "product_details")
@Cacheable
public class ProductDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "warranty")
	private long warranty;
	
	@NotNull
	@Size(max = 5000)
	@Column(name = "info")
	private String info;
	
	@Column(name = "image")
	private String image;

	// test
	@OneToOne/*(fetch = FetchType.LAZY,optional = false)*/
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	public ProductDetail() {
		
	}

	public ProductDetail(int id, long warranty, String info, String image, Product product) {
		super();
		this.id = id;
		this.warranty = warranty;
		this.info = info;
		this.image = image;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getWarranty() {
		return warranty;
	}

	public void setWarranty(long warranty) {
		this.warranty = warranty;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
