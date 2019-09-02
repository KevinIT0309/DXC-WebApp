package com.techzone.springmvc.model;

import java.util.List;

import com.techzone.springmvc.entity.User;

/** MODEL **/
public class UserModel {
	
	private User user;
	
	private List<String> roles;
	
	public UserModel() {
		
	}

	public UserModel(User user, List<String> roles) {
		super();
		this.user = user;
		this.roles = roles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
