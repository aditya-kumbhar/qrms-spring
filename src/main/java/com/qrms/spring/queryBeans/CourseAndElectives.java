package com.qrms.spring.queryBeans;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Electives;

public class CourseAndElectives {
		
	private Course course;
	private Electives elective;	
	private String preReq1,preReq2;
	
	public String getPreReq1() {
		return preReq1;
	}
	public void setPreReq1(String preReq1) {
		this.preReq1 = preReq1;
	}
	public String getPreReq2() {
		return preReq2;
	}
	public void setPreReq2(String preReq2) {
		this.preReq2 = preReq2;
	}
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
