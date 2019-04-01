package com.qrms.spring.service;

import java.util.List;

import com.qrms.spring.model.StudentPref;
import com.qrms.spring.queryBeans.StudentPrefCountInfo;

public interface StudentPrefService {
	public void saveStudentPref(StudentPref studentPref, String username);
	public List<StudentPrefCountInfo> computeStudPrefTable();
	
}
