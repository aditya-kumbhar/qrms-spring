package com.qrms.spring.queryBeans;

import java.util.List;

public class ElectiveBatchCountList {
	private List<ElectiveBatchCount> electiveBatchCounts;
	private String year,deptId;
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public void setElectiveBatchCounts(List<ElectiveBatchCount> electiveBatchCounts) {
		this.electiveBatchCounts = electiveBatchCounts;
	}

	public List<ElectiveBatchCount> getElectiveBatchCounts() {
		return electiveBatchCounts;
	}

}
