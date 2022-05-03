package com.cybage.dao;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cybage.model.Users;;

public interface UserDao extends JpaRepository<Users, Integer>{

}