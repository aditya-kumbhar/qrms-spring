package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="practical_list_faculty")
public class PracticalList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="b_id")
	private int bId;
	
	//eg: BECOB1, BECOB2
	@Column(name="lab_id")
	private String labId;
	
	//BECOB, BECOA..
	@Column(name="div_id")
	private String divId;
	
	public PracticalList(String labId, String practicalCourseId, String theoryCourseId, String facultyId,
			int noOfHours) {
		super();
		this.labId = labId;
		this.practicalCourseId = practicalCourseId;
		this.theoryCourseId = theoryCourseId;
		this.facultyId = facultyId;
		this.noOfHours = noOfHours;
	}

	@Column(name="practical_course_id")
	private String practicalCourseId;
	
	@Column(name="theory_course_id")
	private String theoryCourseId;
	
	@Column(name="faculty_id")
	private String facultyId;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getDivId() {
		return divId;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	@Column(name="no_of_hours")
	private int noOfHours;
	
	
	public String getTheoryCourseId() {
		return theoryCourseId;
	}

	public void setTheoryCourseId(String theoryCourseId) {
		this.theoryCourseId = theoryCourseId;
	}

	public PracticalList() {
		super();
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public int getBId() {
		return bId;
	}

	public void setBId(int bId) {
		this.bId = bId;
	}

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}



	public String getPracticalCourseId() {
		return practicalCourseId;
	}

	public void setPracticalCourseId(String practicalCourseId) {
		this.practicalCourseId = practicalCourseId;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	
}
