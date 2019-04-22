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
@Table(name="faculty_acad")
public class FacultyAcad {

	public FacultyAcad(String userName, Department department, double yearsOfExperience, String qualification,
			String designation) {
		super();
		this.userName = userName;
		this.department = department;
		this.yearsOfExperience = yearsOfExperience;
		this.qualification = qualification;
		this.designation = designation;
	}

	public FacultyAcad() {
	}
	
	@Id
	@Column(name="user_name")
	private String userName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@Column(name="years_of_experience")
	private Double yearsOfExperience;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="designation")
	private String designation;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_dets")
	private Users userDets;
	
	@OneToMany(mappedBy = "slotIncharge",cascade = CascadeType.ALL)
	Set<TimeSlots> timeSlots = new HashSet<TimeSlots>();
	
	@OneToMany(mappedBy = "slotIncharge",cascade = CascadeType.ALL)
	Set<TimeTable> timeTableSlots = new HashSet<TimeTable>();
	
	public Users getUserDets() {
		return userDets;
	}

	public void setUserDets(Users userDets) {
		this.userDets = userDets;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Double getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}
