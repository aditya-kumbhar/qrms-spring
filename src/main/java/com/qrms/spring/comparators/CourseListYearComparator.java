package com.qrms.spring.comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.CourseList;
import com.qrms.spring.model.Electives;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.service.CourseService;
import com.qrms.spring.service.CourseServiceImpl;


public class CourseListYearComparator implements Comparator<CourseList> {
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
    @Override
    public int compare(CourseList d1, CourseList d2) {
    	System.out.println(d1.getCourseId());
    	System.out.println(d2.getCourseId());
    	Course c1 = courseServiceImpl.findByCourseId("610102");
    	Course c2 = courseServiceImpl.findByCourseId(d2.getCourseId());
    	String s1,s2;
    	
    	if(c1==null) {
    		Electives e1 = courseServiceImpl.findByElectiveCourseId(d1.getCourseId());
    		s1 = e1.getCourse().getCourseYear();
    	}else {
    		s1 = c1.getCourseYear();
    	}
    	if(c2==null) {
    		Electives e2 = courseServiceImpl.findByElectiveCourseId(d2.getCourseId());
    		s2 = e2.getCourse().getCourseYear();
    	}else {
    		s2 = c2.getCourseYear();
    	}
    	
    	List<String> years= Arrays.asList("ME1","ME2","BE","TE","SE","FE");
        return years.indexOf(s1)-years.indexOf(s2);
    }
}
