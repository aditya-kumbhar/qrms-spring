package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_prerequisites")
public class CoursePrerequisites {

	public CoursePrerequisites(String course, Course prerequisiteNo1, Course prerequisiteNo2) {
		super();
		this.course = course;
		this.prerequisiteNo1 = prerequisiteNo1;
		this.prerequisiteNo2 = prerequisiteNo2;
	}
	
	public CoursePrerequisites() {
	
	}
	
	@Id
	@Column(name="course_id")
	private String course;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prerequisite_no_1")
	private Course prerequisiteNo1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prerequisite_no_2")
	private Course prerequisiteNo2;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Course getPrerequisiteNo1() {
		return prerequisiteNo1;
	}

	public void setPrerequisiteNo1(Course prerequisiteNo1) {
		this.prerequisiteNo1 = prerequisiteNo1;
	}

	public Course getPrerequisiteNo2() {
		return prerequisiteNo2;
	}

	public void setPrerequisiteNo2(Course prerequisiteNo2) {
		this.prerequisiteNo2 = prerequisiteNo2;
	}
	
}
