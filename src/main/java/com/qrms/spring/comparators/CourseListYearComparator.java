package com.qrms.spring.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.CourseList;
import com.qrms.spring.model.Electives;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectivesRepository;

public class CourseListYearComparator implements Comparator<CourseList> {
	private CourseRepository courseRepository;
	private ElectivesRepository electivesRepository;
    @Override
    public int compare(CourseList d1, CourseList d2) {
    	System.out.println(d1.getCourseId());
    	Optional<Course> c1 = courseRepository.findByCourseIdifExists(d1.getCourseId());
    	Optional<Course> c2 = courseRepository.findByCourseIdifExists(d2.getCourseId());
    	String s1,s2;
    	
    	if(!c1.isPresent()) {
    		Electives e1 = electivesRepository.findByElectiveCourseId(d1.getCourseId());
    		s1 = e1.getCourse().getCourseYear();
    	}else {
    		s1 = c1.get().getCourseYear();
    	}
    	if(!c2.isPresent()) {
    		Electives e2 = electivesRepository.findByElectiveCourseId(d1.getCourseId());
    		s2 = e2.getCourse().getCourseYear();
    	}else {
    		s2 = c2.get().getCourseYear();
    	}
    	
    	List<String> years= Arrays.asList("ME1","ME2","BE","TE","SE","FE");
        return years.indexOf(s1)-years.indexOf(s2);
    }
}
