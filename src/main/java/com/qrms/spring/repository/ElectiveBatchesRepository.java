package com.qrms.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.ElectiveBatches;

@Repository
public interface ElectiveBatchesRepository extends JpaRepository<ElectiveBatches, Integer> {

	List<ElectiveBatches> findByDepartment(Department dept);
	
}
