package com.qrms.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.FacultyAllotedHours;

@Repository
public interface FacultyAllotedHoursRepository extends JpaRepository<FacultyAllotedHours, Integer>{

	
	@Query("Select fa from FacultyAllotedHours fa where fa.facultyId in " + 
			"(SELECT fa.userName FROM com.qrms.spring.model.FacultyAcad fa where fa.department = ?1)")
	List<FacultyAllotedHours> findFacsByDepartment(Department dept);

	FacultyAllotedHours findByFacultyId(String userName);
	
	

}
