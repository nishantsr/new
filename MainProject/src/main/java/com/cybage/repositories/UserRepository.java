package com.cybage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByEmailId(String email);

}
