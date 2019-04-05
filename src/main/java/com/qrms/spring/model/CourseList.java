package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_list_faculty")
public class CourseList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="division_id")
	private int divisionId;
	
	@Column(name="course_id")
	private String courseId;
	
	@Column(name="division_name")
	private char divisionName;
	
	@Column(name="faculty_id")
	private String facultyId;
	
	public CourseList() {
		
	}
	
	public CourseList(String courseId, char divisionName, String facultyId) {
		super();
		this.courseId = courseId;
		this.divisionName = divisionName;
		this.facultyId = facultyId;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public char getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(char divisionName) {
		this.divisionName = divisionName;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	
}
