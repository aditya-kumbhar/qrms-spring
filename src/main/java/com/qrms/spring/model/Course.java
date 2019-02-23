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
	
	@Column(name="elective_id")
	private String electiveId;
	
	//0 = allocation not yet started by admin
	//1 = allocation has been started and students can give prefs
	@Column(name="stud_allocation_flag")
	private int studAllocFlag=0;
	
	@Column(name="is_theory")
	private int isTheory;
	
	@Column(name="no_of_hours")
	private Integer noOfHours;
	
	public int getIsTheory() {
		return isTheory;
	}

	public void setIsTheory(int isTheory) {
		this.isTheory = isTheory;
	}

	public Integer getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(Integer noOfHours) {
		this.noOfHours = noOfHours;
	}

	public String getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(String elective_id) {
		this.electiveId = elective_id;
	}

	public int getStudAllocFlag() {
		return studAllocFlag;
	}

	public void setStudAllocFlag(int studAllocFlag) {
		this.studAllocFlag = studAllocFlag;
	}

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
	
	public Course(String courseId, String courseName, Integer courseCredits, Department department, char courseType,
			String courseYear, int courseSem, String electiveId, int studAllocFlag, int isTheory, int noOfHours) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCredits = courseCredits;
		this.department = department;
		this.courseType = courseType;
		this.courseYear = courseYear;
		this.courseSem = courseSem;
		this.electiveId = electiveId;
		this.studAllocFlag = studAllocFlag;
		this.isTheory = isTheory;
		this.noOfHours = noOfHours;
	}

	public Course() {
		
	}
	
}
