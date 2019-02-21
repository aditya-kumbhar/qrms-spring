package com.qrms.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Users;

@Repository
public interface StudentPrefRepository extends JpaRepository<StudentPref, Integer>{
	
	Optional<StudentPref> findByUserNameEqualsAndSemesterEqualsAndYearEqualsAndAcademicYearEquals(String user_name,int semester,String year,String academic_year);
}
