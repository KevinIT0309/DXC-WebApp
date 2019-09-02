package com.techzone.springmvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.springmvc.entity.Customer;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.repository.CustomerRepository;
import com.techzone.springmvc.service.CustomerService;

@Service
@Transactional // FOR HIBERNATE
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer getCustomer(int theId) throws ResourceNotFoundException {
		return customerRepository.findById(theId).orElseThrow(()-> new ResourceNotFoundException(theId));
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}

}
