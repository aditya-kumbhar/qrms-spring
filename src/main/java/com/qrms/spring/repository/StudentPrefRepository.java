package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.StudentPref;

@Repository
public interface StudentPrefRepository extends JpaRepository<StudentPref, Integer>{
	
	Optional<StudentPref> findByUserName(String user_name);
	//ArrayList<StudentPref> findBySemesterEqualsAndYearEqualsAndAcademicYearEquals(int semester,String year,String academic_year);
}
