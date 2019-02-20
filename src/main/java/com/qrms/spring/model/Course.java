package com.qrms.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@Column(name="course_id")
	private String courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_credits")
	private Integer courseCredits;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	//O: Open Elective, E: Normal Elective R: regular course
	@Column(name="course_type")
	private char courseType;
	
	@Column(name="course_year")
	private String courseYear;

	@Column(name="course_sem")
	private int courseSem;
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseCredits() {
		return courseCredits;
	}

	public void setCourseCredits(Integer courseCredits) {
		this.courseCredits = courseCredits;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public char getCourseType() {
		return courseType;
	}

	public void setCourseType(char courseType) {
		this.courseType = courseType;
	}

	public String getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public int getCourseSem() {
		return courseSem;
	}

	public void setCourseSem(int courseSem) {
		this.courseSem = courseSem;
	}
	
	public Course() {
		
	}
	
}
