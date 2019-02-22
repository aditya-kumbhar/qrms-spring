package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.FacultyAcad;

public interface FacultyAcadRepository  extends JpaRepository<FacultyAcad, Integer>{
	FacultyAcad findByUserName(String userName);
}
