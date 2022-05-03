package com.cybage.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, BigInteger> {

}
