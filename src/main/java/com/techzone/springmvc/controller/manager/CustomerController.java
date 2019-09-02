package com.techzone.springmvc.controller.manager;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techzone.springmvc.entity.Category;
import com.techzone.springmvc.entity.Customer;
import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.service.CustomerService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;

@Controller
@RequestMapping(value = {"/admin/customer","/staff/customer"})
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	
	
	public boolean checkAdminAccess() {
		User theUser = userService.findByUsername(SecurityUtil.getPrincipal());
		Set<Role> roles = theUser.getRoles();
		for (Role x : roles) {
			if (x.getRoleName().toString().equalsIgnoreCase("ADMIN")) {
				return true;
			}
		}
		return false;
	}
	
	@GetMapping("/")
	public String handleOrigin() {
		
		if (checkAdminAccess() == true) {
			return "redirect:/admin/customer/list";
		}
		return "redirect:/staff/customer/list";
	}
	
	@GetMapping("/list")
	public String listCustomer(ModelMap theModel) {
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("theCustomers", theCustomers);
		return "/admin/list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormCustomer(ModelMap theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customerModel", theCustomer);
		return "/admin/form-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer theCustomer , ModelMap theModel) {
		customerService.saveCustomer(theCustomer);
		if (checkAdminAccess() == true) {
			return "redirect:/admin/customer/list";
		}
		return "redirect:/staff/customer/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		if (checkAdminAccess() == true) {
			return "redirect:/admin/customer/list";
		}
		return "redirect:/staff/customer/list";
		
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int theId , ModelMap theModel) throws ResourceNotFoundException {
		
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customerModel", theCustomer);
		
		return "/admin/form-customer";
		
	}

}
