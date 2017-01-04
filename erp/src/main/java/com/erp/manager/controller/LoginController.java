package com.erp.manager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.common.pojo.ErpResult;
import com.erp.manager.service.LoginService;

@Controller
public class LoginController {

	@Resource
	private LoginService loginService;

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/login/check")
	public String login(String username, String password, Model model) {
		ErpResult result = null;
		try {
			
			result = loginService.login(username, password);
			if (result.getStatus() == 200) {
				return "redirect:/";
			}
		} catch (Exception e) {
			result = ErpResult.build(500, "登陆失败");
		}

		model.addAttribute("result", result);
		return "login";
	}

}
