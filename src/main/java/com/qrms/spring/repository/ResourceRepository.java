package com.qrms.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer>{

	List<Resource> findByDepartment(Department department);

	Resource findByResourceId(String concat);

}
