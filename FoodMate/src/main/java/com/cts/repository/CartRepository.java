package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.Cart;
import com.cts.entity.Product;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	List<Cart>findAllByuserIdAndInorder(int userId, boolean inorder);
	void deleteAllByProduct(Product product);
	Cart findByUserIdAndInorderAndProduct(int i, boolean b, Product product);
	
	
	
	

}
