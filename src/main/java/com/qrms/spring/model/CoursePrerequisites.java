package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_prerequisites")
public class CoursePrerequisites {

	public CoursePrerequisites(String courseId, int isPrereq1Elective, int isPrereq2Elective, String prerequisiteNo1,
			String prerequisiteNo2) {
		super();
		this.courseId = courseId;
		this.isPrereq1Elective = isPrereq1Elective;
		this.isPrereq2Elective = isPrereq2Elective;
		this.prerequisiteNo1 = prerequisiteNo1;
		this.prerequisiteNo2 = prerequisiteNo2;
	}
	
	public CoursePrerequisites() {
	
	}
	
	@Id
	@Column(name="course_id")
	private String courseId;
	
	@Column(name="is_prereq_1_elective")
	private int isPrereq1Elective;

	@Column(name="is_prereq_2_elective")
	private int isPrereq2Elective;

	@Column(name="prereq1")
	private String prerequisiteNo1;

	@Column(name="prereq2")
	private String prerequisiteNo2;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getIsPrereq1Elective() {
		return isPrereq1Elective;
	}

	public void setIsPrereq1Elective(int isPrereq1Elective) {
		this.isPrereq1Elective = isPrereq1Elective;
	}

	public int getIsPrereq2Elective() {
		return isPrereq2Elective;
	}

	public void setIsPrereq2Elective(int isPrereq2Elective) {
		this.isPrereq2Elective = isPrereq2Elective;
	}

	public String getPrerequisiteNo1() {
		return prerequisiteNo1;
	}

	public void setPrerequisiteNo1(String prerequisiteNo1) {
		this.prerequisiteNo1 = prerequisiteNo1;
	}

	public String getPrerequisiteNo2() {
		return prerequisiteNo2;
	}

	public void setPrerequisiteNo2(String prerequisiteNo2) {
		this.prerequisiteNo2 = prerequisiteNo2;
	}
}
