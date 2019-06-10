package com.qrms.spring.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.qrms.spring.model.CourseList;

public class CourseListChainedComaparator implements Comparator<CourseList> {
	private List<Comparator<CourseList>> listComparators;


	@Override
	public int compare(CourseList arg0, CourseList arg1) {
		// TODO Auto-generated method stub
		for (Comparator<CourseList> comparator : listComparators) {
	        int result = comparator.compare(arg0, arg1);
	        if (result != 0) {
	            return result;
	        }
	    }
	    return 0;
	}
	
	
	@SafeVarargs
	public CourseListChainedComaparator(Comparator<CourseList>... comparators) {
	    this.listComparators = Arrays.asList(comparators);
	}
}
