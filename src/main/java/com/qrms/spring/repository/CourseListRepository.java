package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.CourseList;

@Repository
public interface CourseListRepository extends JpaRepository<CourseList, Integer>{
	
	//JPQL
	@Query("delete from CourseList c where c.facultyId in ?1")
	void deleteByFacultyIdList(Integer id);
	
}
