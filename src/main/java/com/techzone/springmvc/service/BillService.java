package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.Bill;

public interface BillService {

	public void saveBill(Bill theBill);
	
	public Bill getBill(int theBillId);
	
	public List<Bill> getBills();
	
	public void setShipSuccess(Bill theBill);
	
	public void setShipCancel(Bill theBill);
}
