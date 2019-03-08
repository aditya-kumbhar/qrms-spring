package com.qrms.spring.queryBeans;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Electives;

public class CourseAndElectives {
		
	private Course course;
	private Electives elective;	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Electives getElective() {
		return elective;
	}
	public void setElective(Electives elective) {
		this.elective = elective;
	}
	
	public CourseAndElectives() {
		
	}
}
