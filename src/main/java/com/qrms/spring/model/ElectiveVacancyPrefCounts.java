package com.qrms.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_elective_vacancy_pref_counts")
public class ElectiveVacancyPrefCounts{

	public ElectiveVacancyPrefCounts() {
		
	}
	
	public ElectiveVacancyPrefCounts(String courseId, int vacancyCount, int prefCount) {
		super();
		this.courseId = courseId;
		this.vacancyCount = vacancyCount;
		this.prefCount = prefCount;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
	private String courseId;
	
	@Column(name="vacancy_count")
	private int vacancyCount;
	
	@Column(name="pref_count")
	private int prefCount;
}
