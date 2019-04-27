package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qrms.spring.model.CompanionCourse;

public interface CourseCompanionRespositoy extends JpaRepository<CompanionCourse, Integer> {

	CompanionCourse findByCourse(String c);
	
	//JPQL
	@Query("SELECT "+
			"new CompanionCourse(cc.course,cc.companionCourse) "+ 
			"FROM CompanionCourse cc "+
			"WHERE cc.companionCourse=?1 AND cc.course IN "+
			"("
			+ "SELECT eb.electiveId FROM com.qrms.spring.model.ElectiveBatches eb"
			+ ")")
	ArrayList<CompanionCourse> findByCompanionCourseAndCourseIdInElectiveBatches(String courseId);

	CompanionCourse findByCompanionCourse(String courseId);

}
