package com.cts.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Order;
import com.cts.service.OrderService;
import com.cts.utils.Revenue;

@RestController
@RequestMapping("order-rest")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/user/addOrder/{userId}")
	public void addOrder(@RequestParam(required=true) String address, @PathVariable int userId) throws MissingServletRequestParameterException{
			
		if(address.trim().isEmpty()) {
			throw new MissingServletRequestParameterException("address", "address cannot be empty string"); 
		}
		
		orderService.addOrder(userId, address);
	}
	
	@GetMapping("/getUserOrder/{id}")
	public List<Order>getByUser(@PathVariable int id){
		List<Order>order = orderService.getAllOrderOfUser(id);
		return order;
	}
	
	@GetMapping("/user/getOrder/{id}")
	public Order getByOrder(@PathVariable int id) {
		return orderService.getOrderByOrderId(id);
	}
	
	@GetMapping("/admin/getRevenueMonthly")
	public Revenue gteMonthlyRevenue(@RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date date1, @RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date date2) {
		return orderService.getRevenueMonthly(date1, date2);
	}
	
	@GetMapping("/admin/getRevenueDaily")
	public Revenue getDailyRevenue(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		return orderService.getRevenue(date);
	}

}
