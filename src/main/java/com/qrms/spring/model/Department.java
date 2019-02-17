package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="dept_id")
	private String deptId;
	
	@Column(name="dept_name")
	private String deptName;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String dept_id) {
		this.deptId = dept_id;
	}

	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Department() {
		
	}
	
}
