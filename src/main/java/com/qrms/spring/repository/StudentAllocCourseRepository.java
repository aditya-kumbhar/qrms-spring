package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.StudentAllocCourse;

public interface StudentAllocCourseRepository extends JpaRepository<StudentAllocCourse, Integer> {
	
}
