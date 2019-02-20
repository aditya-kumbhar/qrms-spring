package com.qrms.spring.resource;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Role;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentPrefRepository;
import com.qrms.spring.service.CustomUserDetailsService;

@Controller
@RequestMapping("/u/student")
public class StudentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private StudentPrefRepository studentPrefRepository;
		
	@Autowired
	private StudentAcadRepository studentAcadRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	private Optional<StudentPref> studentPrefs;

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
		
		ArrayList<Course> courseList=courseRepository.findByCourseSemAndCourseYearAndCourseTypeAndDepartment(8,"BE",'E',currUserAcad.getDepartment());
		
		if(courseList.size()==0) {
			System.out.println("No courses exist");
		}else {
			System.out.println("Courses exist");
		}
		
		String arr[] = new String[100];
		
		int i = 0;
		for (Course course : courseList) {
			System.out.println(course.getCourseId());
			System.out.println("hello");
			arr[i]=course.getCourseName()+"("+course.getCourseName()+")";
			i++;
		}
		model.addObject("courseList", courseList);
		model.setViewName("student/studentPref");
		return model;
	}
	
	//Handle student pref form
	@RequestMapping(value = "/setStudentPrefs", method = RequestMethod.POST)
	public ModelAndView addPreferences() {
		
		ModelAndView model = new ModelAndView();	
		
		model.setViewName("student/studentPref");
		return model;
		
	}
}
