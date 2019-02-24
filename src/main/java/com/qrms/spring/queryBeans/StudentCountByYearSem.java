package com.qrms.spring.queryBeans;

public class StudentCountByYearSem {
	
	private long count;
	private int sem;
	private String year;
	
	public StudentCountByYearSem(long count,String year,int sem) {
		this.count = count;
		this.sem = sem;
		this.year = year;
		
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
