package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.StudentAllocation;

public interface StudentAllocationRepository  extends JpaRepository<StudentAllocation, Integer>{
	ArrayList<StudentAllocation> findByAcademicYearAndIsONNot(String academic_year,String isON);
}
