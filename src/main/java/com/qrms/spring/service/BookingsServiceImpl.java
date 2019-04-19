package com.qrms.spring.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
		// TODO Auto-generated method stub
		System.out.println("okokokokok");
		return departmentRepository.findAll();
	}

	@Override
	public ArrayList<Resource> listResourcesByDepartmentAndRTypeAndMinSeats(String dept, String rType, Integer minSeats) {
		// TODO Auto-generated method stub
		Department d = departmentRepository.findByDeptId(dept);
		return resourceRepository.findByDepartmentAndResourceTypeAndResourceCapacityGreaterThan(d,rType,minSeats);
	}

	public Resource findByResourceId(String getTT) {
		// TODO Auto-generated method stub
		
		return resourceRepository.findByResourceId(getTT);
	}

	public Collection<TimeSlots> findTimeSlotsByResourceForDate(String getTT,String day,Date sqlDate) {
		// TODO Auto-generated method stub
		Resource r = resourceRepository.findByResourceId(getTT);
//		LocalDateTime date = LocalDateTime.now();
//		Date sqlDate = java.sql.Date.valueOf(date.toLocalDate());
		
		
		
		//		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		ArrayList<TimeTable> tt = timeTableRepository.findByResourceIdAndDay(r,day);
		ArrayList<TimeSlots> ts = timeSlotsRepository.findByResourceIdAndDate(r,sqlDate);

		//		Date date1 = java.sql.Date.valueOf(date);
		System.out.println(sqlDate+" sqlDate");
		HashMap<Time, TimeSlots> finalTT = new HashMap<>();
		System.out.println(tt.size());
		for(TimeTable t:tt) {
			finalTT.put(t.getStartTime(), new TimeSlots(t.getStartTime(), t.getEndTime(), t.getResourceId(),r.getResourceCapacity(),sqlDate,t.getSlotIncharge(),t.getActivityName()));
		}
		System.out.println(ts.size());
		for(TimeSlots tss: ts) {
			
			if(!finalTT.containsKey(tss.getStartTime())){
				finalTT.put(tss.getStartTime(),tss);
			}
		}
		System.out.println(finalTT.size());
		return finalTT.values();
	}

}
