package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.FacultyAcad;

public interface FacultyAcadRepository  extends JpaRepository<FacultyAcad, Integer>{
	FacultyAcad findByUserName(String userName);

	ArrayList<FacultyAcad> findByDepartmentEquals(Department dept);

	@Query("SELECT count(*) from FacultyAcad fa where fa.designation=?1 and fa.department=?2")
	int countFacultyByDesignationAndDepartment(String key,Department dept);
	
	@Query("SELECT count(*) from FacultyAcad fa where fa.department=?1")
	int countFacultyByDepartment(Department dept);
	
}
