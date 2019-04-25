package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "open_faculty_prefs")
public class OpenFacultyPrefs {

	@Id
	@Column(name="dept_id")
	private String deptId;
	
	//0 -- even 1 -- odd
	@Column(name="sem_type")
	int semType;

	public String getDepId() {
		return deptId;
	}

	public void setDepId(String depId) {
		this.deptId = depId;
	}

	public int getSemType() {
		return semType;
	}

	public void setSemType(int semType) {
		this.semType = semType;
	}

	public OpenFacultyPrefs() {
		super();
	}

	
}
