package com.techzone.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.model.UserCheckoutModel;
import com.techzone.springmvc.service.CartDBService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;
import com.techzone.springmvc.validator.UserCheckoutValidator;
import com.techzone.springmvc.view.ResponseInfoShopping;

@Controller
@RequestMapping("/cart")
public class CartController { // handle in user

	// TODO : Dependency Injection
	@Autowired
	private UserService userService;

	@Autowired
	private UserCheckoutValidator userCheckoutValidator;

	@Autowired
	private CartDBService cartDBService;
	// TODO : Dependency Injection

	@GetMapping("")
	public String cartPage(ModelMap theModel, HttpServletRequest request) throws ResourceNotFoundException {

		theModel.addAttribute("cart", cartDBService.getItemsInCartDB());
		return "/shopping/cart";
	}

	@GetMapping("/addProductToCart")
	public String addProductToCart(@RequestParam("productId") int theProductId, ModelMap theModel) {
		if (cartDBService.addCart(theProductId)) {
			return "redirect:/cart";
		}
		return "redirect:/";
	}
	
	@GetMapping("/clearCart")
	public String clearCart() {
		
		if (isCurrentAuthentication()) { // User Authentication
			
			cartDBService.clearCartFromCartDBByUserId(userService.findByUsername(SecurityUtil.getPrincipal()).getId());
			
		} else { // Is Anonymous
			
			cartDBService.clearCartInSession();
		}
		return "redirect:/cart";
	}

	@GetMapping("/buy")
	public String buyCart(ModelMap theModel) {

		if (isCurrentAuthentication()) { // User Authentication
			UserCheckoutModel theUserCheckoutModel = new UserCheckoutModel();
			theUserCheckoutModel.setUser(userService.findByUsername(SecurityUtil.getPrincipal()));
			theModel.addAttribute("theUserCheckoutModel", theUserCheckoutModel);
			theModel.addAttribute("cityList", catalogCity());
			theModel.addAttribute("authenticated", isCurrentAuthentication());
		} else { // Is Anonymous
			UserCheckoutModel theUserCheckoutModel = new UserCheckoutModel();
			theUserCheckoutModel.setUser(new User());
			theModel.addAttribute("theUserCheckoutModel", theUserCheckoutModel);
			theModel.addAttribute("cityList", catalogCity());
			theModel.addAttribute("authenticated", isCurrentAuthentication());
		}

		return "/shopping/confirm-transaction-payment";
	}

	@PostMapping("/confirmPayment")
	@Transactional
	public String orderSuccess(@ModelAttribute("theUserCheckoutModel") UserCheckoutModel theUserCheckoutModel,
			BindingResult bindingResult, ModelMap theModel) {

		userCheckoutValidator.validate(theUserCheckoutModel, bindingResult);

		if (bindingResult.hasErrors()) {
			theModel.addAttribute("cityList", catalogCity());
			theModel.addAttribute("authenticated", isCurrentAuthentication());
			theModel.addAttribute("theUserCheckoutModel", theUserCheckoutModel);
			return "/shopping/confirm-transaction-payment";

		}
		
		User theUser;
		boolean isAuthenticated = false;
		
		if (isCurrentAuthentication()) { // User Authentication
			isAuthenticated = true;
			System.err.println("-------------------- INFO ODER OF USER ALREADY --------------------");
			theUser = userService.findByUsername(SecurityUtil.getPrincipal());
			System.out.println("User Name : " + theUser.getLastName());
			System.out.println("User Email : " + theUser.getEmail());
			System.out.println("User Phone : " + theUserCheckoutModel.getPhone());
			System.out.println("User City : " + theUserCheckoutModel.getCity());
			System.out.println("User Address : " + theUserCheckoutModel.getAddress());
			System.out.println("User Note : " + theUserCheckoutModel.getNote());
			System.err.println("-------------------- INFO ODER OF USER ALREADY --------------------");
		} else {
			System.err.println("-------------------- INFO ORDER NEW USER IN TRANSACTION --------------------");
			theUser = theUserCheckoutModel.getUser();
			System.out.println("User Name : " + theUser.getLastName());
			System.out.println("User Email : " + theUser.getEmail());
			System.out.println("User Phone : " + theUserCheckoutModel.getPhone());
			System.out.println("User City : " + theUserCheckoutModel.getCity());
			System.out.println("User Address : " + theUserCheckoutModel.getAddress());
			System.out.println("User Note : " + theUserCheckoutModel.getNote());
			System.err.println("-------------------- INFO ORDER NEW USER IN TRANSACTION --------------------");
		}
		
		ResponseInfoShopping theResponseInfoShopping = cartDBService.buy(theUser , theUserCheckoutModel , isAuthenticated);
		
		if (theResponseInfoShopping != null) {
			if (isAuthenticated == true) { // User Authenticated
				cartDBService.clearCartFromCartDBByUserId(theUser.getId());
			} else { // Is Anonymous
				cartDBService.clearCartInSession();
			}
			
			theModel.addAttribute("theResponseInfoShopping", theResponseInfoShopping);
		}

		return "/shopping/order-success";

	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == //
	public boolean isCurrentAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			System.err.println("USER IS ON LOGIN");
			return true; // Authenticated User
		}
		System.err.println("IS ANONYMOUS");
		return false; // Anonymous
	}

	public List<String> catalogCity() {
		List<String> city = new ArrayList<String>();
		city.add("Ho Chi Minh");
		city.add("Ha Hoi");
		city.add("Da Nang");
		city.add("Can Tho");
		city.add("Nha Trang");
		return city;
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == //

}
