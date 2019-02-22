package com.qrms.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="faculty_course_history")
public class FacultyCourseHistory {
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name="faculty_user_name")
	private StudentAcad facultyUserName;
	
	@Column(name="course_taught")
	private Course courseTaught;

	public StudentAcad getFacultyUserName() {
		return facultyUserName;
	}

	public void setFacultyUserName(StudentAcad facultyUserName) {
		this.facultyUserName = facultyUserName;
	}

	public Course getCourseTaught() {
		return courseTaught;
	}

	public void setCourseTaught(Course courseTaught) {
		this.courseTaught = courseTaught;
	}

	public FacultyCourseHistory(StudentAcad facultyUserName, Course courseTaught) {
		super();
		this.facultyUserName = facultyUserName;
		this.courseTaught = courseTaught;
	}

	public FacultyCourseHistory() {
		
	}
	
}
