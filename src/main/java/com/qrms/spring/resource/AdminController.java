package com.qrms.spring.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Users;
import com.qrms.spring.model.Course;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentPrefRepository;
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
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentPrefRepository studentPrefRepository;
	
	
	@Autowired
	private FacultyAcadRepository facultyAcadRepository;
	
	private StudentAcad student;
	
	private FacultyAcad faculty;
	//private Course course;
	
	private List<Department> departments; 
	
	private List<Role> roles; 
	
	@GetMapping("/home")
	public String adminHome() {
		return "admin/home";
	}

	//Display register user form
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUsers() {
		ModelAndView model = new ModelAndView();
		Users user = new Users();
		roles = roleRepository.findAll();
		model.addObject("user",user);
		model.addObject("roles",roles);
		model.setViewName("admin/registerUsers");
		return model;
	}
	
	//Handle register user form
	@RequestMapping(value = "/register_users", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid Users user, String role) {
		ModelAndView model = new ModelAndView();	
		Role userRole = roleRepository.findByRole(role);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		//check unique email
		String email = user.getEmail();
		if(!userDetails.isUniqueEmail(email)) {
			model.addObject("errmsg","A user is already registered with the given email");
			model.addObject("user",new Users());
			model.addObject("roles",roles);
			model.setViewName("admin/registerUsers");
			return model;
		}
		
		userDetails.saveUser(user);

		if(role.equals("STUDENT")) {
			student = new StudentAcad();
			System.out.println("Adding user to studAcad");
			student.setUserName(user.getUserName());
			studentAcadRepository.save(student);
			
		}
		else if(role.equals("FACULTY")) {
			faculty = new FacultyAcad();
			System.out.println("Adding user to facultyAcad");
			faculty.setUserName(user.getUserName());
			facultyAcadRepository.save(faculty);
			
		}
		model.addObject("msg","User has been successfully registered");
		model.addObject("user",new Users());
		model.addObject("roles",roles);
		model.setViewName("admin/registerUsers");
		return model;
	}
	
	//Display add course page
	@RequestMapping(value = "/add-course", method = RequestMethod.GET)
	public ModelAndView addCourses() {
		ModelAndView model = new ModelAndView();
		Course course = new Course();
		departments = departmentRepository.findAll();
		model.addObject("course",course);		
		model.addObject("departments",departments);
		model.setViewName("admin/addCourses");
		return model;
	}
	
	//Handle add course form
	@RequestMapping(value = "/add_courses", method = RequestMethod.POST)
	public ModelAndView addCourse(@Valid Course course, String dept, String electiveIdOption) {
		ModelAndView model = new ModelAndView();
		
		Department deptObj = departmentRepository.findByDeptName(dept);
		course.setDepartment(deptObj);
		course.setStudAllocFlag(0);
		
		course.setElectiveId(electiveIdOption);
		model.addObject("msg","Course has been added successfully");
		model.addObject("course",new Course());
		model.addObject("departments",departments);
		model.setViewName("admin/addCourses");
		
		courseRepository.save(course);
		return model;
	}
	
<<<<<<< HEAD
	@RequestMapping(value="/start_student_allocation",method=RequestMethod.POST)
	public ModelAndView start_student_allocation() {
		int semester = 8;
		String year = "BE";
		String academic_year = "2018-19";
		
//		ArrayList<StudentPref> studentPrefs = studentPrefRepository.findBySemesterEqualsAndYearEqualsAndAcademicYearEquals(semester, year, academic_year);
		
		ArrayList<StudentAcad> studentAcads = studentAcadRepository.findBySemEqualsAndYearEqualsAndAcademicYearEquals(semester, year, academic_year);
		
		Collections.sort(studentAcads);
		for (StudentAcad studentAcad : studentAcads) {
			System.out.println(studentAcad.getUserName());
		}
		
		ModelAndView model = new ModelAndView();
		
//		model.setViewName("/admin/StudentAllocation");
		return model;
		
	}
	
	
	//Course Allocation
	@RequestMapping(value="/get_start_student_allocation",method=RequestMethod.GET)
=======
	//Retrieve Student course allocation page 
	@RequestMapping(value="/studentCourseAllocationStatus",method=RequestMethod.GET)
>>>>>>> f06f9c2e48ecde499313da7f2d7cf3cf5b2f4bc2
	public ModelAndView get_student_allocation() {
			
		ModelAndView model = new ModelAndView();
		Course course = new Course();
		
		model.addObject("course",course);
		model.setViewName("/admin/studCourseAllocation");
		return model;
	
	}
	
	//single mode: start course allocation for specified course ID
		@RequestMapping(value="/start_student_allocation_single",method=RequestMethod.POST)
		public ModelAndView start_student_allocation_single(Course course) {
			
			ModelAndView model = new ModelAndView();
			String msg="",err_msg="";
			
			
			Course c = courseRepository.findByCourseId(course.getCourseId());
			if(c == null) {
				model.addObject("err_msg","Invalid course ID");
				
			}
			else if(c.getCourseType()!='R') {
				if(c.getStudAllocFlag() == 1)
				{
					err_msg = "Course allocation already started for CourseID:"+c.getCourseId()+" - "+c.getCourseName();				
					model.addObject("err_msg",err_msg);
					
				}
				else {
					c.setStudAllocFlag(1);
					msg = "Course allocation started for Course ID: "+c.getCourseId()+" - "+c.getCourseName();				
					courseRepository.save(c);
					model.addObject("msg",msg);
					
				}					
			}
			else {
				err_msg = "Specified course is not an elective.";								
				model.addObject("err_msg",err_msg);
				
			}
												
			model.addObject("course",new Course());
			model.setViewName("/admin/studCourseAllocation");		
			return model;
		}
	
	
	//batch mode: start course allocation for specified year and semester
	@RequestMapping(value="/start_student_allocation_batch",method=RequestMethod.POST)
	public ModelAndView start_student_allocation_all(Course course) {
		
		ModelAndView model = new ModelAndView();
		String msg;
				
		ArrayList<Course> startCourses = courseRepository.findByCourseSemAndCourseYear(course.getCourseSem(), course.getCourseYear());
				
		for(Course c: startCourses) {
			
			if(c.getCourseType()!='R') {
				c.setStudAllocFlag(1);
				courseRepository.save(c);					
			}
						
		}
					
		model.addObject("course",new Course());
		model.addObject("msg","Student course allocation process started for : "+course.getCourseYear()+" Sem:"+course.getCourseSem());
		model.setViewName("/admin/studCourseAllocation");		
		return model;
	}	
	
}
