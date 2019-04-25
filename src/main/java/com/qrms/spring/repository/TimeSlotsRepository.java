package com.qrms.spring.repository;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeSlots;

public interface TimeSlotsRepository extends JpaRepository<TimeSlots, Integer>{

	ArrayList<TimeSlots> findByResourceIdAndDate(Resource r, Date format);
	
	@Query("SELECT ts "+
			//"new com.qrms.spring.model.ResourceRequests(rr.requestId,rr.resourceId,rr.requestBy,rr.slotDate,rr.slotStartTime,rr.slotEndTime,rr.slotActivityName,rr.requestedDate,rr.requestTime,rr.slotDay) "+ 
			"FROM TimeSlots ts " +
			"WHERE ts.slotIncharge.userName=?1")
	ArrayList<TimeSlots> findBySlotIncharge(String userName);
	
}
