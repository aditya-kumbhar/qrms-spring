package com.qrms.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_pref")
public class StudentPref{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	//course id
	@Column(name="course_id")
	private String courseId;
		
	//individual Elective
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pref")
	private Electives elective;
	
	@Column(name="pref_no")
	private int prefNo;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Electives getElective() {
		return elective;
	}

	public void setElective(Electives elective) {
		this.elective = elective;
	}

	public int getPrefNo() {
		return prefNo;
	}

	public void setPrefNo(int prefNo) {
		this.prefNo = prefNo;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public StudentPref(String userName, String courseId, Electives elective, int prefNo) {
		super();
		this.userName = userName;
		this.courseId = courseId;
		this.elective = elective;
		this.prefNo = prefNo;
	}

	public StudentPref() {
		
	}
}
