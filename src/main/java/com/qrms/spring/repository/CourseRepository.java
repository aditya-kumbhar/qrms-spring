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
	ArrayList<Course> findByCourseSemAndCourseYear(int courseSem, String courseYear);
	ArrayList<Course> findByCourseSemAndCourseYearAndCourseTypeAndDepartmentAndIsTheoryAndStudAllocFlag(int sem, String year, char cType,Department d,int isTheory,int stud_allocation_flag);
	ArrayList<Course> findByCourseTypeNot(char courseType);
	
	ArrayList<Course> findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(int sem, String year, char cType,Department d,int isTheory,int stud_allocation_flag);
	ArrayList<Course> findByDepartmentAndCourseSemAndCourseYearAndIsTheoryAndCourseTypeNotAndStudAllocFlag(int sem,String year, char cType,Department d,int isTheory,int stud_allocation_flag);
	ArrayList<Course> findByCourseSemAndCourseYearAndCourseTypeAndIsTheoryAndStudAllocFlag(int sem, String year, char c,
			int i, int j);
	ArrayList<Course> findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlagNot(
			int courseSem, String courseYear, char c, Department department, int i, int j);
	ArrayList<Course> findByStudAllocFlagNot(int i);
	ArrayList<Course> findByDepartment(Department department);

}
