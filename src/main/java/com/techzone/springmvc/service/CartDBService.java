package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.CartDB;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.model.ItemModel;
import com.techzone.springmvc.model.UserCheckoutModel;
import com.techzone.springmvc.view.ResponseInfoShopping;

public interface CartDBService {
	
	public List<CartDB> getCartDBByUserId(int theUserId);
	
	public List<CartDB> getCartDBByProductId(int theProductId);
	
	public List<CartDB> getCartDBs();
	
	public List<ItemModel> getItemsInCartDB();
	
	public boolean addCart(int thePorductId);
	
	public boolean removeProductInCart(int theProductId);
	
	public void clearCartInSession();
	
	public void clearCartFromCartDBByUserId(int theUserId);
	
	public ResponseInfoShopping buy(User theUser , UserCheckoutModel theUserCheckoutModel , boolean isAuthenticated);
}
