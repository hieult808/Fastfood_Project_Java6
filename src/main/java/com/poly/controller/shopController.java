package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.dao.ItemDao;
import com.poly.entity.Item;

@Controller
public class shopController {
	@Autowired ItemDao dao;
	@GetMapping("/shop")
	public String shop(Model model) {
		List<Item> item = dao.findAll();
		model.addAttribute("items",item);
		return "shop";
	}
}
