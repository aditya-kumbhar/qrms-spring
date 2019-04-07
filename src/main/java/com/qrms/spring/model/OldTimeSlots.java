package com.qrms.spring.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="old_time_slots")
public class OldTimeSlots {
	
	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="resource_id")
	private Resource resourceId;
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="day")
	private String day;

	@Column(name="activity")
	private String activity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_incharge")
	private Users activityIncharge;
	
	public Users getActivityIncharge() {
		return activityIncharge;
	}

	public void setActivityIncharge(Users activityIncharge) {
		this.activityIncharge = activityIncharge;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Resource getResourceId() {
		return resourceId;
	}

	public void setResourceId(Resource resourceId) {
		this.resourceId = resourceId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public OldTimeSlots(Resource resourceId, Time startTime, Time endTime, Date date, String day,String activity,Users activityIncharge) {
		super();
		this.resourceId = resourceId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.day = day;
		this.activity = activity;
		this.activityIncharge = activityIncharge;
	}
	
	public OldTimeSlots(){
		
	}
}
