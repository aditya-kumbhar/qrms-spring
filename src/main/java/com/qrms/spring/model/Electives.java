package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="electives")
public class Electives {
	@Id
	@Column(name="elective_course_id")
	private String electiveCourseId;

	@Column(name="elective_id")
	private String electiveId;
	
	@Column(name="elective_name")
	private String electiveName;

	public String getElectiveCourseId() {
		return electiveCourseId;
	}

	public void setElectiveCourseId(String electiveCourseId) {
		this.electiveCourseId = electiveCourseId;
	}

	public String getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(String electiveId) {
		this.electiveId = electiveId;
	}

	public String getElectiveName() {
		return electiveName;
	}

	public void setElectiveCourseName(String electiveName) {
		this.electiveName = electiveName;
	}
	

	public Electives() {
		
	}
	
	public Electives(String electiveCourseId, String electiveId, String electiveName) {
		super();
		this.electiveCourseId = electiveCourseId;
		this.electiveId = electiveId;
		this.electiveName = electiveName;
	}
}
