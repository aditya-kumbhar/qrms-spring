package com.qrms.spring.service;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Electives;

public interface CourseService {
	
	Course findByCourseId(String s);
	Electives findByElectiveCourseId(String s);
}
