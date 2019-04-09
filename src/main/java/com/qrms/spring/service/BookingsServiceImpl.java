package com.qrms.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.Department;
import com.qrms.spring.repository.DepartmentRepository;

@Service
public class BookingsServiceImpl implements BookingsService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public ArrayList<Department> listDepartments() {
		// TODO Auto-generated method stub
		System.out.println("okokokokok");
		return departmentRepository.findAll();
	}

}
