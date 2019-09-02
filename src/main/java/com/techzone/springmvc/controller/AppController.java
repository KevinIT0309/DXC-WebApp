package com.techzone.springmvc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.service.ProductService;

@Controller
@RequestMapping("/")
public class AppController {
	
	// TODO : Dependency Injection
	@Autowired
	private ProductService productService;
	// TODO : Dependency Injection
	
	
	
	@GetMapping("/product{productId}")
	public ModelAndView goPageInfoProduct(@RequestParam("productId") int theId , ModelAndView theModel , HttpServletResponse httpServletResponse ) throws ResourceNotFoundException {
		theModel.addObject("product", productService.getProduct(theId));
		theModel.setViewName("/shopping/info-product");
		return theModel;
	}
	

}
