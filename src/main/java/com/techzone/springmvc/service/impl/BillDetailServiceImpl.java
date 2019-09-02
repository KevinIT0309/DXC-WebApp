package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.BillDeTail;
import com.techzone.springmvc.repository.BillDetailRepository;
import com.techzone.springmvc.service.BillDetailService;

@Service
public class BillDetailServiceImpl implements BillDetailService {

	@Autowired
	private BillDetailRepository billDetailRepository;
	
	@Override
	@Transactional
	public void saveBillDetail(BillDeTail theBillDetail) {
		billDetailRepository.save(theBillDetail);
	}

	@Override
	@Transactional
	public List<BillDeTail> getBillDetails() {
		return billDetailRepository.findAll();
	}

	@Override
	@Transactional
	public List<BillDeTail> getBillDetailByBillId(int theBillId) {
		return billDetailRepository.getBillDetailByBillId(theBillId);
	}

}
