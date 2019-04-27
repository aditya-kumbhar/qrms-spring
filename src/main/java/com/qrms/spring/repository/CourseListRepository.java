package com.qrms.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.CourseList;
import com.qrms.spring.model.Department;

@Repository
public interface CourseListRepository extends JpaRepository<CourseList, Integer>{
	
	//JPQL
	@Transactional
	@Modifying
	@Query("delete from CourseList c where c.facultyId in ?1")
	void deleteByFacultyIdList(List<String> facIdList);

	@Query("Select cl from CourseList cl where cl.facultyId in " + 
			"(SELECT fa.userName FROM com.qrms.spring.model.FacultyAcad fa where fa.department = ?1)")
	List<CourseList> findByFacultyIdDepartment(Department dept);

	List<CourseList> findByFacultyId(String userName);
	
}
