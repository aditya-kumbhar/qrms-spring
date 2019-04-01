package com.qrms.spring.service;

import java.util.ArrayList;

import com.qrms.spring.model.Department;
import com.qrms.spring.queryBeans.FacultyUsers;

public interface FacultyAcadService {

	public ArrayList<FacultyUsers> getFacultyList(Department dept);
	

}
