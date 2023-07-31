package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.ItemDao;
import com.poly.entity.Item;
import com.poly.service.ItemService;

@Controller
public class shopController {
	@Autowired
	ItemDao dao;
	@Autowired
	private ItemService itemService;

	@GetMapping("/shop")
	public String shop(Model model) {
		List<Item> item = dao.findAll();
		model.addAttribute("items", item);
		return "shop";
	}

	@GetMapping("/shop/{itemId}")
	public String detal(@PathVariable int itemId, Model model) {
		Item item = dao.findById(itemId).orElse(null);
		model.addAttribute("items", item);
		// Lấy danh sách sản phẩm cùng loại trừ sản phẩm đang hiển thị
		List<Item> relatedProducts = itemService.getRelateditemsExcludingCurrent(item.getCategory().getCategoryId(),itemId);
		model.addAttribute("itemss", relatedProducts);
		return "single-product";
	}
}
