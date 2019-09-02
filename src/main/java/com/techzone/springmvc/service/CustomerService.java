package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.Customer;
import com.techzone.springmvc.exception.ResourceNotFoundException;

public interface CustomerService {
	
	public Customer getCustomer(int theId) throws ResourceNotFoundException;
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(int theId);

}
