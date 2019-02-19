package com.qrms.spring.service;

import com.qrms.spring.model.StudentPref;

public interface StudentPrefService {
	public void saveStudentPref(StudentPref studentPref, String username);
}
