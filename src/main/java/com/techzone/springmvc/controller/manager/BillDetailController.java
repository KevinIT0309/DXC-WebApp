package com.techzone.springmvc.controller.manager;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techzone.springmvc.entity.BillDeTail;
import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.service.BillDetailService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;

@Controller
@RequestMapping(value= {"/admin/billDetail","/staff/billDetail"})
public class BillDetailController {
	
	// TODO : Dependency Injection
	@Autowired
	private BillDetailService billDetailService;
	
	@Autowired
	private UserService userService;
	// TODO : Dependency Injection
	
	public boolean checkAdminAccess() {
		User theUser = userService.findByUsername(SecurityUtil.getPrincipal());
		Set<Role> roles = theUser.getRoles();
		for (Role x : roles) {
			if (x.getRoleName().toString().equalsIgnoreCase("ADMIN")) {
				return true;
			}
		}
		return false;
	}
	
	@GetMapping("")
	public String handleOrigin() {
		if (checkAdminAccess() == true) {
			return "redirect:/admin/billDetail/list";
		}
		return "redirect:/staff/billDetail/list";
	}
	
	@GetMapping("/list")
	public String listBillDetail(ModelMap theModel) {
		List<BillDeTail> theBillDetails = billDetailService.getBillDetails();
		theModel.addAttribute("theBillDetails", theBillDetails);
		return "/admin/list-billdetails";
	}
	

}
