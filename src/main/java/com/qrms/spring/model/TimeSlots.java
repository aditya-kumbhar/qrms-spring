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
	private String tid;
	
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
	
	@Column(name="seats_occupied")
	private int seatsOccupied;

	@Column(name="date")
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	public int getSeatsOccupied() {
		return seatsOccupied;
	}

	public void setSeatsOccupied(int seatsOccupied) {
		this.seatsOccupied = seatsOccupied;
	}

	public TimeSlots(Time startTime, Time endTime, Resource resourceId, int seatsOccupied,Date date) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.resourceId = resourceId;
		this.seatsOccupied = seatsOccupied;
		this.date = date;
	}

	@Override
	public int compareTo(TimeSlots o) {
		// TODO Auto-generated method stub
		return (this.getStartTime().before(o.getStartTime()) ? -1 : 

            (this.getStartTime().equals(o) ? 0 : 1));
	}
	
}
