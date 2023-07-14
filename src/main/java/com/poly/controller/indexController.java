package com.poly.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class indexController {

	@GetMapping("/index")
	public String index(Model model) {
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
