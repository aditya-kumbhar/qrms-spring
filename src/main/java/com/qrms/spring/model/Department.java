package com.qrms.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="dept_id")
	private String deptId;
	
	@Column(name="dept_name")
	private String deptName;

	//Parent of FK relation to Course -- Department update/deletion cascades to courses
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	Set<Course> courses = new HashSet<Course>();
	
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
