package com.qrms.spring.queryBeans;

import java.util.Comparator;

import com.qrms.spring.model.FacultyPref;

public class FacultyPrefPrereqExp1Comparator implements Comparator<FacultyPref> {
		 
	    @Override
	    public int compare(FacultyPref f1, FacultyPref f2) {
	        return f1.getPrereq1Exp() - f2.getPrereq1Exp();
	    }
}
