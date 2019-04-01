package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Electives;

public interface ElectivesRepository extends JpaRepository<Electives, Integer>  {
	ArrayList <Electives> findByCourse(Course course);
	Electives findByElectiveCourseId(String electiveId);
	Optional<Electives> findByElectiveName(String electiveName);
	
	//JPQL
	@Query("SELECT "+
			"new com.qrms.spring.model.Electives(e.electiveCourseId, e.course, e.electiveName) "+ 
			"FROM Electives e "+
			"WHERE e.course.courseSem%2<>0")
	ArrayList<Electives> findOddSemCoursesAndCourseTypeNotReg();
	
	//JPQL
	@Query("SELECT "+
			"new com.qrms.spring.model.Electives(e.electiveCourseId, e.course, e.electiveName) "+ 
			"FROM Electives e "+
			"WHERE e.course.courseSem%2=0")
	ArrayList<Electives> findEvenSemCoursesAndCourseTypeNotReg();
	
}
