package com.techzone.springmvc.entity;

import java.io.Serializable;

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
@Table(name = "billdetails")
public class BillDeTail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "quantity" , nullable = false)
	private int quantity;
	
	@Column(name = "singlePrice")
	private long singlePrice;
	
	@Column(name = "salePercent")
	private long salePercent;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.DETACH)
	@JoinColumn(name = "bill_id")
	private Bill bill;
	
	public BillDeTail() {
		
	}

	public BillDeTail(int quantity, long singlePrice, long salePercent, Product product, Bill bill) {
		super();
		this.quantity = quantity;
		this.singlePrice = singlePrice;
		this.salePercent = salePercent;
		this.product = product;
		this.bill = bill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(long singlePrice) {
		this.singlePrice = singlePrice;
	}

	public long getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(long salePercent) {
		this.salePercent = salePercent;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
}
