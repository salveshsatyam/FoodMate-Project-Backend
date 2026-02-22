package com.cts.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	public List<Order>findByUserId(int userId);
	
	@Query("Select o from Order o where DATE(o.calenderDate)=?1	")
	public List<Order>getAllOrderByCalenderDate(Timestamp date);
	
	@Query("Select o from Order o where DATE(o.calenderDate) between ?1 and ?2 ")
	public List<Order>getAllOrderBetweenDate(Date date1, Date date2);

}
