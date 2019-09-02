package com.techzone.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techzone.springmvc.service.ProductService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	// TODO : Dependency Injection
	@Autowired
	private ProductService productService;
	// TODO : Dependency Injection
	
	@GetMapping("/")
	public ModelAndView origin(ModelAndView modelAndView) {
		modelAndView.setViewName("home");
		modelAndView.addObject("listProduct", productService.getProducts());
		return modelAndView;
	}
	
	@GetMapping("/shopNow")
	public String shopNow() {
		return "techzone";
	}

	@GetMapping("/Access_Denied")
	public String accessDenied() {
		return "accessdenied";
	}

}
