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
	private Users resourceIncharge;
	
	@Column(name="resource_capacity")
	private int resourceCapacity;
	
	public Resource(String resourceId, String resourceName, Department department, Users resourceIncharge,
			int resourceCapacity) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.department = department;
		this.resourceIncharge = resourceIncharge;
		this.resourceCapacity = resourceCapacity;
	}

	public int getResourceCapacity() {
		return resourceCapacity;
	}

	public void setResourceCapacity(int resourceCapacity) {
		this.resourceCapacity = resourceCapacity;
	}

	@OneToMany(mappedBy = "resourceId", cascade = CascadeType.ALL)
	Set<TimeSlots> timeSlots = new HashSet<TimeSlots>();

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

	public Users getResourceIncharge() {
		return resourceIncharge;
	}

	public void setResourceIncharge(Users resourceIncharge) {
		this.resourceIncharge = resourceIncharge;
	}
	
}
