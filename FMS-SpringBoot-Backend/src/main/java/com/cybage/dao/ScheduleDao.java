package com.cybage.dao;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Schedule;

@Repository
public interface ScheduleDao extends CrudRepository<Schedule, BigInteger> {

}
