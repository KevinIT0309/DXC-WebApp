package com.techzone.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.BillDeTail;

@Repository("billDetailRepository")
public interface BillDetailRepository extends JpaRepository<BillDeTail,Integer> {
	
	List<BillDeTail> getBillDetailByBillId(int theBillId);

}
