package com.qrms.spring.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeSlots;
import com.qrms.spring.model.TimeTable;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.ResourceRepository;
import com.qrms.spring.repository.TimeSlotsRepository;
import com.qrms.spring.repository.TimeTableRepository;

@Service
public class BookingsServiceImpl implements BookingsService{

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private ResourceRepository resourceRepository;
	@Autowired
	private TimeSlotsRepository timeSlotsRepository;
	@Autowired
	private TimeTableRepository timeTableRepository;
	
	@Override
	public ArrayList<Department> listDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public ArrayList<Resource> listResourcesByDepartmentAndRTypeAndMinSeats(String dept, String rType, Integer minSeats) {
		Department d = departmentRepository.findByDeptId(dept);
		return resourceRepository.findByDepartmentAndResourceTypeAndResourceCapacityGreaterThan(d,rType,minSeats);
	}

	public Resource findByResourceId(String getTT) {
		return resourceRepository.findByResourceId(getTT);
	}

	public ArrayList<TimeSlots> findTimeSlotsByResourceForDate(String getTT,String day,Date sqlDate) {

		Resource r = resourceRepository.findByResourceId(getTT);
		ArrayList<TimeTable> tt = timeTableRepository.findByResourceIdAndDay(r,day);
		ArrayList<TimeSlots> ts = timeSlotsRepository.findByResourceIdAndDate(r,sqlDate);

		ArrayList<TimeSlots> finalTS = new ArrayList<>();
		
		for(TimeSlots tss:ts) {
			finalTS.add(tss);
		}
		for(TimeTable t:tt) {
			Long st = t.getStartTime().getTime();
			Long et = t.getEndTime().getTime();
			int i = 0;
			for(TimeSlots tss:ts) {
				Long gost = tss.getStartTime().getTime();
				Long goet = tss.getEndTime().getTime();
				
				if((st>=gost && et<=goet) || (st>=gost && st<goet) || (et>gost && et<=goet) || (st<=gost && et>=goet) || (st<=gost && et>gost && et<=goet)) {
					i+=1;
				}
				
			}
			if(i==0) {
				finalTS.add(new TimeSlots(t.getStartTime(), t.getEndTime(), t.getResourceId(),sqlDate,t.getSlotIncharge(),t.getActivityName(),0));
			}
		}
		
		return finalTS;
	}


	public List<TimeSlots> getTimeSlotsForDate(String booking_date,String getTT){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(booking_date, df);
		Date sqlDate = java.sql.Date.valueOf(date.toString());
		String day = date.getDayOfWeek().name();

		ArrayList<TimeSlots> list = findTimeSlotsByResourceForDate(getTT,day,sqlDate);
		
		Collections.sort(list);
		return list;
	}
}
