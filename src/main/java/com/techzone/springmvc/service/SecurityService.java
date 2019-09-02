package com.techzone.springmvc.service;

public interface SecurityService {
	
	public String findLoggedInUsername();
	
	public void autoLogin(String username , String password);

}
