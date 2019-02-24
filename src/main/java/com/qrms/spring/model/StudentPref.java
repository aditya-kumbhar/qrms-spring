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
@Table(name="student_pref")
public class StudentPref{
	

	@Id
	@Column(name="user_name")
	private String userName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pref1")
	private Course course1;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pref2")
	private Course course2;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pref3")
	private Course course3;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pref4")
	private Course course4;

	@Column(name="elective_id")
	private String electiveId;
	
	public StudentPref(String userName, Course course1, Course course2, Course course3, Course course4, String electiveId) {
		super();
		this.userName = userName;
		this.course1 = course1;
		this.course2 = course2;
		this.course3 = course3;
		this.course4 = course4;
		this.electiveId = electiveId;
	}

	public StudentPref() {
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Course getCourse1() {
		return course1;
	}

	public void setCourse1(Course course1) {
		this.course1 = course1;
	}

	public Course getCourse2() {
		return course2;
	}

	public void setCourse2(Course course2) {
		this.course2 = course2;
	}

	public Course getCourse3() {
		return course3;
	}

	public void setCourse3(Course course3) {
		this.course3 = course3;
	}

	public Course getCourse4() {
		return course4;
	}

	public void setCourse4(Course course4) {
		this.course4 = course4;
	}
	
	public String getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(String electiveId) {
		this.electiveId = electiveId;
	}

	
}
