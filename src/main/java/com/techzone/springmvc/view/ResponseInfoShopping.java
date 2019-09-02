package com.techzone.springmvc.view;

import java.util.List;

import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.model.ItemModel;

/** RESPONSE INFO SHOPPING **/
public class ResponseInfoShopping {
	
	private String billId;
	
	private User user;
	
	private List <ItemModel> items;
	
	private long readyMoney;
	
	public ResponseInfoShopping() {
		
	}

	public ResponseInfoShopping(String billId, User user, List<ItemModel> items, long readyMoney) {
		super();
		this.billId = billId;
		this.user = user;
		this.items = items;
		this.readyMoney = readyMoney;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ItemModel> getItems() {
		return items;
	}

	public void setItems(List<ItemModel> items) {
		this.items = items;
	}

	public long getReadyMoney() {
		return readyMoney;
	}

	public void setReadyMoney(long readyMoney) {
		this.readyMoney = readyMoney;
	}

}
