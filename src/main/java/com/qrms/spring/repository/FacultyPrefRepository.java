package com.qrms.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.FacultyPref;

public interface FacultyPrefRepository extends JpaRepository<FacultyPref, Integer>{
	Optional<FacultyPref> findByUserName(String user_name);
	
}
