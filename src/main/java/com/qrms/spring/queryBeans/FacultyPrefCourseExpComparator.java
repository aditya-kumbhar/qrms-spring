package com.qrms.spring.queryBeans;

import java.util.Comparator;

import com.qrms.spring.model.FacultyPref;

public class FacultyPrefCourseExpComparator implements Comparator<FacultyPref> {
	 
    @Override
    public int compare(FacultyPref f1, FacultyPref f2) {
        return f2.getCourseExp() - f1.getCourseExp();
    }
}
