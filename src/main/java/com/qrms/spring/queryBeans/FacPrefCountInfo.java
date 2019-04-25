package com.qrms.spring.queryBeans;

public class FacPrefCountInfo {

	String deptName;
	String semType;
	int submitCount,totalFacultyCount;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getSemType() {
		return semType;
	}
	public void setSemType(String semType) {
		this.semType = semType;
	}
	public int getSubmitCount() {
		return submitCount;
	}
	public void setSubmitCount(int submitCount) {
		this.submitCount = submitCount;
	}
	public int getTotalFacultyCount() {
		return totalFacultyCount;
	}
	public void setTotalFacultyCount(int totalFacultyCount) {
		this.totalFacultyCount = totalFacultyCount;
	}
	public FacPrefCountInfo() {
	}
}
