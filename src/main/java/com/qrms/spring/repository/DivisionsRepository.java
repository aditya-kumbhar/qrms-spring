package com.qrms.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Divisions;

public interface DivisionsRepository extends JpaRepository<Divisions,Integer>{

	List<Divisions> findByDepartment(Department dept);
	
}