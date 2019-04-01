package com.qrms.spring.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.qrms.spring.queryBeans.CombinedCourseElective;

@Entity
@Table(name="student_alloc_course")
public class FacultyAllocCourse {

	public FacultyAllocCourse() {
		
	}
	
	String userName;
	int prefNo;
	CombinedCourseElective combinedCourseElective;
	
	
	
	public FacultyAllocCourse(String userName, int prefNo, CombinedCourseElective combinedCourseElective) {
		super();
		this.userName = userName;
		this.prefNo = prefNo;
		this.combinedCourseElective = combinedCourseElective;
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
	public CombinedCourseElective getCombinedCourseElective() {
		return combinedCourseElective;
	}
	public void setCombinedCourseElective(CombinedCourseElective combinedCourseElective) {
		this.combinedCourseElective = combinedCourseElective;
	}
	
	
	
}
