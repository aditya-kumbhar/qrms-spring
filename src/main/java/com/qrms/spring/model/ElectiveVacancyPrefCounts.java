package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_elective_vacancy_pref_counts")
public class ElectiveVacancyPrefCounts implements Comparable<ElectiveVacancyPrefCounts>{

	public ElectiveVacancyPrefCounts() {
		
	}
		
	@Column(name="course_id")
	private String courseId;
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(String electiveId) {
		this.electiveId = electiveId;
	}

	public ElectiveVacancyPrefCounts(String courseId, String electiveId, int vacancyCount, int prefCount) {
		super();
		this.courseId = courseId;
		this.electiveId = electiveId;
		this.vacancyCount = vacancyCount;
		this.prefCount = prefCount;
	}

	public int getVacancyCount() {
		return vacancyCount;
	}

	public void setVacancyCount(int vacancyCount) {
		this.vacancyCount = vacancyCount;
	}

	public int getPrefCount() {
		return prefCount;
	}

	public void setPrefCount(int prefCount) {
		this.prefCount = prefCount;
	}

	@Id
	@Column(name="elective_id")
	private String electiveId;
	
	@Column(name="vacancy_count")
	private int vacancyCount;
	
	@Column(name="pref_count")
	private int prefCount;
	
	@Override
	public int compareTo(ElectiveVacancyPrefCounts e) {          

	    return (this.getPrefCount() > e.getPrefCount() ? -1 : 

	            (this.getPrefCount() == e.getPrefCount() ? 0 : 1));     

	  }
}

