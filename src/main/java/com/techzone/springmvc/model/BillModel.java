package com.techzone.springmvc.model;

import java.io.Serializable;

import com.techzone.springmvc.entity.Bill;
import com.techzone.springmvc.entity.Product;

public class BillModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Bill bill;
	
	private Product product;
	
	private int quantity;
	
	public BillModel() {
		
	}

	public BillModel(Bill bill, Product product, int quantity) {
		this.bill = bill;
		this.product = product;
		this.quantity = quantity;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
