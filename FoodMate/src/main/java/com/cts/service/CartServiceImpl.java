package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Cart;
import com.cts.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepository cartRepository;

	@Override
	public void addCart(Cart cart) {
		Cart cartsave = cartRepository.findByUserIdAndInorderAndProduct(cart.getUserId(), false, cart.getProduct());
		// TODO Auto-generated method stub
		if(cartsave != null) {
			cartsave.setQuantity(cartsave.getQuantity()+1);
			cartRepository.save(cartsave);
			return;
			
		}
		cartRepository.save(cart);
		
	}

	@Override
	public List<Cart> getCartOfUser(int userId) {
		// TODO Auto-generated method stub
		return cartRepository.findAllByuserIdAndInorder(userId, false);
	}

	@Override
	public void updateCartOfUser(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.save(cart);
		
	}

	@Override
	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		cartRepository.deleteById(cartId);
		
	}

	@Override
	public void moveFromCartToOrder(int userId) {
		// TODO Auto-generated method stub
		List<Cart>cart = cartRepository.findAllByuserIdAndInorder(userId, false);
		for(Cart c : cart) {
			c.setInorder(true);
		}
		cartRepository.saveAll(cart);
		
	}
	
	
	

}
