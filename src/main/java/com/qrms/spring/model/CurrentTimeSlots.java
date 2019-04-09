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
@Table(name="current_time_slots")
public class CurrentTimeSlots {

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
	
	@Column(name="activity")
	private String activity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_incharge")
	private Users activityIncharge;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="day")
	private String day;

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

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Users getActivityIncharge() {
		return activityIncharge;
	}

	public void setActivityIncharge(Users activityIncharge) {
		this.activityIncharge = activityIncharge;
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

	public CurrentTimeSlots(Resource resourceId, Time startTime, Time endTime, String activity, Users activityIncharge,
			Date date, String day) {
		super();
		this.resourceId = resourceId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
		this.activityIncharge = activityIncharge;
		this.date = date;
		this.day = day;
	}
	
	public CurrentTimeSlots() {
		
	}
}
