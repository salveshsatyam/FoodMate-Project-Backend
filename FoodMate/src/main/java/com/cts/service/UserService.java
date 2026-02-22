package com.cts.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.exception.UserAlreadyExixtsException;
import com.cts.exception.UserNotExistException;
import com.cts.repository.UserRepository;

@Service 
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User>userDetail = Optional.ofNullable(userRepository.findByEmailId(username).orElseThrow(() -> new UserNotExistException("User not found " + username)));
		
		Set<GrantedAuthority> authorities=null;
		
		if(userDetail.isPresent()) {
			String role = userDetail.get().getRole();
			authorities=Set.of(new SimpleGrantedAuthority("ROLE_" + role));
		}
		return new org.springframework.security.core.userdetails.User(userDetail.get().getEmailId(), userDetail.get().getPassword(),true,true,true,true, authorities);
	}
	

	public String addUser(User user) throws UserAlreadyExixtsException {
		// TODO Auto-generated method stub
		Optional<User> u = userRepository.findByEmailId(user.getEmailId());
		if(u.isPresent()) {
			throw new UserAlreadyExixtsException("Already Exists");
		}
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "Saved successfully";
	}

	
	public List<User> getUser(){
		return userRepository.findAll();
	}
	
	public User getUserById(int userid) {
		Optional<User> user = userRepository.findById(userid);
		if(user.isPresent()) {
			return userRepository.findById(userid).get();
		}
		else {
			throw new UsernameNotFoundException("User not found"+ userid);
		}
	}

}
