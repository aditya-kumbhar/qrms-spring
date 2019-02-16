package com.qrms.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.repository.StudentAcadRepository;

@Component
public class StudentAcadServiceImpl implements StudentAcadService {

	@Autowired
	private StudentAcadRepository studentAcadRepository;

	@Override
	public void saveStudentAcad(StudentAcad student, String username) {
		
		student.setUserName(username);
		studentAcadRepository.save(student);
	
	}
	
	
}
