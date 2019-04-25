package com.qrms.spring.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.qrms.spring.model.Resource;
import com.qrms.spring.model.ResourceRequests;

public interface ResourceRequestsRepository extends JpaRepository<ResourceRequests, Integer>{
	@Query("SELECT rr "+
			//"new com.qrms.spring.model.ResourceRequests(rr.requestId,rr.resourceId,rr.requestBy,rr.slotDate,rr.slotStartTime,rr.slotEndTime,rr.slotActivityName,rr.requestedDate,rr.requestTime,rr.slotDay) "+ 
			"FROM ResourceRequests rr " +
			"WHERE rr.resourceId.resourceIncharge.userName=?1")
	ArrayList<ResourceRequests> findByResourceIncharge(String userName);

	ArrayList<ResourceRequests> findByResourceIdAndSlotDate(Resource resourceId, Date slotDate);

	ResourceRequests findByRequestId(Integer getOverlapsFor);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM ResourceRequests rr WHERE (rr.slotDate < ?1) or (rr.slotDate = ?1 and rr.slotStartTime <= ?2)")
	void deletePastRequests(Date sqlDate, Time t);

}
