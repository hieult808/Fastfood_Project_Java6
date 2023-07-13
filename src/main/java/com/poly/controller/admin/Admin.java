package com.poly.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin {
	@GetMapping("/profile")
	public String indexAdmin(Model model) {
		return "admin/profile";
	}
	
	@GetMapping("/item")
	public String index2(Model model) {
		return "admin/basic-table";
	}
	
	
}
