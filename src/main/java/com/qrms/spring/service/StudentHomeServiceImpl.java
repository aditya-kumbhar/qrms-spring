package com.qrms.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentAllocCourse;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentAllocCourseRepository;

@Service
public class StudentHomeServiceImpl implements StudentHomeService{

	@Autowired
	private StudentAcadRepository studentAcadRepository;
	
	@Autowired
	private StudentAllocCourseRepository studentAllocCourseRepository; 
	
	@Override
	public ModelAndView getStudentHome(String userName) {
		ModelAndView model = new ModelAndView();
		StudentAcad studentProfile = studentAcadRepository.findByUserName(userName);
		if(studentProfile!=null)
			model.addObject("studentProfile",studentProfile);
		ArrayList<StudentAllocCourse> studentAllocations = studentAllocCourseRepository.findByStudent(studentProfile);
		if(!studentAllocations.isEmpty())
			model.addObject("studentAllocations", studentAllocations);
		model.setViewName("/student/home");
		return model;
	}

}
