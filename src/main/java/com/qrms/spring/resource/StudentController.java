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
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectiveVacancyPrefCountsRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentPrefRepository;

@Controller
@RequestMapping("/u/student")
public class StudentController {
	
	@Autowired
	private StudentPrefRepository studentPrefRepository;
		
	@Autowired
	private StudentAcadRepository studentAcadRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ElectiveVacancyPrefCountsRepository electiveVacancyPrefCountsRepository;
	
	@GetMapping("/home")
	public String studentHome() {
		return "student/home";
	}
	
	
	@RequestMapping(value = "/getStudentPrefs", method = RequestMethod.GET)
	public ModelAndView studentPref() {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		

		StudentAcad currUserAcad = studentAcadRepository.findByUserName(userName);
		
		Optional <StudentPref> studentPrefs = studentPrefRepository.findByUserName(currUserAcad.getUserName());
		if(studentPrefs.isPresent()) {
			model.addObject("msg","Your preferences for electives have been recorded already!");
			model.setViewName("student/home");
			return model;
		}else {
			ArrayList<Course> courseList=courseRepository.findByCourseSemAndCourseYearAndCourseTypeAndDepartmentAndIsTheoryAndElectiveIdAndStudAllocFlag(currUserAcad.getSem(),currUserAcad.getYear(),'E',currUserAcad.getDepartment(),1,"el3",1);
			
			if(courseList.size()==0) {
				System.out.println("No courses exist");
			}else {
				System.out.println("Courses exist");
			}
			
			model.addObject("studentPref",new StudentPref());
			model.addObject("courseList", courseList);
			model.addObject("course1",new String());
			model.addObject("course2",new String());
			model.addObject("course3",new String());
			model.addObject("course4",new String());
			model.setViewName("student/studentPref");
			return model;
		}
		
		
	}
	
	//Handle student preference form
	@RequestMapping(value = "/setStudentPrefs", method = RequestMethod.POST)
	public ModelAndView addPreferences(@Valid String course1,String course2,String course3,String course4) {
		
		ModelAndView model = new ModelAndView();	
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		Course c1 = courseRepository.findByCourseId(course1);
		Course c2 = courseRepository.findByCourseId(course2);
		Course c3 = courseRepository.findByCourseId(course3);
		Course c4 = courseRepository.findByCourseId(course4);
		
		StudentPref studentPref = new StudentPref();
		studentPref.setUserName(userName);
		studentPref.setElectiveId(c1.getElectiveId());
		studentPref.setCourse1(c1);
		studentPref.setCourse2(c2);
		studentPref.setCourse3(c3);
		studentPref.setCourse4(c4);

		studentPrefRepository.save(studentPref);
		
		ElectiveVacancyPrefCounts electiveVacancyPrefCounts = electiveVacancyPrefCountsRepository.findByCourseId(course1);
		
		electiveVacancyPrefCounts.setCourseId(c1.getCourseId());
		int prefCount = electiveVacancyPrefCounts.getPrefCount();

		electiveVacancyPrefCounts.setPrefCount(++prefCount);

		electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);
		
		model.addObject("msg","Your preferences for electives have been recorded!");
		model.setViewName("student/home");
		return model;
	
	}
}
