package com.qrms.spring.queryBeans;

import java.util.Comparator;

import com.qrms.spring.model.FacultyPref;

public class FacultyPrefNoComparator implements Comparator<FacultyPref> {
	 
    @Override
    public int compare(FacultyPref f1, FacultyPref f2) {
        return f2.getPrefNo() - f1.getPrefNo();
    }
}
