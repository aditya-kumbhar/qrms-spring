package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty_alloted_hours")
public class FacultyAllotedHours {
	
	@Id
	@Column(name="faculty_id")
	private String facultyId;
	
	@Column(name="practical_hours")
	private int practicalHours;
	
	@Column(name="theory_hours")
	private int theoryHours;
	
	@Column(name="max_hours")
	private int maxHours;
	
	@Column(name="alloted_hours")
	private int allotedHours;

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String faculty) {
		this.facultyId = faculty;
	}

	public int getPracticalHours() {
		return practicalHours;
	}

	public void setPracticalHours(int practicalHours) {
		this.practicalHours = practicalHours;
	}

	public int getTheoryHours() {
		return theoryHours;
	}

	public void setTheoryHours(int theoryHours) {
		this.theoryHours = theoryHours;
	}

	public int getMaxHours() {
		return maxHours;
	}

	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}

	public int getAllotedHours() {
		return allotedHours;
	}

	public void setAllotedHours(int allotedHours) {
		this.allotedHours = allotedHours;
	}

	public FacultyAllotedHours(String facultyId, int practicalHours, int theoryHours, int maxHours, int allotedHours) {
		super();
		this.facultyId = facultyId;
		this.practicalHours = practicalHours;
		this.theoryHours = theoryHours;
		this.maxHours = maxHours;
		this.allotedHours = allotedHours;
	}
	
	public FacultyAllotedHours() {
		
	}
	
	
}
