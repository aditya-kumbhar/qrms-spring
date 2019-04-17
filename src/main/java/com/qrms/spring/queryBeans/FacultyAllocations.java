package com.qrms.spring.queryBeans;

import java.util.HashMap;
import java.util.List;

import com.qrms.spring.model.CourseList;
import com.qrms.spring.model.PracticalList;

public class FacultyAllocations {
	String facultyId,name;
	
	HashMap<String,List<CourseList>> courseAndDivs;
	HashMap<String,List<PracticalList>> practicalsAndBatches;
	
	Integer theoryHours,practicalHours,allotedLoad,maxLoad;

	public FacultyAllocations() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	
	public HashMap<String, List<CourseList>> getCourseAndDivs() {
		return courseAndDivs;
	}

	public void setCourseAndDivs(HashMap<String, List<CourseList>> courseAndDivs) {
		this.courseAndDivs = courseAndDivs;
	}

	public HashMap<String, List<PracticalList>> getPracticalsAndBatches() {
		return practicalsAndBatches;
	}

	public void setPracticalsAndBatches( HashMap<String, List<PracticalList>> practicalsAndBatches) {
		this.practicalsAndBatches = practicalsAndBatches;
	}

	public Integer getTheoryHours() {
		return theoryHours;
	}

	public void setTheoryHours(Integer theoryHours) {
		this.theoryHours = theoryHours;
	}

	public Integer getPracticalHours() {
		return practicalHours;
	}

	public void setPracticalHours(Integer practicalHours) {
		this.practicalHours = practicalHours;
	}

	public Integer getAllotedLoad() {
		return allotedLoad;
	}

	public void setAllotedLoad(Integer allotedLoad) {
		this.allotedLoad = allotedLoad;
	}

	public Integer getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(Integer maxLoad) {
		this.maxLoad = maxLoad;
	}
	
	

}
