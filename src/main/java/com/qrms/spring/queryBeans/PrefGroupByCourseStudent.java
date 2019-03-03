package com.qrms.spring.queryBeans;

public class PrefGroupByCourseStudent {
	
	private long count; //stores the number of students who submitted the preference form for the course 
	private String courseId;
	private String userName;
	
	public PrefGroupByCourseStudent(long count, String courseId) {
		this.courseId = courseId;
		this.count = count;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public long getCount() {
		return count;
	}


	public void setCount(long count) {
		this.count = count;
	}


	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
}
