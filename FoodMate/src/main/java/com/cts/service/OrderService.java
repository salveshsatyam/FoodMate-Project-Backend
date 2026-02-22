package com.cts.service;

import java.util.Date;
import java.util.List;

import com.cts.entity.Order;
import com.cts.utils.Revenue;

public interface OrderService {
	
	public void addOrder(int userId, String Address);
	public List<Order>getAllOrderOfUser(int userId);
	public Order getOrderByOrderId(int oId);
	
	public Revenue getRevenue(Date date);
	public Revenue getRevenueMonthly(Date date1, Date date2);
	
	


}
