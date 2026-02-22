package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.AddressDto;
import com.cts.entity.Address;
import com.cts.entity.User;
import com.cts.exception.UserNotExistException;
import com.cts.repository.UserRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	UserService userService;

	@Override
	public User addAddress(AddressDto addressDto, int userId) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userId);
		
		if(!user.isPresent()) {
			throw new UserNotExistException("User Not Found!");
		}
		
		Address address = new Address();
		List<Address> addressList = null;
		
		addressList = user.get().getAddress();
		addressList.add(address);
		
		address.setCity(addressDto.getCity());
		address.setStreet(addressDto.getStreet());
		address.setState(addressDto.getState());
		address.setZipCode(addressDto.getZipCode());
		
		user.get().setAddress(addressList);
		User savedUserInfo = user.get();
		User savedUser = userRepository.save(savedUserInfo);
		return savedUser;
	}

	@Override
	public List<Address> getAddressOfUser(int userId) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userId);
		
		if(! user.isPresent()) {
			throw new UserNotExistException("User Not Found !");
		}
		
		List<Address>address = user.get().getAddress();
		
		
		
		return address;
	}

	@Override
	public void deleteAddress(int addressId, int userId) {
		// TODO Auto-generated method stub
		
     Optional<User> user = userRepository.findById(userId);
		
		if(! user.isPresent()) {
			throw new UserNotExistException("User Not Found !");
		}
		
		user.get().getAddress().removeIf((x) -> (x.getId() == addressId));
		
		userRepository.save(user.get());
		
	}

}