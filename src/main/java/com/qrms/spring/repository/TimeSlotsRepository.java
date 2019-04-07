package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.TimeSlots;

public interface TimeSlotsRepository extends JpaRepository<TimeSlots, Integer>{
	
}
