package com.qrms.spring.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_alloc_course")
public class StudentAllocCourse{

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int Id;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "elective_id")
	private Electives elective;
	
	public StudentAllocCourse() {
		
	}
	
	public StudentAllocCourse(Electives elective, Course courseId, String userName, int prefNo) {
		super();
		this.elective = elective;
		this.courseId = courseId;
		this.userName = userName;
		this.prefNo = prefNo;
	}

	public Electives getElective() {
		return elective;
	}

	public void setElective(Electives elective) {
		this.elective = elective;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPrefNo() {
		return prefNo;
	}

	public void setPrefNo(int prefNo) {
		this.prefNo = prefNo;
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="course_Id")
	private Course courseId;
	
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name="pref_no")
	private int prefNo;
	
}
