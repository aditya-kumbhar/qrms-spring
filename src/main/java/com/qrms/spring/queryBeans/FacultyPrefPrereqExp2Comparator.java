package com.qrms.spring.queryBeans;

import java.util.Comparator;

import com.qrms.spring.model.FacultyPref;

public class FacultyPrefPrereqExp2Comparator implements Comparator<FacultyPref> {
	 
    @Override
    public int compare(FacultyPref f1, FacultyPref f2) {
        return f2.getPrereq2Exp() - f1.getPrereq2Exp();
    }
}
