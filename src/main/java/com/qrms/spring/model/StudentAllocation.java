package com.qrms.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_allocation")
public class StudentAllocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@Column(name="year")
	private String year;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="academic_year")
	private String academicYear;
	
	@Column(name="Elective")
	private String elective;
	
	//values: {"N":New,"S":Set,"E":Ended}
	//n:New allocation entry,Students cannot give preferences
	//S:Started,Students can give preferences
	//E:Ended,Students cannot give preferences
	
	@Column(name="isON")
	private String isON;
	
	public String getIsON() {
		return isON;
	}

	public void setIsON(String isON) {
		this.isON = isON;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getElective() {
		return elective;
	}

	public void setElective(String elective) {
		this.elective = elective;
	}
	
	public StudentAllocation() {
		
	}
	
	public StudentAllocation(String academicYear,String elective,String year,int semester,Department department,String isON) {
		this.academicYear = academicYear;
		this.department = department;
		this.elective = elective;
		this.semester = semester;
		this.year = year;
		this.isON = isON;
	}
	
	public StudentAllocation(StudentAllocation studentAllocation) {
		this.academicYear = studentAllocation.academicYear;
		this.department = studentAllocation.department;
		this.elective = studentAllocation.elective;
		this.id = studentAllocation.id;
		this.semester = studentAllocation.semester;
		this.year = studentAllocation.year;
		this.isON = studentAllocation.isON;
	}
	
}
