package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Department;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	ArrayList<Course> findByCourseSemAndCourseYearAndCourseTypeAndDepartment(int sem, String year, char cType,Department d);
	Course findByCourseId(String course_id);
	ArrayList<Course> findAll();
	ArrayList<Course> findByStudAllocFlag(int flag);
	ArrayList<Course> findByCourseSemAndCourseYearAndElectiveId(int courseSem, String courseYear, String electiveId);
	ArrayList<Course> findByCourseSemAndCourseYearAndCourseTypeAndDepartmentAndIsTheoryAndElectiveIdAndStudAllocFlag(int sem, String year, char cType,Department d,int isTheory,String ElectiveId,int stud_allocation_flag);
	ArrayList<Course> findByCourseSemAndCourseYear(int sem, String year);

}
