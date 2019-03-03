package com.qrms.spring.queryBeans;

public class StudentPrefCountInfo {

	private long totalStudentCount;
	private long submitCount;
	private String deptId;
	private String courseId;
	private String courseName;
	private String year;
	private int sem;
	
	public StudentPrefCountInfo() {
		
	}
	
	public long getTotalStudentCount() {
		return totalStudentCount;
	}
	public void setTotalStudentCount(long totalStudentCount) {
		this.totalStudentCount = totalStudentCount;
	}
	public long getSubmitCount() {
		return submitCount;
	}
	public void setSubmitCount(long submitCount) {
		this.submitCount = submitCount;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
}
