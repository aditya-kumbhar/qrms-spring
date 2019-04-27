package com.qrms.spring.queryBeans;

public class StudentUsers {
	private int srNo;
	private String rollNo;
	private String name;
	private String div;
	private int shift;
	private float aggrMarks;
	private String userName;
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public StudentUsers() {
		
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public int getShift() {
		return shift;
	}
	public void setShift(int shift) {
		this.shift = shift;
	}
	public float getAggrMarks() {
		return aggrMarks;
	}
	public void setAggrMarks(float aggrMarks) {
		this.aggrMarks = aggrMarks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
