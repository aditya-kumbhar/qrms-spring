package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Integer>{
	
}
