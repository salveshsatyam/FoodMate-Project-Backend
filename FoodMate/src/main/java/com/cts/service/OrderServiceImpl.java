package com.cts.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Cart;
import com.cts.entity.Order;
import com.cts.entity.User;
import com.cts.exception.UserNotExistException;
import com.cts.repository.OrderRepository;
import com.cts.repository.UserRepository;
import com.cts.utils.OrderDetails;
import com.cts.utils.Revenue;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	CartService cartService;

	@Override
	@Transactional
	public void addOrder(int userId, String Address) {
		// TODO Auto-generated method stub
		Optional<User>user = userRepository.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotExistException("user not found");
		}
		
		List<Cart>cart = cartService.getCartOfUser(userId);
		Timestamp today = Timestamp.from(Instant.now());
		Order order = new Order();
		order.setUserId(userId);
		order.setAddress(Address);
		order.setCalenderDate(today);
		
		String summary = "";
		double price = cart.stream()
				.map(p -> p.getQuantity() * p.getProduct().getPrice())
				.collect(Collectors.toList())
				.stream()
				.reduce(0.0, (ans,i) -> ans + i);
		
		for(int i =0; i<cart.size();i++) {
			if(i != cart.size()-1) {
				summary += cart.get(i).getProduct().getProductName() + ", " + cart.get(i).getQuantity() + ", " +
			cart.get(i).getProduct().getPrice() + ";";
			}
			else {
			   summary += cart.get(i).getProduct().getProductName() + ", " + cart.get(i).getQuantity() + ", " +
			cart.get(i).getProduct().getPrice();
			}
		}
		
		order.setSummary(summary);
		order.setprice(price);
		orderRepository.save(order);
		cartService.moveFromCartToOrder(userId);
		
	}

	@Override
	public List<Order> getAllOrderOfUser(int userId) throws UserNotExistException {
		// TODO Auto-generated method stub
		Optional<User>user = userRepository.findById(userId);
		
		if(!user.isPresent()) {
			throw new UserNotExistException("user not found");
		}
		
		List<Order> result = new ArrayList<>();
		
		List<Order> allOrder = orderRepository.findByUserId(userId);
		
		allOrder.stream()
		.forEach(order -> {
			String summary = order.getSummary();
			String [] subSummary = summary.split(";");
			
			for(String s : subSummary) {
				OrderDetails o = new OrderDetails();
				String [] subs = s.split(";");
				
				o.setName(subs[0]);
				o.setQuantity(Integer.parseInt(subs[1]));
				o.setPrice(Double.parseDouble(subs[2]));
				order.getDescription().add(o);
				
			}
			result.add(order);
		});
		
		return result;
	}

	@Override
	public Order getOrderByOrderId(int oId) {
		// TODO Auto-generated method stub
		Order order = orderRepository.findById(oId).get();
		String summary = order.getSummary();
		String [] subSummary = summary.split(";");
		for(String s:subSummary) {
			String subs[] = s.split(";");
			order.getDescription().add(new OrderDetails(subs[0], Integer.parseInt(subs[2]), Double.parseDouble(subs[1])));
		}
		return order;
	}

	@Override
	public Revenue getRevenue(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Revenue getRevenueMonthly(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

}
