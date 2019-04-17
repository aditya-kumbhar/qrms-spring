package com.qrms.spring.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="time_table")
public class TimeTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tid")
	private int tid;
	
	//startTime
	//endTime
	//roomNo/labNo
	//seats
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="resource_id")
	private Resource resourceId;

	@Column(name="day")
	private String day;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dept")
	private Department department;

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Resource getResourceId() {
		return resourceId;
	}

	public void setResourceId(Resource resourceId) {
		this.resourceId = resourceId;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public TimeTable() {
		// TODO Auto-generated constructor stub
	}

	public TimeTable(Time startTime, Time endTime, Resource resourceId, String day,
			Department department) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.resourceId = resourceId;
		this.day = day;
		this.department = department;
	}
	
	
}
