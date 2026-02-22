package com.cts.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String emailId;
	
	private String password;
	
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	public User() {
		
	}
	
	public User(int id, String name, String emailId, String password, String role) {
		super();
		
		this.id=id;
		this.emailId=emailId;
		this.name=name;
		this.password=password;
		this.role=role;
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailId=" + emailId + ", password=" + password+ ", role=" +role+ ", address=" + address + "]";
	}

	public String getEmailId() {
		// TODO Auto-generated method stub
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		// TODO Auto-generated method stub
		this.emailId = emailId;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
		
	}
	
	public void setRole(String role) {
		// TODO Auto-generated method stub
		this.role = role;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return role;
	}
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
	
	

}
