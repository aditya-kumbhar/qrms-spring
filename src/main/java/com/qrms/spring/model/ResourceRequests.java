package com.qrms.spring.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="resource_requests")
public class ResourceRequests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="request_id")
	private int requestId;
	
	@ManyToOne
	@JoinColumn(name="resource_id")
	private Resource resourceId;
	
	@ManyToOne
	@JoinColumn(name="request_by")
	private FacultyAcad requestBy;
	
	@Column(name="slot_date")
	private Date slotDate;
	
	@Column(name="slot_start_time")
	private Time slotStartTime;
	
	@Column(name="slot_end_time")
	private Time slotEndTime;
	
	@Column(name="slot_activity_name")
	private String slotActivityName; 
	
	@Column(name="request_date")
	private Date requestedDate;
	
	@Column(name="request_time")
	private Time requestTime;
	
	@Column(name="slot_day")
	private String slotDay;
	
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Resource getResourceId() {
		return resourceId;
	}

	public void setResourceId(Resource resourceId) {
		this.resourceId = resourceId;
	}

	public FacultyAcad getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(FacultyAcad requestBy) {
		this.requestBy = requestBy;
	}

	public Date getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}

	public Time getSlotStartTime() {
		return slotStartTime;
	}

	public void setSlotStartTime(Time slotStartTime) {
		this.slotStartTime = slotStartTime;
	}

	public Time getSlotEndTime() {
		return slotEndTime;
	}

	public void setSlotEndTime(Time slotEndTime) {
		this.slotEndTime = slotEndTime;
	}

	public String getSlotActivityName() {
		return slotActivityName;
	}

	public void setSlotActivityName(String slotActivityName) {
		this.slotActivityName = slotActivityName;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Time getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Time requestTime) {
		this.requestTime = requestTime;
	}

	public String getSlotDay() {
		return slotDay;
	}

	public void setSlotDay(String slotDay) {
		this.slotDay = slotDay;
	}

	public ResourceRequests(int requestId,Resource resourceId, FacultyAcad requestBy, Date slotDate, Time slotStartTime,
			Time slotEndTime, String slotActivityName, Date requestedDate, Time requestTime,String slotDay) {
		super();
		this.requestId = requestId;
		this.resourceId = resourceId;
		this.requestBy = requestBy;
		this.slotDate = slotDate;
		this.slotStartTime = slotStartTime;
		this.slotEndTime = slotEndTime;
		this.slotActivityName = slotActivityName;
		this.requestedDate = requestedDate;
		this.requestTime = requestTime;
		this.slotDay = slotDay;
		
	}
	
	public ResourceRequests() {
		
	}
	
}
