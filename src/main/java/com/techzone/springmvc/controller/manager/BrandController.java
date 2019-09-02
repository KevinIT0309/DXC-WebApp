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

import com.techzone.springmvc.entity.Brand;
import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.service.BrandService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;

@Controller
@RequestMapping(value= {"/admin/brand","/staff/brand"})
public class BrandController {
	
	// TODO : Dependency Injection
	@Autowired
	private BrandService brandService;
	
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
    		return "redirect:/admin/brand/list";
    	}
    	return "redirect:/staff/brand/list";
    }
	
	@GetMapping("/list")
	public String listBrand(ModelMap theModel) {
		
		List <Brand> brands = brandService.getBrands();
		
		theModel.addAttribute("brands", brands);
		
		return "/admin/list-brand";
		
	}
	
	@GetMapping("/showForm")
	public String showFormBrand(ModelMap theModel) {
		
		Brand theBrand = new Brand();
		
		theModel.addAttribute("brandModel", theBrand);
		
		return "/admin/form-brand";
		
	}
	
	
	@PostMapping("/saveBrand")
	public String saveBrand(@ModelAttribute Brand theBrand) {
		
		brandService.saveBrand(theBrand);
		
		if (checkAdminAccess() == true) {
    		return "redirect:/admin/brand/list";
    	}
    	return "redirect:/staff/brand/list";
		
	}
	
	@GetMapping("/delete")
	public String deleteBrand(@RequestParam("brandId") int theId) {
		
		brandService.deleteBrand(theId);
		
		if (checkAdminAccess() == true) {
    		return "redirect:/admin/brand/list";
    	}
    	return "redirect:/staff/brand/list";
	}
	
	@GetMapping("/update")
	public String updateBrand(@RequestParam("brandId") int theId , ModelMap theModel) throws ResourceNotFoundException {
		Brand theBrand = brandService.getBrand(theId);
		
		theModel.addAttribute("brandModel", theBrand);
		
		return "/admin/form-brand";
		
		
	}
	

}
