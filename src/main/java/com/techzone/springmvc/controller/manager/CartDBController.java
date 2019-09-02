package com.techzone.springmvc.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techzone.springmvc.entity.CartDB;
import com.techzone.springmvc.service.CartDBService;

@Controller
@RequestMapping("/admin/cartdb")
public class CartDBController {
	
	// TODO : Dependency Injection
	@Autowired
	private CartDBService cartDBService;
	// TODO : Dependency Injection
	
	@GetMapping("")
	public String handleOrigin() {
		return "redirect:/admin/cartdb/list";
	}
	
	@GetMapping("/list")
	public String listCartDB(ModelMap theModel) {
		List <CartDB> cartDBs = cartDBService.getCartDBs();
		theModel.addAttribute("cartDBs", cartDBs);
		return "/admin/list-cartdb";
	}

}