package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Electives;

public interface ElectivesRepository extends JpaRepository<Electives, Integer>  {
	
	
}
