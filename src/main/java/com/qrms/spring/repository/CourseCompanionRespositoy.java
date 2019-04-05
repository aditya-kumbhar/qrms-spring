package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.CompanionCourse;
import com.qrms.spring.model.Course;

public interface CourseCompanionRespositoy extends JpaRepository<CompanionCourse, Integer> {

	CompanionCourse findByCourse(String c);
	
}
