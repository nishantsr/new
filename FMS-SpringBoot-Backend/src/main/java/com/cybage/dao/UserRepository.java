package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Users;



@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByEmailId(String email);
	public Users findByUsername(String username);

}
