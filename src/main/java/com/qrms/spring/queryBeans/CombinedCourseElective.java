package com.qrms.spring.queryBeans;

public class CombinedCourseElective {
	String id;
	int noOfHours;
	int isElective;
	int isTheory;
	String year;
	int noOfBatches;
	
	public CombinedCourseElective(String id,int isElective,int noOfHours,String year,int noOfBatches,int isTheory) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.isElective = isElective;
		this.year = year;
		this.noOfHours = noOfHours;
		this.noOfBatches = noOfBatches;
		this.isTheory = isTheory;
	
	}

	public int getIsTheory() {
		return isTheory;
	}

	public void setIsTheory(int isTheory) {
		this.isTheory = isTheory;
	}

	public int getNoOfBatches() {
		return noOfBatches;
	}

	public void setNoOfBatches(int noOfBatches) {
		this.noOfBatches = noOfBatches;
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
