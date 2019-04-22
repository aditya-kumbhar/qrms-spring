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
	@Column(name="id")
	private int id;
	
	
	
	@Column(name="course_id")
	private String courseId;
	
	@Column(name="division_id")
	private String divisionId;
	
	@Column(name="faculty_id")
	private String facultyId;
	
	@Column(name="no_of_hours")
	private int noOfHours;
	
	public CourseList() {
		
	}
	
	public CourseList(String courseId, String divisionId, String facultyId,int noOfHours) {
		super();
		this.courseId = courseId;
		this.divisionId = divisionId;
		this.facultyId = facultyId;
		this.noOfHours = noOfHours;
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	
}
