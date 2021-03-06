package com.qrms.spring.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.qrms.spring.model.Divisions;


//1 - 2 for ascending
//2 - 1 for descending
public class DivisionsYearComparator implements Comparator<Divisions> {
	 
    @Override
    public int compare(Divisions d1, Divisions d2) {
    	
    	List<String> years= Arrays.asList("ME1","ME2","BE","TE","SE","FE");
        return years.indexOf(d1.getYear())-years.indexOf(d2.getYear());
    }
}
