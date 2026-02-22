package com.cts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Product;
import com.cts.repository.CartRepository;
import com.cts.repository.ProductRepository;

import jakarta.transaction.Transactional;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}

	@Override
	public List<Product> fetchProduct() {
		// TODO Auto-generated method stub
		List<Product> ps = new ArrayList<>();
		productRepository.findAll().forEach(product -> ps.add(product));
		return ps;
	}
	
	@Transactional
	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<Product>product = productRepository.findById(productId);
		cartRepository.deleteAllByProduct(product.get());
		productRepository.deleteById(productId);
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}

	@Override
	public List<Product> fetchById(int productId) {
		// TODO Auto-generated method stub
		List<Product> res = new ArrayList<>();
		Optional<Product> op = productRepository.findById(productId);
		if(op.isPresent()) {
			res.add(op.get());
			return res;
		}
		
		return res;
	}

	@Override
	public List<Product> fetchByIds(int[] ids) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<>();
		for(int id : ids) {
			res.add(id);
		}
		return productRepository.findAllById(res);
	}

}
