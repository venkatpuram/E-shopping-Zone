package com.eshoppingzone.eshoppingzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.eshoppingzone.eshoppingzone.pojo.Product;

@Controller
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/signin")
	public String login() {
		return "login";
	}

	@RequestMapping("/searchproduct")
	public String searchProduct(@RequestParam("search") String search, Model model) {
		Product entity=restTemplate.getForObject("http://localhost:8989/products/productname/"+search, Product.class);
		
		return "index";
	}
}
