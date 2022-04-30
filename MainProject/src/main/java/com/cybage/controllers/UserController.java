package com.cybage.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.UserNotFound;
import com.cybage.models.Users;
import com.cybage.services.UserService;

import lombok.extern.slf4j.Slf4j;



@RestController
@CrossOrigin("*")
@RequestMapping("/user")
@Slf4j
public class UserController {
	Logger logger= (Logger) org.slf4j.LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<Users>> getUsers()
	{
		List<Users> users= service.getUsers();
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK); 
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable int id)
	{
		Users user= service.getUserById(id);
		if(user== null)
		{	
			logger.info("user not found");
			throw new UserNotFound("user not found");
		}
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody Users user)
	{
		service.updateUserById(id, user);
		return new ResponseEntity<String>("user updated successfully", HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public Users updateUser(@RequestBody Users user)
	{
		return service.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		service.deleteById(id);
		return new ResponseEntity<String>("User deleted Successfully", HttpStatus.OK);
	}
}
