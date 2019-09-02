package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.Bill;
import com.techzone.springmvc.repository.BillRepository;
import com.techzone.springmvc.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Override
	@Transactional
	public void saveBill(Bill theBill) {
		billRepository.save(theBill);
	}
	
	@Override
	@Transactional
	public Bill getBill(int theBillId) {
		return billRepository.getOne(theBillId);
	}

	@Override
	@Transactional
	public List<Bill> getBills() {
		return billRepository.findAll();
	}

	@Override
	@Transactional
	public void setShipSuccess(Bill theBill) {
		theBill.setShipStatus("FINISH");
		billRepository.saveAndFlush(theBill);
	}

	@Override
	public void setShipCancel(Bill theBill) {
		theBill.setShipStatus("CANCEL");
		billRepository.saveAndFlush(theBill);
	}



}
