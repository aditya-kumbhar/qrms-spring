package com.qrms.spring.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.qrms.spring.model.Divisions;

public class DivisionsChainedComparator implements Comparator <Divisions>{
	private List<Comparator<Divisions>> listComparators;


	@Override
	public int compare(Divisions arg0, Divisions arg1) {
		// TODO Auto-generated method stub
		for (Comparator<Divisions> comparator : listComparators) {
	        int result = comparator.compare(arg0, arg1);
	        if (result != 0) {
	            return result;
	        }
	    }
	    return 0;
	}
	
	
	@SafeVarargs
	public DivisionsChainedComparator(Comparator<Divisions>... comparators) {
	    this.listComparators = Arrays.asList(comparators);
	}
}