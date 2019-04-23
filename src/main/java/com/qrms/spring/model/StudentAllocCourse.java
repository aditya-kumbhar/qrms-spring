package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_alloc_course")
public class StudentAllocCourse{
	
	public StudentAllocCourse(int id,String batchId, Course courseId,Electives elective,StudentAcad student,int prefNo ) {
		super();
		this.id = id;
		this.elective = elective;
		this.courseId = courseId;
		this.prefNo = prefNo;
		this.student = student;
		this.batchId = batchId;
	}
	public StudentAllocCourse(Electives elective, Course courseId,StudentAcad student, int prefNo,String batchId) {
		super();
		this.elective = elective;
		this.courseId = courseId;
		this.prefNo = prefNo;
		this.student = student;
		this.batchId = batchId;
	}
	
	public StudentAllocCourse() {
		
	}
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "elective_id")
	private Electives elective;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_Id")
	private Course courseId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student")
	private StudentAcad student;

	@Column(name="pref_no")
	private int prefNo;
	
	@Column(name="batch_id")
	private String batchId;
	
	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public StudentAcad getStudent() {
		return student;
	}

	public void setStudent(StudentAcad student) {
		this.student = student;
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
	
	public int getPrefNo() {
		return prefNo;
	}

	public void setPrefNo(int prefNo) {
		this.prefNo = prefNo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
