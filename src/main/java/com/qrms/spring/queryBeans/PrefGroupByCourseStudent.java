package com.qrms.spring.queryBeans;

public class PrefGroupByCourseStudent {
	
	private long count; //stores the number of students who submitted the preference form for the course 
	private String courseId;
	
	public PrefGroupByCourseStudent(long count, String courseId) {
		this.courseId = courseId;
		this.count = count;
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
