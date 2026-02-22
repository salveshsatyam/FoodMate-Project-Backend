package com.cts.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cts.utils.OrderDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@ToString
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oId;
	private int userId;
	private String summary;
	private String address;
	private double price;
	private Timestamp calenderDate;
	@Transient
	private List<OrderDetails>description = new ArrayList<>();
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSummary() {
		return summary;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setprice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
	public void setCalenderDate(Timestamp calenderDate) {
		this.calenderDate = calenderDate;
	}
	public Timestamp getCalenderDate() {
		return calenderDate;
	}
	
	public void setDescription(List<OrderDetails>description){
		this.description = description;
	}
	public List<OrderDetails>getDescription(){
		return description;
	}
	
	
	
	
	

}
