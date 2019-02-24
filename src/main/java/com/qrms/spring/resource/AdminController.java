package com.qrms.spring.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
import com.qrms.spring.queryBeans.StudentCountByYearSem;
import com.qrms.spring.model.Course;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.ElectiveVacancyPrefCountsRepository;
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
	private ElectiveVacancyPrefCountsRepository electiveVacancyPrefCountsRepository;
	
	@Autowired
	private StudentPrefRepository studentPrefRepository;
	
	@Autowired
	private FacultyAcadRepository facultyAcadRepository;
	
	
	private FacultyAcad faculty;
	
	private List<Department> departments; 
	
	private List<Role> roles; 
	
	@GetMapping("/home")
	public ModelAndView adminHome() {
		ModelAndView model = new ModelAndView();
		List<StudentCountByYearSem> totalStudentCount;
		
		totalStudentCount = studentAcadRepository.findStudentCountByYearSem();
		
		for(StudentCountByYearSem student: totalStudentCount) {
			
		}
		model.addObject("students",totalStudentCount);
		
		model.setViewName("admin/home");
		return model;
	}

	//Display register user form
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUsers() {
		ModelAndView model = new ModelAndView();
		Users user = new Users();
		roles = roleRepository.findAll();
		departments = departmentRepository.findAll();
		
		model.addObject("user",user);
		model.addObject("student",new StudentAcad());
		model.addObject("roles",roles);
		model.addObject("department", departments);
		model.setViewName("admin/registerUsers");
		return model;
	}
	
	//Handle register user form
	@RequestMapping(value = "/register_users", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid Users user, String role, StudentAcad student,String dept) {
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
		
			System.out.println("Adding user to studAcad");
			student.setUserName(user.getUserName());
			Department department = departmentRepository.findByDeptId(dept);
			student.setDepartment(department);
			studentAcadRepository.save(student);
			
		}
		else if(role.equals("FACULTY")) {
			
			faculty = new FacultyAcad();
			System.out.println("Adding user to facultyAcad");
			faculty.setUserName(user.getUserName());
			facultyAcadRepository.save(faculty);
			
		}
		departments = departmentRepository.findAll();
		
		model.addObject("msg","User has been successfully registered");
		model.addObject("user",new Users());
		model.addObject("roles",roles);
		model.addObject("department", departments);
		model.addObject("student",new StudentAcad());		
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
		if(course.getCourseType()=='E' || course.getCourseType()=='O')
		{
			ElectiveVacancyPrefCounts electiveVacancyPrefCounts = new ElectiveVacancyPrefCounts();
			System.out.println(course.getCourseId());
			electiveVacancyPrefCounts.setCourseId(course.getCourseId());
			electiveVacancyPrefCounts.setPrefCount(0);
			electiveVacancyPrefCounts.setVacancyCount(80);
			System.out.println("here!");
			electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);
		}
		return model;
	}

	@RequestMapping(value="/process_student_allocation",method=RequestMethod.POST)
	public ModelAndView process_student_allocation() {
		int semester = 8;
		String year = "BE";
	//	String academic_year = "2018-19";
		
//		ArrayList<StudentPref> studentPrefs = studentPrefRepository.findBySemesterEqualsAndYearEqualsAndAcademicYearEquals(semester, year, academic_year);
		
		ArrayList<StudentAcad> studentAcads = studentAcadRepository.findBySemEqualsAndYearEquals(semester, year);
		
		Collections.sort(studentAcads);
		for (StudentAcad studentAcad : studentAcads) {
			System.out.println(studentAcad.getUserName());
		}
		
		ModelAndView model = new ModelAndView();
		
//		model.setViewName("/admin/StudentAllocation");
		return model;
		
	}
	

	//Retrieve Student course allocation page 
	@RequestMapping(value="/studentCourseAllocationStatus",method=RequestMethod.GET)
	public ModelAndView get_student_allocation() {
			
		ModelAndView model = new ModelAndView();
		Course course = new Course();
		
		model.addObject("course",course);
		model.setViewName("/admin/studCourseAllocation");
		return model;
	
	}
	
	//Retrieve Student preference counts for each course elective
	@RequestMapping(value="studentPreferenceCounts",method=RequestMethod.GET)
	public ModelAndView get_student_preferences() {
		ModelAndView model = new ModelAndView();
		
		ArrayList <ElectiveVacancyPrefCounts> electiveVacancyPrefCounts = electiveVacancyPrefCountsRepository.findAll();
		
		model.addObject("electiveVacancyPrefCounts",electiveVacancyPrefCounts);
		for (ElectiveVacancyPrefCounts electiveVacancyPrefCounts2 : electiveVacancyPrefCounts) {
			System.out.println(electiveVacancyPrefCounts2.getVacancyCount()+" "+electiveVacancyPrefCounts2.getPrefCount());
		}
		model.setViewName("/admin/home");
		return model;
	}
	
	//start course allocation for specified year and semester
	@RequestMapping(value="/start_student_allocation",method=RequestMethod.POST)
	public ModelAndView start_student_allocation(Course course) {
		
		ModelAndView model = new ModelAndView();
		
		ArrayList<Course> startCourses = courseRepository.findByCourseSemAndCourseYearAndElectiveId(course.getCourseSem(), course.getCourseYear(),course.getElectiveId());				
		int flag = 0;
		
		if(startCourses.isEmpty())
			model.addObject("err_msg","Specified elective does not exist for the given Year and Semester");
		else {
			for(Course c: startCourses) {
			
				if(c.getCourseType()!='R') {
					if(c.getStudAllocFlag() == 0) {
						c.setStudAllocFlag(1);
						courseRepository.save(c);					
						flag = 1;
						
						//allocation algorithm
						allocation_of_students_to_elective_course(course.getElectiveId());
						
					}
				}
						
			}
		
			if(flag==0)
				model.addObject("err_msg","Student course allocation process already started for specified elective");
			else
				model.addObject("msg","Student course allocation process started for : "+course.getCourseYear()+" Semester: "+course.getCourseSem()+" Elective: "+course.getElectiveId().toUpperCase());
		}		
	
		model.addObject("course",new Course());
		model.setViewName("/admin/studCourseAllocation");		
		return model;
	}	
	
	
	private void allocation_of_students_to_elective_course(String elective_id) {

		ArrayList<StudentPref> studentPrefs = studentPrefRepository.findByElectiveIdEquals(elective_id);
		
		ArrayList<StudentAcad> studentAcads = studentAcadRepository.findBySemEqualsAndYearEquals(studentPrefs.get(0).getCourse1().getCourseSem(),studentPrefs.get(0).getCourse1().getCourseYear());
		
		Collections.sort(studentAcads);
		for (StudentAcad studentAcad : studentAcads) {
			System.out.println(studentAcad.getUserName());
		}
		
		//for each student in reverse 
		
	}
	
}
