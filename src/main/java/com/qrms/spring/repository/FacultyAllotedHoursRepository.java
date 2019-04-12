package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.FacultyAllotedHours;

@Repository
public interface FacultyAllotedHoursRepository extends JpaRepository<FacultyAllotedHours, Integer>{
	
	//JPQA
	@Query("SELECT new com.qrms.spring.model.FacultyAllotedHours(fa.facultyId,fa.allotedHours,fa.maxHours,fa.practicalHours,fa.theoryHours) "
			+ "from FacultyAllotedHours fa order by fa.facultyId")
	ArrayList<FacultyAllotedHours> findAllOrderByFacId();

}
