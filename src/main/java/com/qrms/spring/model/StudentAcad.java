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
@Table(name="student_acad")
public class StudentAcad  implements Comparable <StudentAcad>{


	public StudentAcad(){
		
	}

	@Override
	  public int compareTo(StudentAcad s) {          

	    return (this.getAggMarks() > s.getAggMarks() ? -1 : 

	            (this.getAggMarks() == s.getAggMarks() ? 0 : 1));     

	  }

	@Id
	@Column(name="user_name")
	private String userName;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_dets")
	private Users userDets;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@Column(name="year")
	private String year;
	
	@Column(name="semester")
	private int sem;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "div_id")
	private Divisions div;
	
	@Column(name="shift")
	private int shift;
	
	@Column(name="rollno")
	private String rollno;
	
	@Column(name="agg_marks")
	private Float aggMarks;
	
	//Parent of FK relation to StudentAlloc -- on update/delete cascade
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	Set<StudentAllocCourse> studentAllocs = new HashSet<StudentAllocCourse>();
	
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

	public Divisions getDiv() {
		return div;
	}

	public void setDiv(Divisions div) {
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

	public Set<StudentAllocCourse> getStudentAllocs() {
		return studentAllocs;
	}

	public void setStudentAllocs(Set<StudentAllocCourse> studentAllocs) {
		this.studentAllocs = studentAllocs;
	}
	
}
