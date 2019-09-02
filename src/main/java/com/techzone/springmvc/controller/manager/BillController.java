package com.techzone.springmvc.controller.manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techzone.springmvc.entity.Bill;
import com.techzone.springmvc.entity.BillDeTail;
import com.techzone.springmvc.entity.Customer;
import com.techzone.springmvc.entity.Product;
import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.model.BillModel;
import com.techzone.springmvc.service.BillDetailService;
import com.techzone.springmvc.service.BillService;
import com.techzone.springmvc.service.CustomerService;
import com.techzone.springmvc.service.ProductService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;

@Controller
@RequestMapping({"/admin/bill","/staff/bill"})
public class BillController {
	
	// TODO : Dependency Injection
	@Autowired
	private BillService billService;
	
	@Autowired
	private BillDetailService billDetailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
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
			return "redirect:/admin/bill/list";
		}
		return "redirect:/staff/bill/list";
	}
	
	@GetMapping("/list")
	public String listBill(ModelMap theModel) {
		List <Bill> theBills = billService.getBills();
		theModel.addAttribute("theBills", theBills);
		return "/admin/list-bills";
	}
	
	@GetMapping("/setShipSuccess")
	public String setShipSuccess(@RequestParam("theBillId") int theBillId) {
		
		System.err.println("Bill Id To set success : " + theBillId);
		Bill theBill = billService.getBill(theBillId);
		billService.setShipSuccess(theBill);
		return "redirect:/admin/bill";
	}
	
	@GetMapping("/setShipCancel")
	public String setShipCancel(@RequestParam("theBillId") int theBillId) {
		System.err.println("Bill Id To set cancel : " + theBillId);
		Bill theBill = billService.getBill(theBillId);
		billService.setShipCancel(theBill);
		return "redirect:/admin/bill";
	}
	
	@GetMapping("/getDetailBill")
	public String getDetailBill(@RequestParam("theBillId") int theBillId , ModelMap theModel) {
		
		List<BillDeTail> theBillDetails = billDetailService.getBillDetailByBillId(theBillId);
		
		theModel.addAttribute("theBillDetails", theBillDetails);
		return "/admin/list-billdetails";
		
	}
	
	/****************************************************************************************/
	
	public void getDependencyToSetupBill(ModelMap theModel) {
		theModel.addAttribute("listCustomer", customerService.getCustomers());
		theModel.addAttribute("listProduct", productService.getProducts());
	}
	@GetMapping("/showForm")
	public String showFormSetupBill(ModelMap theModel) {
		
		getDependencyToSetupBill(theModel);
		
		theModel.addAttribute("theBill", new BillModel());
		
		return "/admin/form-bill";
		
	}

	@PostMapping("/saveBill")
	@Transactional
	public String saveBill(@ModelAttribute("productModel") BillModel theBillModel, ModelMap theModel) throws ResourceNotFoundException {
		
		Customer theCustomer = customerService.getCustomer(theBillModel.getBill().getCustomer().getId());
		
		Product theProduct = productService.getProduct(theBillModel.getProduct().getId());
		
		long total = ( (theBillModel.getQuantity() * theProduct.getPrice()) ) * (100 - theProduct.getSale().getPercent()) ;
		System.err.println("TOTAL : " + total);
		Bill billSaved = new Bill(generateBillId(),
				generateDateOrder(),
				(long)total,
				(long)theBillModel.getQuantity(),
				"SUCCESS",
				"COMPANY",
				theCustomer.getPhone(),
				"No Note",
				theCustomer,
				userService.findByUsername(SecurityUtil.getPrincipal()));
		
		billService.saveBill(billSaved);
		
		BillDeTail theBillDetail = new BillDeTail(theBillModel.getQuantity(), theProduct.getPrice(), theProduct.getSale().getPercent(), theProduct, billSaved);
		billDetailService.saveBillDetail(theBillDetail);
		if (checkAdminAccess() == true) {
			return "redirect:/admin/bill/list";
		}
		return "redirect:/staff/bill/list";
		
	}
	
	// ----------------------------------------------------------------- //
	public String generateBillId() {
		String billId = null;
		billId = "BILL"+ new Date().getTime();
		return billId;
	}
	public String generateDateOrder() {
		String dateOrder = null;
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		Calendar cal = Calendar.getInstance();
		dateOrder = sdf.format(cal.getTime());
		return dateOrder;
		
	}

	// ----------------------------------------------------------------- //

	
	
	
} // END CLASS
