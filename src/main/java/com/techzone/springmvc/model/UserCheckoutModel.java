package com.techzone.springmvc.model;

import java.io.Serializable;

import com.techzone.springmvc.entity.User;

/** MODEL **/
public class UserCheckoutModel implements Serializable {
	
	private static final long serialVersionUID = 74458L;

	private User user;
	
	private String phone;
	
	private String city;
	
	private String address;
	
	private String note;
	
	public UserCheckoutModel() {
		
	}

	public UserCheckoutModel(User user, String phone, String city, String address, String note) {
		super();
		this.user = user;
		this.phone = phone;
		this.city = city;
		this.address = address;
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
