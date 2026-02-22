package com.cts.service;

import java.util.List;

import com.cts.dto.AddressDto;
import com.cts.entity.Address;
import com.cts.entity.User;

public interface AddressService {
	public User addAddress(AddressDto addressDto, int userId);
	public List<Address> getAddressOfUser(int userId);
	public void deleteAddress(int addressId, int userId);

}
