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

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "bills")
@Proxy(lazy = false) // add to set ship status by error proxy
public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "billId")
	private String billId;
	
	@Column(name = "dateOrder" , nullable = false)
	private String dateOrder;
	
	@Column(name = "total" , nullable = false)
	private Long total;
	
	@Column(name = "revenue" , nullable = false)
	private Long revenue;
	
	@Column(name = "shipStatus" , nullable = false)
	private String shipStatus;
	
	@Column(name = "address" , nullable = false)
	private String address;
	
	@Column(name = "phone" , nullable = false)
	private String phone;
	
	@Column(name = "note")
	private String note;
	
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer" , nullable = false)
	private Customer customer;
	
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee" , nullable = false)
	private User employee;

	public Bill() {
		
	}

	public Bill(String billId, String dateOrder, Long total, Long revenue, String shipStatus, String address,
			String phone, String note, Customer customer, User employee) {
		super();
		this.billId = billId;
		this.dateOrder = dateOrder;
		this.total = total;
		this.revenue = revenue;
		this.shipStatus = shipStatus;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.customer = customer;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getRevenue() {
		return revenue;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}


}
