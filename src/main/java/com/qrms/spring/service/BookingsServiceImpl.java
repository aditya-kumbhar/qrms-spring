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

	public ArrayList<TimeSlots> findTimeSlotsByResourceForDate(String getTT,String day,Date sqlDate) {
		// TODO Auto-generated method stub
		Resource r = resourceRepository.findByResourceId(getTT);
//		LocalDateTime date = LocalDateTime.now();
//		Date sqlDate = java.sql.Date.valueOf(date.toLocalDate());
		
		
		
		//		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		ArrayList<TimeTable> tt = timeTableRepository.findByResourceIdAndDay(r,day);
		ArrayList<TimeSlots> ts = timeSlotsRepository.findByResourceIdAndDate(r,sqlDate);

		//		Date date1 = java.sql.Date.valueOf(date);
		System.out.println(sqlDate+" sqlDate");
//		HashMap<Time, TimeSlots> finalTT = new HashMap<>();
//		System.out.println(tt.size());
//		for(TimeTable t:tt) {
//			finalTT.put(t.getStartTime(), new TimeSlots(t.getStartTime(), t.getEndTime(), t.getResourceId(),sqlDate,t.getSlotIncharge(),t.getActivityName(),0));
//		}
//		System.out.println(ts.size());
//		for(TimeSlots tss: ts) {
//			
//			if(!finalTT.containsKey(tss.getStartTime())){
//				finalTT.put(tss.getStartTime(),tss);
//			}
//		}
		
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
				
				if((st>=gost && et<=goet) || (st>=gost && st<goet) || (et>gost && et<=goet) || (st<=gost && et>=goet)) {
					i+=1;
				}
				
			}
			if(i==0) {
				finalTS.add(new TimeSlots(t.getStartTime(), t.getEndTime(), t.getResourceId(),sqlDate,t.getSlotIncharge(),t.getActivityName(),0));
			}
		}
		
		System.out.println("finalts size: "+finalTS.size());
		
//		System.out.println(finalTT.size());
//		return finalTT.values();
		return finalTS;
	}

}
