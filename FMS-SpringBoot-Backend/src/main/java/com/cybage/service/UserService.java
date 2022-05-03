package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.UserRepository;
import com.cybage.model.Users;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Users updateUserById(int id, Users user)
	{
		return repository.save(user);
	}

	public List<Users> getUsers() {
		return repository.findAll();
	}
	
	public Users updateUser(Users user)
	{
		int id= user.getUserId();
		Users user1= repository.findById(id).get();
		user1.setUsername(user.getUsername());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setMobile(user.getMobile());
		user1.setEmailId(user.getEmailId());
		return repository.save(user1);
	}

	public Users getUserById(int id) {
		Users user= repository.findById(id).orElse(null);
		System.out.println(user);
		return user;
	}

	public void deleteById(int id) {
		repository.deleteById(id);
		
	}

	public Users fetchByEmailId(String emailId) {	
		return repository.findByEmailId(emailId);
	}
}	
