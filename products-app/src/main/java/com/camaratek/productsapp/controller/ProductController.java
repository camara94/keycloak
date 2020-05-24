package com.camaratek.productsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.camaratek.productsapp.repositories.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping(value = "/products")
	public String products(Model model) {
		model.addAttribute("products",  productRepository.findAll());
		return "products";
	}

}
