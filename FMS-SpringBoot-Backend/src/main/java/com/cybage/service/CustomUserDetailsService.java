package com.cybage.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cybage.dao.UserRepository;
import com.cybage.model.Users;



@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=repository.findByEmailId(username);
		return new User(user.getEmailId(), user.getPassword(), new ArrayList<>());
	}
	
}
