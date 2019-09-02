package com.techzone.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DashboardController {

	
	@GetMapping("/admin/managerment")
	public ModelAndView dashboardAdmin(ModelAndView theModel) {
		theModel.setViewName("/admin/dashboard");
		
		return theModel;
	}
	
	@GetMapping("/staff/control")
	public ModelAndView dashboardStaff(ModelAndView theModel) {
		theModel.setViewName("/admin/dashboard");
		
		return theModel;
	}
	
	

}
