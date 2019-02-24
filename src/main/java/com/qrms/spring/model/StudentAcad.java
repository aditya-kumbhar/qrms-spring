package com.qrms.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_acad")
public class StudentAcad  implements Comparable <StudentAcad>{

	@Id
	@Column(name="user_name")
	private String userName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@Column(name="year")
	private String year;
	
	@Column(name="semester")
	private int sem;
	
	@Column(name="division")
	private String div;
	
	@Column(name="shift")
	private int shift;
	
	@Column(name="rollno")
	private String rollno;
	
	@Column(name="agg_marks")
	private Float aggMarks;
	
	@Column(name="academic_year")
	private String academicYear;

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public Float getAggMarks() {
		return aggMarks;
	}

	public void setAggMarks(Float aggMarks) {
		this.aggMarks = aggMarks;
	}

	public StudentAcad(){
		
	}
	@Override
	  public int compareTo(StudentAcad s) {          

	    return (this.getAggMarks() > s.getAggMarks() ? -1 : 

	            (this.getAggMarks() == s.getAggMarks() ? 0 : 1));     

	  }

	
}
