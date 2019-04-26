package com.qrms.spring.queryBeans;

public class StudentPrefCountInfo {

	private long totalStudentCount;
	private long submitCount;
	private String deptId;
	private String courseId;
	private String courseName;
	private String year;
	private int sem;
	private long count1,count2,count3,count4;	//prefCounts for each priority value
	
	public StudentPrefCountInfo(int c) {
		this.count1 = c;
		this.count2 = c;
		this.count3 = c;
		this.count4 = c;
	}
	public long getCount1() {
		return count1;
	}

	public void setCount1(long count1) {
		this.count1 = count1;
	}

	public long getCount2() {
		return count2;
	}

	public void setCount2(long count2) {
		this.count2 = count2;
	}

	public long getCount3() {
		return count3;
	}

	public void setCount3(long count3) {
		this.count3 = count3;
	}

	public long getCount4() {
		return count4;
	}

	public void setCount4(long count4) {
		this.count4 = count4;
	}

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
