package com.cts.service;

import java.util.List;

import com.cts.entity.Cart;

public interface CartService {
	
	public void addCart(Cart cart);
	public List<Cart>getCartOfUser(int userId);
	public void updateCartOfUser(Cart cart);
	public void deleteCart(int cartId);
	public void moveFromCartToOrder(int userId);
	

}
