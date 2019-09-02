package com.techzone.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techzone.springmvc.service.ProductService;

@RestController
@RequestMapping("api/ajaxrest")
public class AjaxRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("demo1")
	public ResponseEntity<String> demo1(){
		try {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hello Ajax", HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
