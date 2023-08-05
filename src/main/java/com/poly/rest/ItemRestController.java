package com.poly.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Item;
import com.poly.service.ItemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ItemRestController {
	@Autowired
	ItemService itemService;

	@GetMapping("{itemId}")
	public Item getOne(@PathVariable("itemId") Integer itemId) {
		return itemService.findById(itemId);
	}
}
