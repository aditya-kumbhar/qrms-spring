package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.CompanionCourse;

public interface CourseCompanionRespositoy extends JpaRepository<CompanionCourse, Integer> {
	
}
