package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.StudentAllocCourse;

public interface StudentAllocCourseRepository extends JpaRepository<StudentAllocCourse, Integer> {
	ArrayList<StudentAllocCourse> findByCourseId(Course course_id);

	void deleteByCourseId(Course course);
}
