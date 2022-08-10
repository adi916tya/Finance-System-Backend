package com.wipro.velocity.team8.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.velocity.team8.model.Product;
import com.wipro.velocity.team8.model.User;
import com.wipro.velocity.team8.model.UserProducts;
import com.wipro.velocity.team8.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@RequestMapping("/products")
	public String viewProducts(Model model) {
		List<Product> products=pservice.listAll();
		model.addAttribute("products", products);
		return ""; //replace string with product details page & display only one product
	}
	
	@RequestMapping("/productinfo")
	public String viewProduct(Model model) {
		Optional<Product> product=pservice.findProductByPid((Long) model.getAttribute("p_id"));
		Optional<User> user=pservice.findUserByUid((Long) model.getAttribute("u_id"));
//		UserProducts u_products=pservice.findUserProductData((Long) model.getAttribute("u_id"),(Long) model.getAttribute("p_id"));
//		model.addAttribute("product", product);
//		model.addAttribute("user",user);
//		model.addAttribute("u_products",u_products);
		return ""; //replace string with product details page & display only one product
	}
	
}
