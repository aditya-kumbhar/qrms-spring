package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.FacultyAllotedHours;

@Repository
public interface FacultyAllotedHoursRepository extends JpaRepository<FacultyAllotedHours, Integer>{
	
	

}
