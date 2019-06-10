package com.qrms.spring.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.qrms.spring.queryBeans.FacultyAllocations;

public class FacultyAllocationsChainedComparator implements Comparator<FacultyAllocations> {
	private List<Comparator<FacultyAllocations>> listComparators;


	@Override
	public int compare(FacultyAllocations arg0, FacultyAllocations arg1) {
		// TODO Auto-generated method stub
		for (Comparator<FacultyAllocations> comparator : listComparators) {
	        int result = comparator.compare(arg0, arg1);
	        if (result != 0) {
	            return result;
	        }
	    }
	    return 0;
	}
	
	
	@SafeVarargs
	public FacultyAllocationsChainedComparator(Comparator<FacultyAllocations>... comparators) {
	    this.listComparators = Arrays.asList(comparators);
	}
}
