package com.qrms.spring.queryBeans;

public class ElectiveBatchCount {
	public ElectiveBatchCount() {
		
	}
	private String electiveId;
	private Integer noOfBatches;
	public String getElectiveId() {
		return electiveId;
	}
	public void setElectiveId(String electiveId) {
		this.electiveId = electiveId;
	}
	public Integer getNoOfBatches() {
		return noOfBatches;
	}
	public void setNoOfBatches(Integer noOfBatches) {
		this.noOfBatches = noOfBatches;
	}
	public ElectiveBatchCount(String electiveId, Integer noOfBatches) {
		super();
		this.electiveId = electiveId;
		this.noOfBatches = noOfBatches;
	}
	
	public ElectiveBatchCount() {
		
	}
}
