package com.techzone.springmvc.controller.manager;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techzone.springmvc.entity.Category;
import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.service.CategoryService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;

@Controller
@RequestMapping(value= {"/admin/category","/staff/category"})
public class CategoryController {
	
	// TODO : Dependency Injection
	@Autowired
	private CategoryService categoryService;
	
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
    		return "redirect:/admin/category/list";
    	}
    	return "redirect:/staff/category/list";
    }
	
	@GetMapping("/list")
	public String listCategory(Model theModel) {
		
		List <Category> theCategorys = categoryService.getCategorys();
		theModel.addAttribute("categorys", theCategorys);
		return "/admin/list-categorys";
		
	}
	
	@GetMapping("/showForm")
	public String showFormCategory(ModelMap theModel) {
		
		Category theCategory = new Category();
		theModel.addAttribute("categoryModel", theCategory);
		
		return "/admin/form-category";
		
	}
	
	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute Category theCategory , ModelMap theModel) {
		
		categoryService.saveCategory(theCategory);
		
    	if (checkAdminAccess() == true) {
    		return "redirect:/admin/category/list";
    	}
    	return "redirect:/staff/category/list";
		
	}
	
	@GetMapping("/delete")
	public String deleteCategory(@RequestParam("categoryId") int theId) {
		
		categoryService.deleteCategory(theId);
		
    	if (checkAdminAccess() == true) {
    		return "redirect:/admin/category/list";
    	}
    	return "redirect:/staff/category/list";
		
	}
	
	@GetMapping("/update")
	public String updateCategory(@RequestParam("categoryId") int theId , ModelMap theModel) throws ResourceNotFoundException {
		
		Category theCategory = categoryService.getCategory(theId);
		theModel.addAttribute("categoryModel", theCategory);
		
		return "/admin/form-category";
		
	}
	
	
	

}
