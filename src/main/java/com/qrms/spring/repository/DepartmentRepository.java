package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
		
		Department findByDeptId(String input_dept);

		Department findByDeptName(String input_dept);
		
		ArrayList<Department> findAll();
}
