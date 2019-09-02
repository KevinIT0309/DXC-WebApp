package com.techzone.springmvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartdb")
public class CartDB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user" , nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.DETACH)
	@JoinColumn(name = "product" , nullable = false)
	private Product product;
	
	@Column(name = "quantity" , nullable = false)
	private long quantity;
	
	@Column(name = "dateOrder" , nullable = false)
	private String dateOrder;
	
	public CartDB() {
		
	}

	public CartDB(User user, Product product, long quantity, String dateOrder) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.dateOrder = dateOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

}
