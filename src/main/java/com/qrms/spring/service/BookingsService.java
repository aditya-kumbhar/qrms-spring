package com.qrms.spring.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeSlots;

public interface BookingsService {
	public ArrayList<Department> listDepartments();
	public Resource findByResourceId(String getTT);
	public ArrayList<Resource> listResourcesByDepartmentAndRTypeAndMinSeats(String dept, String rType, Integer minSeats);
	public Collection<TimeSlots> findTimeSlotsByResourceForDate(String getTT,String day,Date sqlDate);
}
