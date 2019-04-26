package com.qrms.spring.queryBeans;

import java.util.List;

import com.qrms.spring.model.FacultyPref;

public class FacPrefsList {
	private List<FacultyPref> facultyPrefs;

	public List<FacultyPref> getFacultyPrefs() {
		return facultyPrefs;
	}

	public void setFacultyPrefs(List<FacultyPref> facultyPrefs) {
		this.facultyPrefs = facultyPrefs;
	}
}
