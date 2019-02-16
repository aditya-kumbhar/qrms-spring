package com.qrms.spring.resource;

import java.util.Arrays;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.Users;
import com.qrms.spring.model.Course;

import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.service.CustomUserDetailsService;

@Controller
@RequestMapping("/u/admin")
public class AdminController {
	
	@Autowired
	private CustomUserDetailsService userDetails;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private StudentAcadRepository studentAcadRepository;
	
	private StudentAcad student;
	
	@GetMapping("/home")
	public String adminHome() {
		return "admin/home";
	}


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUsers() {
		ModelAndView model = new ModelAndView();
		Users user = new Users();
		String string_role = new String();
		model.addObject("string_role",string_role);
		model.addObject("user",user);
		model.setViewName("admin/registerUsers");
		return model;
	}
	
	//Handle register user form
	@RequestMapping(value = "/register_users", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid Users user, String role) {
		ModelAndView model = new ModelAndView();	
		Role userRole = roleRepository.findByRole(role);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
				
		userDetails.saveUser(user);
		System.out.println("ROLE: "+role);
		if(role.equals("STUDENT")) {
			student = new StudentAcad();
			System.out.println("Adding user to studAcad");
			student.setUserName(user.getUserName());
			studentAcadRepository.save(student);
			
		}
		
		String string_role = new String();
		model.addObject("msg","User has been successfully registered");
		model.addObject("user",new Users());
		model.addObject("string_role",string_role);
		model.setViewName("admin/registerUsers");
		System.out.println("Controller username: "+user.getUserName());
		return model;
	}
	
//	//Display add course page
//	@RequestMapping(value = "/add-course", method = RequestMethod.GET)
//	public ModelAndView addCourses() {
//		ModelAndView model = new ModelAndView();
//		Course course = new Course();
//		model.addObject("course",course);
//		model.setViewName("admin/addCourses");
//		return model;
//	}
//	
//	//Handle add course form
//	@RequestMapping(value = "/add_courses", method = RequestMethod.POST)
//	public ModelAndView addCourse(@Valid Course course) {
//		ModelAndView model = new ModelAndView();	
//		
//		model.addObject("msg","Course has been added succesfully");
//		model.addObject("course",new Course());
//		model.setViewName("admin/addCourses");
//		System.out.println("Controller coursename: "+course.getCourseName());
//		return model;
//	}
	
	//Display add course page
	@GetMapping("/add-course")
	public String addCourses() {
		return "admin/addCourses";
	}
	
}
