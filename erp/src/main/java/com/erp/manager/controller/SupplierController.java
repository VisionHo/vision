package com.erp.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	
	@RequestMapping("/list")
	public String getSupplierList(){
		return "supplier/list";
	}
}
