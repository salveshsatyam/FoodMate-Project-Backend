package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Product;
import com.cts.service.ProductService;

@RestController
@RequestMapping("product-rest")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/admin/product")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		
	}
	
	@GetMapping("/user/fetch")
	public List<Product>fetchProduct(){
		List<Product> products = productService.fetchProduct();
		return  products;
	}
	
	@PutMapping("/updateProduct")
	public void updateProduct(Product product) {
		productService.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProduct")
	public void deleteProduct(int productId) {
		productService.deleteProduct(productId);
	}
	
	@GetMapping("/fetchById")
	public List<Product>fetchById(int productId){
		return productService.fetchById(productId);
	}
	
	@GetMapping("/fetchByIds")
	public List<Product>fetchByIds(int [] ids){
		List<Product> pIds = productService.fetchByIds(ids);
		return pIds;
	}
	
	

}
