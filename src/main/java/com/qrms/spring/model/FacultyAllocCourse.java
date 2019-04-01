package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty_alloc_course")
public class FacultyAllocCourse {

	public FacultyAllocCourse() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "user_name")
	String userName;
	
	@Column(name = "prefno")	
	int prefNo;
	
	@Column(name = "course_id")
	String courseId;
	
	@Column(name = "no_of_hrs")
	int noOfHours;
	
	@Column(name = "is_elective")
	int isElective;
	
	@Column(name = "year")
	String year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPrefNo() {
		return prefNo;
	}

	public void setPrefNo(int prefNo) {
		this.prefNo = prefNo;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public int getIsElective() {
		return isElective;
	}

	public void setIsElective(int isElective) {
		this.isElective = isElective;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public FacultyAllocCourse(int id, String userName, int prefNo, String courseId, int noOfHours, int isElective,
			String year) {
		super();
		this.id = id;
		this.userName = userName;
		this.prefNo = prefNo;
		this.courseId = courseId;
		this.noOfHours = noOfHours;
		this.isElective = isElective;
		this.year = year;
	}
	
	
	
		
}
