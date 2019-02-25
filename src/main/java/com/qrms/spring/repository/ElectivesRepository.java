package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Electives;

public interface ElectivesRepository extends JpaRepository<Electives, Integer>  {
	ArrayList <Electives> findByCourse(Course course);
	Electives findByElectiveCourseId(String electiveId);
}
