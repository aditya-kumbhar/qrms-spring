package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Table to store active electives, with number of batches for each, used for faculty allocation
@Entity
@Table(name="elective_batches")
public class ElectiveBatches {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="b_id")
	private int bId;
	
	@Column(name = "elective_id")
	String electiveId;
	
	@Column(name = "year")
	String year;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@Column(name="div_name")
	private char divisionName;
	
	public char getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(char divisionName) {
		this.divisionName = divisionName;
	}

	@Column(name = "no_of_batches")
	private Integer noOfBatches;

	public String getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(String electiveId) {
		this.electiveId = electiveId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getNoOfBatches() {
		return noOfBatches;
	}

	public void setNoOfBatches(Integer noOfBatches) {
		this.noOfBatches = noOfBatches;
	}

	public ElectiveBatches() {
		super();
	}
	
	

}
