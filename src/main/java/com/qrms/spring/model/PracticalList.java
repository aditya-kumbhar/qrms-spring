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
	
	@Column(name="lab_id")
	private String labId;
	
	@Column(name="lab_name")
	private String labName;
	
	@Column(name="faculty_id")
	private String facultyId;

	@Column(name="no_of_hours")
	private int noOfHours;
	
	public PracticalList() {
		super();
	}

	public PracticalList(String labId, String labName, String facultyId,int noOfHours) {
		super();
		this.labId = labId;
		this.labName = labName;
		this.facultyId = facultyId;
		this.noOfHours = noOfHours;
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

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	
}
