package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer>{

	List<Resource> findByDepartment(Department department);

	Resource findByResourceId(String concat);
	
	@Query("select r from Resource r where r.department = ?1 and r.resourceType = ?2 and r.resourceCapacity >= ?3")
	ArrayList<Resource> findByDepartmentAndResourceTypeAndResourceCapacityGreaterThan(Department d, String rType,
			int minSeats);

}
