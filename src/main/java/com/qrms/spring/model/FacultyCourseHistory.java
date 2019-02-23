package com.qrms.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="faculty_course_history")
public class FacultyCourseHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_name")
	private FacultyAcad facultyUserName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="course_taught")
	private Course courseTaught;
	
	@Column(name="course_experience")
	private int courseExperience;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseExperience() {
		return courseExperience;
	}

	public void setCourseExperience(int courseExperience) {
		this.courseExperience = courseExperience;
	}

	public FacultyAcad getFacultyUserName() {
		return facultyUserName;
	}

	public void setFacultyUserName(FacultyAcad facultyUserName) {
		this.facultyUserName = facultyUserName;
	}

	public Course getCourseTaught() {
		return courseTaught;
	}

	public void setCourseTaught(Course courseTaught) {
		this.courseTaught = courseTaught;
	}

	public FacultyCourseHistory(FacultyAcad facultyUserName, Course courseTaught,int courseExperience) {
		super();
		this.facultyUserName = facultyUserName;
		this.courseTaught = courseTaught;
		this.courseExperience = courseExperience;
	}

	public FacultyCourseHistory() {
		
	}
	
}
