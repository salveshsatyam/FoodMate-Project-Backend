package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.AddressDto;
import com.cts.entity.Address;
import com.cts.entity.User;
import com.cts.service.AddressService;


@RequestMapping("address-rest")
@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/addAddress/{userId}")
	public User add(@RequestBody AddressDto address , @PathVariable int userId){
		
		User user = addressService.addAddress(address, userId);
		return user;
		
	}
	
	@GetMapping("/getAddress/{userId}")
	public List<Address> getAddressOfUser(@PathVariable int userId){
		List<Address>addresses = addressService.getAddressOfUser(userId);
		return addresses;
	}
	
	
	@DeleteMapping("/deleteAddress/{addressId}/{userId}")
	public void deleteAddress(@PathVariable int addressId,@PathVariable int userId) {
		addressService.deleteAddress(addressId, userId);
	}
	
	

}
