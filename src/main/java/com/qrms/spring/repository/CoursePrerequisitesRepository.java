package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.CoursePrerequisites;


public interface CoursePrerequisitesRepository extends JpaRepository<CoursePrerequisites, Integer> {
	ArrayList<CoursePrerequisites> findByCourse(String c_id);

	void deleteByCourse(String c_id);
}
