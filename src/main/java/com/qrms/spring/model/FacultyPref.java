package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="faculty_pref")
public class FacultyPref implements Comparable <FacultyPref>{
	
	public FacultyPref(String userName, String courseId, String electiveId, int prefNo, Integer courseExp,
			Integer prereq1Exp, Integer prereq2Exp, String year) {
		super();
		this.userName = userName;
		this.courseId = courseId;
		this.electiveId = electiveId;
		this.prefNo = prefNo;
		this.courseExp = courseExp;
		this.prereq1Exp = prereq1Exp;
		this.prereq2Exp = prereq2Exp;
		this.year = year;
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
	
	@Column(name="elective_id")
	private String electiveId;
	
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
	
	//year
	@Column(name="year")
	private String year;
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

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

	public String getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(String elective) {
		this.electiveId = elective;
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

	@Override
	public int compareTo(FacultyPref s) {
		// TODO Auto-generated method stub
		return (this.getPrefNo() > s.getPrefNo() ? -1 : 

            (this.getPrefNo() == s.getPrefNo() ? 0 : 1));
	}

}
