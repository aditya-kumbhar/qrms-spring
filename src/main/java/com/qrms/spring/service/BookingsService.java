package com.qrms.spring.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeSlots;

public interface BookingsService {
	public ArrayList<Department> listDepartments();
	public Resource findByResourceId(String getTT);
	public ArrayList<Resource> listResourcesByDepartmentAndRTypeAndMinSeats(String dept, String rType, Integer minSeats);
	public ArrayList<TimeSlots> findTimeSlotsByResourceForDate(String getTT,String day,Date sqlDate);
	public List<TimeSlots> getTimeSlotsForDate(String booking_date,String getTT);
}
