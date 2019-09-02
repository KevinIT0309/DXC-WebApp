package com.techzone.springmvc.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name = "products")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Size(max = 65)
	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "inventory")
	private long inventory;
	

	@OneToOne(mappedBy = "product" , cascade = CascadeType.ALL /*, fetch = FetchType.LAZY */)
	private ProductDetail productDetail;
	
	@OneToMany(mappedBy = "product" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Image> images;
	
//	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH} , fetch = FetchType.EAGER , optional = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id" , nullable = false)
	private Category category;
	
//	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH} , fetch = FetchType.EAGER , optional = false)
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id" , nullable = false)
	private Brand brand;
	
//	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH} , fetch = FetchType.EAGER , optional = false)
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sale_id" , nullable = false)
	private Sale sale;
	
	public Product() {
		
	}
	

	public Product(int id, String name, long price, long inventory, ProductDetail productDetail, List<Image> images,
			Category category, Brand brand, Sale sale) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		this.productDetail = productDetail;
		this.images = images;
		this.category = category;
		this.brand = brand;
		this.sale = sale;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getInventory() {
		return inventory;
	}

	public void setInventory(long inventory) {
		this.inventory = inventory;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	
	public List<Image> getImages() {
		return images;
	}


	public void setImages(List<Image> images) {
		this.images = images;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

} // End Class //
