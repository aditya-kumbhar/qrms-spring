package com.qrms.spring.service;

import java.util.ArrayList;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.queryBeans.StudentUsers;

public interface StudentAcadService {
	public void saveStudentAcad(StudentAcad student, String username);
	public ArrayList<StudentUsers> getStudentList(Department dept, String year);
	
}
