package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.FacultyAcad;

public interface FacultyAcadRepository  extends JpaRepository<FacultyAcad, Integer>{
	FacultyAcad findByUserName(String userName);

	ArrayList<FacultyAcad> findByDepartmentEquals(Department dept);
}
