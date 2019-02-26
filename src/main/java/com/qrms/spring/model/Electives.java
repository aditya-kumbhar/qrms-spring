package com.qrms.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="electives")
public class Electives {
	
	@Id
	@Column(name="elective_course_id")
	private String electiveCourseId;


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name="elective_name")
	private String electiveName;
	
	@OneToMany(mappedBy="elective",cascade=CascadeType.ALL)
	Set<StudentPref> studentPref = new HashSet<StudentPref>();
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setElectiveName(String electiveName) {
		this.electiveName = electiveName;
	}

	public String getElectiveCourseId() {
		return electiveCourseId;
	}

	public void setElectiveCourseId(String electiveCourseId) {
		this.electiveCourseId = electiveCourseId;
	}

	public String getElectiveName() {
		return electiveName;
	}

	public void setElectiveCourseName(String electiveName) {
		this.electiveName = electiveName;
	}
	

	public Electives() {
		
	}
	
	public Electives(String electiveCourseId, Course course, String electiveName) {
		super();
		this.electiveCourseId = electiveCourseId;
		this.electiveName = electiveName;
		this.course = course;
	}
}
