package com.qrms.spring.model;

import java.util.Map;

import java.util.Comparator;

class CourseComparatorByYear implements Comparator<String>
{
	Map<String, Integer> map;
	public CourseComparatorByYear(Map<String, Integer> map)
	{
		this.map = map;
	}
	
	public int compare(String x, String y)
	{
		if (map.containsKey(x) && map.containsKey(y))
			return map.get(x) - map.get(y);
		else if (map.containsKey(y))
			return 1;
		else if (map.containsKey(x))
			return -1;
//		else
//			return x - y;
		return 0;
	}
}