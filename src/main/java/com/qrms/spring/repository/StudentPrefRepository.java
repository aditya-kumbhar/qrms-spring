package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.StudentPref;

@Repository
public interface StudentPrefRepository extends JpaRepository<StudentPref, Integer>{
	
	
	ArrayList<StudentPref> findByUserName(String user_name);
	ArrayList<StudentPref> findByUserNameAndCourseId(String user_name,String courseId);
	ArrayList<StudentPref> findByCourseIdEquals(String electiveId);
//	void deleteByCourseId(String courseId);

}
