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

import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.Sale;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.service.SaleService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;

@Controller
@RequestMapping(value= {"/admin/sale","/staff/sale"})
public class SaleController {
	
	// TODO : Dependency Injection
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private UserService userService;
	// TODO : Dependency Injection
	
	
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
    		return "redirect:/admin/sale/list";
    	}
    	return "redirect:/staff/sale/list";
    }
	
	@RequestMapping("/list")
	public String listSale(ModelMap theModel) {
		List <Sale> sales = saleService.getSales();
		
		theModel.addAttribute("sales", sales);
		
		return "/admin/list-sale";
	}
	
	@GetMapping("/showForm")
	public String showFormSale(ModelMap theModel) {
		
		Sale sale = new Sale();
		
		theModel.addAttribute("saleModel", sale);
		
		return "/admin/form-sale";
		
	}
	
	@PostMapping("/saveSale")
	public String saveSale(@ModelAttribute Sale theSale) {
		
		saleService.saveSale(theSale);
		
    	if (checkAdminAccess() == true) {
    		return "redirect:/admin/sale/list";
    	}
    	return "redirect:/staff/sale/list";
		
	}
	
	@GetMapping("/delete")
	public String deleteSale(@RequestParam("saleId") int theId) {
		
		saleService.deleteSale(theId);
		
    	if (checkAdminAccess() == true) {
    		return "redirect:/admin/sale/list";
    	}
    	return "redirect:/staff/sale/list";
	}
	
	@GetMapping("/update")
	public String updateSale(@RequestParam("saleId") int theId , ModelMap theModel) throws ResourceNotFoundException {
		
		Sale theSale = saleService.getSale(theId);
		
		theModel.addAttribute("saleModel", theSale);
		
		return "/admin/form-sale";
		
	}

}
