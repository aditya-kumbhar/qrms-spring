package com.qrms.spring.queryBeans;

import com.qrms.spring.model.Electives;

public class PrefNumCountPerElective {
	private long count;
	private int prefNo;
	private String electiveId;
	private Electives elective;
	
	public long getCount() {
		return count;
	}
	public Electives getElective() {
		return elective;
	}
	public void setElective(Electives elective) {
		this.elective = elective;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getPrefNo() {
		return prefNo;
	}
	public void setPrefNo(int prefNo) {
		this.prefNo = prefNo;
	}
	
	public PrefNumCountPerElective(long count, int prefNo, Electives elective) {
		this.count = count;
		this.prefNo = prefNo;
		this.elective = elective;
	}
	public String getElectiveId() {
		return electiveId;
	}
	public void setElectiveId(String electiveId) {
		this.electiveId = electiveId;
	}
	
}
