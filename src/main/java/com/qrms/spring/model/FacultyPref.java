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
@Table(name="faculty_pref")
public class FacultyPref {
	
	public FacultyPref(String userName, String courseId, Electives elective, int prefNo, Integer courseExp,
			Integer prereq1Exp, Integer prereq2Exp) {
		super();
		this.userName = userName;
		this.courseId = courseId;
		this.elective = elective;
		this.prefNo = prefNo;
		this.courseExp = courseExp;
		this.prereq1Exp = prereq1Exp;
		this.prereq2Exp = prereq2Exp;
	}
	
	public FacultyPref() {
		
	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	//course id
	@Column(name="course_id")
	private String courseId;
		
	//Child (owner) of FK relation to Electives -- do not cascade on delete/update	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "electiveId")
	private Electives elective;
	
	@Column(name="pref_no")
	private int prefNo;

	//no of times taught
	@Column(name="course_exp")
	private Integer courseExp;
	
	//no of times prerequisite1 taught
	@Column(name="prereq1_exp")
	private Integer prereq1Exp;
		
	//no of times prerequisite2 taught
	@Column(name="prereq2_exp")
	private Integer prereq2Exp;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
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

	public Integer getCourseExp() {
		return courseExp;
	}

	public void setCourseExp(Integer courseExp) {
		this.courseExp = courseExp;
	}

	public Integer getPrereq1Exp() {
		return prereq1Exp;
	}

	public void setPrereq1Exp(Integer prereq1Exp) {
		this.prereq1Exp = prereq1Exp;
	}

	public Integer getPrereq2Exp() {
		return prereq2Exp;
	}

	public void setPrereq2Exp(Integer prereq2Exp) {
		this.prereq2Exp = prereq2Exp;
	}

}
