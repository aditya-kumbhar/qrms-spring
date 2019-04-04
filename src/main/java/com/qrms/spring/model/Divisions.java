package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//year, dept, noOfbatches, divName, divId
@Entity
@Table(name="divisions")
public class Divisions {
	
	@Id
	@Column(name="div_id")
	String divId;
	
	@Column(name = "year")	
	String year;
	
	// Child   of FK relation to Department -- do not cascade on delete/update
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@Column(name = "no_of_batches")
	private Integer noOfBatches;
	
	@Column(name = "div_name")
	private Character divName;

	public Divisions() {
		
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

	public String getDivId() {
		return divId;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	public void setNoOfBatches(Integer noOfBatches) {
		this.noOfBatches = noOfBatches;
	}

	public Character getDivName() {
		return divName;
	}

	public void setDivName(Character divName) {
		this.divName = divName;
	}

}
