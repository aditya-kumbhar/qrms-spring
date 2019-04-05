package com.qrms.spring.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.qrms.spring.model.FacultyPref;

public class FacultyPrefChainedComparator implements Comparator <FacultyPref>{
	private List<Comparator<FacultyPref>> listComparators;


	@Override
	public int compare(FacultyPref arg0, FacultyPref arg1) {
		// TODO Auto-generated method stub
		for (Comparator<FacultyPref> comparator : listComparators) {
	        int result = comparator.compare(arg0, arg1);
	        if (result != 0) {
	            return result;
	        }
	    }
	    return 0;
	}
	
	
	@SafeVarargs
	public FacultyPrefChainedComparator(Comparator<FacultyPref>... comparators) {
	    this.listComparators = Arrays.asList(comparators);
	}
}