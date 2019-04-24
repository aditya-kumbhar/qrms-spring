package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Integer>{

	ArrayList<TimeTable> findByResourceIdAndDay(Resource r, String day);

	void deleteByDepartmentAndDay(Department department, String day);
	
}
