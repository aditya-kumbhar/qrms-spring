package com.qrms.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qrms.spring.model.StudentPref;
import com.qrms.spring.repository.StudentPrefRepository;

@Component
public class StudentPrefServiceImpl implements StudentPrefService {
	@Autowired
	private StudentPrefRepository studentPrefRepository;

	@Override
	public void saveStudentPref(StudentPref student, String username) {
		
		student.setUserName(username);
		studentPrefRepository.save(student);
	
	}
}
