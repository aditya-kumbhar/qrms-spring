package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_prerequisite")
public class CoursePrerequisite {
	@Id
	@Column(name="course_id")
	private String courseId;
	
	@Column(name="prereq_courseid")
	private String prereq_courseid;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getPrereq_courseid() {
		return prereq_courseid;
	}

	public void setPrereq_courseid(String prereq_courseid) {
		this.prereq_courseid = prereq_courseid;
	}
}
