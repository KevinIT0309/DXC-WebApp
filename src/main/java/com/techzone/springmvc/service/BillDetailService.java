package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.BillDeTail;

public interface BillDetailService {
	
	public void saveBillDetail(BillDeTail theBillDetail);
	
	public List<BillDeTail> getBillDetails();
	
	public List<BillDeTail> getBillDetailByBillId(int theBillId);

}
