package com.qrms.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Electives;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectivesRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ElectivesRepository electivesRepository;
	
	@Override
	public Course findByCourseId(String s) {
		return courseRepository.findByCourseId(s);
	}

	@Override
	public Electives findByElectiveCourseId(String s) {
		return electivesRepository.findByElectiveCourseId(s);
	}
	
	

}
