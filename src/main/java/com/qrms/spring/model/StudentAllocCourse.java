package com.qrms.spring.model;

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
	
	public StudentAllocCourse(Electives elective, Course courseId,StudentAcad student, int prefNo) {
		super();
		this.elective = elective;
		this.courseId = courseId;
		this.prefNo = prefNo;
		this.student = student;
	}
	
	public StudentAllocCourse() {
		
	}
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int Id;
	
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
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	
}
