package com.qrms.spring.repository;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeSlots;

public interface TimeSlotsRepository extends JpaRepository<TimeSlots, Integer>{

	ArrayList<TimeSlots> findByResourceIdAndDate(Resource r, Date format);
	
}
