package com.camaratek.productsapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camaratek.productsapp.repositories.ProductRepository;

@Controller
public class ProductController {
	
	 @Autowired
	    private ProductRepository productRepository;

	    @GetMapping("/")
	    public String index() {


	        return "index";
	    }

	    @GetMapping("/voir")
	    public String voir() {
	        return "voir";
	    }


	    @GetMapping("/produits")
	    public String products(@RequestParam(name="name", required=false, defaultValue="amar") String name, Model model) {
	    	model.addAttribute("name", name);
	        model.addAttribute("products", productRepository.findAll());
	        System.out.println("nom est: " + name);
	        return "products";
	    }




	    @RequestMapping("/hello")
	    @ResponseBody
	    String hello() {
	        return "Hello World!";
	    }


	    @GetMapping("/home")
	    public String greeting(@RequestParam(name="name", required=false, defaultValue="amar") String name, Model model) {
	        model.addAttribute("name", name);
	        return "home";
	    }

	    
	    @ExceptionHandler(Exception.class)
	    public String exceptionHandler() {
	        return "errors";
	    }



}