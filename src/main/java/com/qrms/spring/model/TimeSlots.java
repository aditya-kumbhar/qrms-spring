package com.qrms.spring.model;

import java.sql.Date;
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
@Table(name="time_slots")
public class TimeSlots implements Comparable<TimeSlots>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tid")
	private int tid;
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="resource_id")
	private Resource resourceId;

	@Column(name="date")
	private Date date;
	
	@Column(name="activity_name")
	private String activityName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="slot_incharge")
	private FacultyAcad slotIncharge;
	
	@Column(name="request_id")
	private int requestId;
	
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public FacultyAcad getSlotIncharge() {
		return slotIncharge;
	}

	public void setSlotIncharge(FacultyAcad slotIncharge) {
		this.slotIncharge = slotIncharge;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

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
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public TimeSlots(Time startTime, Time endTime, Resource resourceId, Date date,FacultyAcad slotIncharge,String activityName,int requestId) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.resourceId = resourceId;
		this.date = date;
		this.slotIncharge = slotIncharge;
		this.activityName = activityName;
		this.requestId = requestId;
	}
	
	public TimeSlots() {
		
	}

	@Override
	public int compareTo(TimeSlots o) {
		return (this.getStartTime().before(o.getStartTime()) ? -1 : 

            (this.getStartTime().equals(o.getStartTime()) ? 0 : 1));
	}
	
}
