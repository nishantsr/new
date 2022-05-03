package com.cybage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, String> {

}
