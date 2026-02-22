package com.cts.service;

import java.util.List;

import com.cts.entity.Product;

public interface ProductService {
	public void addProduct(Product product);
	public List<Product>fetchProduct();
	public void deleteProduct(int productId);
	public void updateProduct(Product product);
	public List<Product>fetchById(int productId);
	public List<Product>fetchByIds(int []ids);

}
