package com.qrms.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource {
	@Id
	@Column(name="resource_id")
	private String resourceId;
	
	@Column(name="resource_name")
	private String resourceName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept")
	private Department department;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="resource_incharge")
	private FacultyAcad resourceIncharge;
	
	@Column(name="resource_capacity")
	private Integer resourceCapacity;
	
	@Column(name="resource_type")
	private String resourceType;
	
	@Column(name="resource_info")
	private String resourceInfo;
	
	@OneToMany(mappedBy = "resourceId",cascade = CascadeType.ALL)
	Set<ResourceRequests> requests = new HashSet<ResourceRequests>();
	
	public Resource() {
		// TODO Auto-generated constructor stub
	}
	
	public Resource(String resourceId, String resourceName, Department department, FacultyAcad resourceIncharge,
			Integer resourceCapacity,String resourceType,String resourceInfo) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.department = department;
		this.resourceIncharge = resourceIncharge;
		this.resourceCapacity = resourceCapacity;
		this.resourceType = resourceType;
		this.resourceInfo = resourceInfo;
	}

	public String getResourceInfo() {
		return resourceInfo;
	}

	public void setResourceInfo(String resourceInfo) {
		this.resourceInfo = resourceInfo;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getResourceCapacity() {
		return resourceCapacity;
	}

	public void setResourceCapacity(Integer resourceCapacity) {
		this.resourceCapacity = resourceCapacity;
	}

	@OneToMany(mappedBy = "resourceId", cascade = CascadeType.ALL)
	Set<TimeSlots> timeSlots = new HashSet<TimeSlots>();
	
	@OneToMany(mappedBy = "resourceId", cascade = CascadeType.ALL)
	Set<OldTimeSlots> oldTimeSlots = new HashSet<OldTimeSlots>();

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public FacultyAcad getResourceIncharge() {
		return resourceIncharge;
	}

	public void setResourceIncharge(FacultyAcad resourceIncharge) {
		this.resourceIncharge = resourceIncharge;
	}
	
}
