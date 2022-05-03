package com.cybage.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.cybage.model.Users;

public interface UsersService {

	public ResponseEntity<?> createUser(Users newUser);

	public Users updateUser(Users newUser);

//	public String deleteUser(BigInteger UserId);

	public Iterable<Users> displayAllUser();

//	public ResponseEntity<?> findUserById(BigInteger userId);

	public String deleteUser(Integer UserId);

	public ResponseEntity<?> findUserById(Integer userId);
}