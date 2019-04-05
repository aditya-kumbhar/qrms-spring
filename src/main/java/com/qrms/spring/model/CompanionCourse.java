package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Columns-
 * course
 * companionCourse
 */
@Entity
@Table(name="companion_course")
public class CompanionCourse {

	public CompanionCourse(String course, String companionCourse) {
		this.course = course;
		this.companionCourse = companionCourse;
	}
	
	public CompanionCourse() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="course_id")
	private String course;
	
	@Column(name = "companion_course")
	private String companionCourse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCompanionCourse() {
		return companionCourse;
	}

	public void setCompanionCourse(String companionCourse) {
		this.companionCourse = companionCourse;
	}
}
