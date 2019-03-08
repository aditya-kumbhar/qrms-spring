package com.qrms.spring.resource;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.FacultyPref;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
import com.qrms.spring.repository.FacultyAcadRepository;

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
	public ModelAndView getFacultyPref(String msg) {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		

		//FacultyAcad currUserAcad = facultyAcadRepository.findByUserName(userName);
		
		//System.out.println(currUserAcad.getDepartment());
		
		//ArrayList<Course> course_ids = courseRepository.findByDepartment(currUserAcad.getDepartment());
		
//		if(course_ids.size()!=0)
//		{
//			model.addObject("course_ids",course_ids);
//			if(msg!=null)
//				model.addObject("msg",msg);
//		}
//		else
//			model.addObject("err_msg","No courses exist");
		
		model.setViewName("/faculty/facultyPref");
		
		
		return model;
	}
	
	
	@RequestMapping(value = "/setFacultyPrefs", method = RequestMethod.POST)
	public ModelAndView addPreferences(@Valid String course1,String course2,String course3,String course4) {
		
		ModelAndView model = new ModelAndView();
		

		model.addObject("msg","Your preferences for electives have been recorded!");
		model.setViewName("faculty/home");
		return model;
		
	}

}