package com.techzone.springmvc.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;

/** MODEL **/
@Scope("session")
public class CartModel {
	
	Map<Integer,ItemModel> items;
	
	public CartModel() {
		this.items = new HashMap<Integer, ItemModel>();
	}

	public CartModel(Map<Integer, ItemModel> items) {
		this.items = items;
	}

	public Map<Integer, ItemModel> getItems() {
		return items;
	}

	public void setItems(Map<Integer, ItemModel> items) {
		this.items = items;
	}

}
