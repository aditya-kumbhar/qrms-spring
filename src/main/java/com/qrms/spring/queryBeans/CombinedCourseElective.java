package com.qrms.spring.queryBeans;

public class CombinedCourseElective {
	String id;
	int noOfHours;
	int isElective;
	String year;
	
	public CombinedCourseElective(String id,int isElective,int noOfHours,String year) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.isElective = isElective;
		this.year = year;
		this.noOfHours = noOfHours;
		
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public int getIsElective() {
		return isElective;
	}

	public void setIsElective(int isElective) {
		this.isElective = isElective;
	}
	
}
