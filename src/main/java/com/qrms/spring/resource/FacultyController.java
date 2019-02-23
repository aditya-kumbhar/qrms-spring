package com.qrms.spring.resource;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.FacultyPref;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.FacultyPrefRepository;

@Controller
@RequestMapping("/u/faculty")
public class FacultyController {
	
	@Autowired
	private FacultyPrefRepository facultyPrefRepository;
	
	@Autowired
	private FacultyAcadRepository facultyAcadRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/home")
	public String facultyHome() {
		return "faculty/home";
	}
		
	@RequestMapping(value = "/getFacultyPrefs", method = RequestMethod.GET)
	public ModelAndView getFacultyPref() {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		
		FacultyAcad currFacultyAcad = facultyAcadRepository.findByUserName(userName);
		
		Optional <FacultyPref> facultyPrefs = facultyPrefRepository.findByUserName(currFacultyAcad.getUserName());
		
		if(facultyPrefs.isPresent()) {
			model.addObject("msg","Your preferences for electives have been recorded already!");
			model.setViewName("faculty/home");
			return model;
		}else {
			//Have to change the below, get courses with semester even or odd depending on the current month
			ArrayList <Course> courseList = courseRepository.findAll();
			
			if(courseList.size()==0) {
				System.out.println("No courses exist");
			}else {
				System.out.println("Courses exist");
			}
			model.addObject("courseList", courseList);
			model.addObject("course1",new String());
			model.addObject("course2",new String());
			model.addObject("course3",new String());
			model.addObject("course4",new String());
			model.setViewName("faculty/facultyPref");
			
		
			return model;
		}
	
	}
	
	@RequestMapping(value = "/setFacultyPrefs", method = RequestMethod.POST)
	public ModelAndView addPreferences(@Valid String course1,String course2,String course3,String course4) {
		
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();

		FacultyPref facultyPref = new FacultyPref();
		facultyPref.setUserName(userName);
		facultyPref.setCourse1(courseRepository.findByCourseId(course1));
		facultyPref.setCourse2(courseRepository.findByCourseId(course2));
		facultyPref.setCourse3(courseRepository.findByCourseId(course3));
		facultyPref.setCourse4(courseRepository.findByCourseId(course4));

		facultyPrefRepository.save(facultyPref);
		model.addObject("msg","Your preferences for electives have been recorded!");
		model.setViewName("faculty/home");
		return model;
		
	}

}