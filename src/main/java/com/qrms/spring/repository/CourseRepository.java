package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	Optional<Course> findByCourseIdAndDepartmentAndCourseYearAndCourseSemAndIsTheory(String companionTheory,
			Department department, String courseYear, int courseSem, int i);
	Optional<Course> findByCourseIdAndDepartmentAndIsTheory(String companionTheory, Department department, int i);
	ArrayList<Course> findByDepartmentAndCourseType(Department department, char c);
	ArrayList<Course> findByCourseYear(String year);
	ArrayList<Course> findByCourseYearAndCourseTypeAndDepartment(String year, char c, Department department);
	
	//JPQL
	@Query("SELECT "+
			"new com.qrms.spring.model.Course(c.courseId, c.courseName, c.courseCredits, c.department, c.courseType, c.courseYear, c.courseSem, c.studAllocFlag, c.isTheory, c.noOfHours) "+ 
			"FROM Course c "+
			"WHERE c.courseSem%2=0 and c.courseType='R'")
	ArrayList<Course> findEvenSemCoursesAndCourseTypeReg();
	
	//JPQL
	@Query("SELECT "+
			"new com.qrms.spring.model.Course(c.courseId, c.courseName, c.courseCredits, c.department, c.courseType, c.courseYear, c.courseSem, c.studAllocFlag, c.isTheory, c.noOfHours) "+ 
			"FROM Course c "+
			"WHERE c.courseSem%2<>0 and c.courseType='R'")
	ArrayList<Course> findOddSemCoursesAndCourseTypeReg();
	
	//JPQL
	@Query("SELECT "+
			"new com.qrms.spring.model.Course(c.courseId, c.courseName, c.courseCredits, c.department, c.courseType, c.courseYear, c.courseSem, c.studAllocFlag, c.isTheory, c.noOfHours) "+ 
			"FROM Course c "+
			"WHERE c.courseSem%2<>0 and c.courseType<>'R'")
	ArrayList<Course> findOddSemCoursesAndCourseTypeNotReg();
	
	//JPQL
		@Query("SELECT "+
				"new com.qrms.spring.model.Course(c.courseId, c.courseName, c.courseCredits, c.department, c.courseType, c.courseYear, c.courseSem, c.studAllocFlag, c.isTheory, c.noOfHours) "+ 
				"FROM Course c "+
				"WHERE c.courseSem%2=0 and c.courseType<>'R'")
		ArrayList<Course> findEvenSemCoursesAndCourseTypeNotReg();
	
		ArrayList<Course> findByCourseType(char c);
	
		
		
}
