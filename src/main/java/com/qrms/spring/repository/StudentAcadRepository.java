package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.StudentAcad;

@Repository
public interface StudentAcadRepository extends JpaRepository<StudentAcad, Integer> {
	
	StudentAcad findByUserName(String name);
	ArrayList<StudentAcad> findBySemEqualsAndYearEquals(int semester,String year);
}
