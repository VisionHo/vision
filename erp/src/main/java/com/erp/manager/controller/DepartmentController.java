package com.erp.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/department")
public class DepartmentController {

	@RequestMapping("/list")
	public String getSupplierList(){
		return "department/list";
	}
}
