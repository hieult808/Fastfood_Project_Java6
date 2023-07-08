package com.poly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.repository.UserRepository;
import com.poly.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;



@Controller
public class indexController {
	@Autowired
	UserRepository dao;
	@Autowired
	SessionService session;

	@GetMapping("/index")
	public String index(Model model) {
		return "index";
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
	
	@GetMapping("/profile")
	public String indexAdmin(Model model) {
		return "admin/profile";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("account", new Account());
		return "Login";
	}

	@PostMapping("/login")
	public String processLoginForm(@Valid @ModelAttribute("account") Account account, BindingResult result, Model model,
			@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {

		
		account = dao.findByUsername(username);

		if (account != null && account.getPassword().equals(password)) {
			if (account.isActive()) {
				session.set("userSession", account);
				return "redirect:/index";
			} 
		}

		
		if (result.hasErrors()) {
			model.addAttribute("messages", "Đăng nhập thất bại");
			return "login";
		}
		
		
		return "login";
	}
	

}
