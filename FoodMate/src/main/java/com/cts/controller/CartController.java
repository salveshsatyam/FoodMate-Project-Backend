package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Cart;
import com.cts.service.CartService;

@RequestMapping("cart-rest")
@RestController	
public class CartController {
	@Autowired
	CartService cartservice;
	
	@PostMapping("/addCart")
	public void addCart(@RequestBody Cart cart) {
		
		cartservice.addCart(cart);
		
	}
	
	@GetMapping("/cart/{userId}")
	public List<Cart> getCartOfuser(@PathVariable int userId){
		List<Cart> carts = cartservice.getCartOfUser(userId);
		return carts;
		
	}
	
	@PutMapping("/updateCart")
	public void updateCartOfUser(@RequestBody Cart cart) {
		cartservice.updateCartOfUser(cart);
		
	}
	
	@DeleteMapping("/deleteCart/{cartId}")
	public void deleteCart(@PathVariable int cartId) {
		cartservice.deleteCart(cartId);
	}
	
	

}
