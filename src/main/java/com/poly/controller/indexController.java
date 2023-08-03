package com.poly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.dao.ItemsDao;
import com.poly.entity.Item;



@Controller
public class indexController {
	@Autowired
	ItemsDao itemDao;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("listItems", itemDao.findAll());
		return "index";
	}
	@GetMapping("/index_2")
	public String index2(Model model) {
		return "index_2";
	}
	
	
	@GetMapping("/cart")
	public String cart(Model model) {
		return "cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		return "checkout";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		return "about";
	}
	
	@GetMapping("/news")
	public String news(Model model) {
		return "news";
	}
	
	@GetMapping("/single-news")
	public String singlenews(Model model) {
		return "single-news";
	}
	
	@GetMapping("/single-product")
	public String singleproduct(Model model) {
		return "single-product";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

}
