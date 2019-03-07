package com.qrms.spring.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Columns-
 * course
 * companionCourse
 */
@Entity
@Table(name="companion_course")
public class CompanionCourse {

	public CompanionCourse(Course course, Course companionCourse) {
		super();
		this.course = course;
		this.companionCourse = companionCourse;
	}
	
	public CompanionCourse() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "companion_course")
	private Course companionCourse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCompanionCourse() {
		return companionCourse;
	}

	public void setCompanionCourse(Course companionCourse) {
		this.companionCourse = companionCourse;
	}
}
