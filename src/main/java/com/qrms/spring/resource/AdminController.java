package com.qrms.spring.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collector;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentAllocCourse;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.StudentCountByYearSem;
import com.qrms.spring.model.Course;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.ElectiveVacancyPrefCountsRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentAllocCourseRepository;
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
	private StudentAllocCourseRepository studentAllocCourseRepository;
	
	@Autowired
	private StudentPrefRepository studentPrefRepository;
	
	@Autowired
	private FacultyAcadRepository facultyAcadRepository;
	
	@Autowired
	private ElectivesRepository electivesRepository;
	
	private FacultyAcad faculty;
	
	private List<Department> departments; 
	
	private List<Role> roles; 
	
	@GetMapping("/home")
	public ModelAndView adminHome() {
		ModelAndView model = new ModelAndView();
		List<StudentCountByYearSem> totalStudentCount;
		
		totalStudentCount = studentAcadRepository.findStudentCountByYearSem();
		
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
		return model;
	}
	
	//Display add elective page
	@RequestMapping(value="/add-elective",method=RequestMethod.GET)
	public ModelAndView get_all_elective() {
		
		ModelAndView model = new ModelAndView();
		Electives elective = new Electives();
		
		ArrayList<Course> electivesList = courseRepository.findByCourseTypeNot('R');
		
		model.addObject("electivesList",electivesList);
		model.addObject("elective",elective);
		model.setViewName("/admin/addElective");
		return model;
		
	}
	
	//Handle add elective form
	@RequestMapping(value="/add_elective",method=RequestMethod.POST)
	public ModelAndView set_all_elective(String suffix, @Valid Electives elective,String courseId) {
		
		ModelAndView model = new ModelAndView();
		System.out.println("checkL-"+courseId);
		elective.setElectiveCourseId(courseId.concat(suffix));
		Course course = courseRepository.findByCourseId(courseId);
		elective.setCourse(course);
		
		if(electivesRepository.findByElectiveName(elective.getElectiveName()).isPresent()) {
			System.out.println("Elective with same name already exists");
			model.addObject("msg","Elective with same name already exists");
		}
		else {
			
			
			
			ElectiveVacancyPrefCounts electiveVacancyPrefCounts = new ElectiveVacancyPrefCounts();
			System.out.println(course.getCourseId());
			electiveVacancyPrefCounts.setCourseId(course.getCourseId());
			electiveVacancyPrefCounts.setPrefCount(0);
			electiveVacancyPrefCounts.setVacancyCount(80);
			electiveVacancyPrefCounts.setElectiveId(elective.getElectiveCourseId());
			electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);
			
			model.addObject("msg","Elective added successfully");
		
		}
		electivesRepository.save(elective);
		
		ArrayList<Course> electivesList = courseRepository.findByCourseTypeNot('R');
		
		model.addObject("electivesList",electivesList);
		model.addObject("elective",elective);
		
		model.setViewName("/admin/addElective");
		return model;
		
	}
	
	
//	@RequestMapping(value="/process_student_allocation",method=RequestMethod.GET)
//	public ModelAndView get_process_student_allocation() {
//		
//		ModelAndView model = new ModelAndView();
//		Course course = new Course();
//		
//		model.addObject("course",course);
//		model.setViewName("/admin/studStartAllocation");
//		return model;
//		
//	}
	
		//Get studStartAllocation HTML page
		@RequestMapping(value="/process_student_allocation",method=RequestMethod.GET)
		public ModelAndView process_student_allocation(ArrayList<Course> elective_ids) {
			ModelAndView model = new ModelAndView();
			
			ArrayList<Department> departments = departmentRepository.findAll();
			model.addObject("departments",departments);
			model.setViewName("/admin/studStartAllocation");
			model.addObject("course",new Course());
			
			if(!elective_ids.isEmpty())
			{	
				for(Course el : elective_ids) {
					System.out.println(el.getCourseName());
				}
				model.addObject("elective_ids",elective_ids);
				
			}
				return model;
		}

		//Retrieve all electives for specified dept, year and sem 
		@RequestMapping(value="/findElectiveForStartAllocation",method=RequestMethod.POST)
		public ModelAndView findElectiveForStartAllocation(@Valid Course course, String dept) {
		
			Department department = departmentRepository.findByDeptId(dept);
			
			System.out.println(course.getCourseSem()+" "+course.getCourseYear());
			System.out.println(department.getDeptId());
			
			ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,1);

			for(Course el : elective_ids) {
				System.out.println(el.getCourseName());
			}
			return process_student_allocation(elective_ids);
		
		}
	@RequestMapping(value="/process_student_allocation",method=RequestMethod.POST)
	public ModelAndView set_process_student_allocation(@Valid Course elective) {
		
		ModelAndView model = new ModelAndView();
		
		//check whether course is open for preferences or not
		
		if (allocation_of_students_to_elective_course(elective.getElectiveId(),elective.getCourseYear(),elective.getCourseSem())) {
			model.addObject("msg","The allocation has been completed!");
		}
		else {
			model.addObject("msg","No preferences are recorded!");
		}
		model.setViewName("/admin/studStartAllocation");
		return model;
		
	}	
	
	//Get studCourseAllocation HTML page
	@RequestMapping(value="/openCourseAllocation",method=RequestMethod.GET)
	public ModelAndView openCourseAllocation(ArrayList<Course> elective_ids) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.setViewName("/admin/studCourseAllocation");
		model.addObject("course",new Course());
		
		if(!elective_ids.isEmpty())
		{	
			for(Course el : elective_ids) {
				System.out.println(el.getCourseName());
			}
			model.addObject("elective_ids",elective_ids);
			
		}
			return model;
	}

	//Retrieve all electives for specified dept, year and sem 
	@RequestMapping(value="/findElective",method=RequestMethod.POST)
	public ModelAndView findElective(@Valid Course course, String dept) {
	
		Department department = departmentRepository.findByDeptId(dept);
		
		System.out.println(course.getCourseSem()+" "+course.getCourseYear());
		System.out.println(department.getDeptId());
		
		ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,0);

		for(Course el : elective_ids) {
			System.out.println(el.getCourseName());
		}
		return openCourseAllocation(elective_ids);
	
	}

	//open course allocation forms for specified electives, (set studAllocFlag = 1)
	@RequestMapping(value="/open_student_allocation",method=RequestMethod.POST)
	public ModelAndView open_student_allocation(String electiveIdOption) {
		
		ModelAndView model = new ModelAndView();
		
		Course startCourse = courseRepository.findByCourseId(electiveIdOption);				
				
		if(startCourse== null)
			model.addObject("err_msg","Specified elective does not exist for the given Year and Semester");
		else {			
				startCourse.setStudAllocFlag(1);
				courseRepository.save(startCourse);					
				
			}
		model.addObject("msg","Student course allocation process started for : "
			+startCourse.getCourseYear()+" Semester: "+startCourse.getCourseSem()
			+" "+startCourse.getCourseName());
	
		model.addObject("course",new Course());
		model.setViewName("/admin/studCourseAllocation");		
		return model;
	}	
	
	
	
	private boolean allocation_of_students_to_elective_course(String course_id,String year,int semester) {
		
		ArrayList<Electives> popularElectives = calculatePrefCounts(course_id,year,semester);
				
		
		ArrayList<StudentPref> studentPrefs = studentPrefRepository.findByCourseIdEquals(course_id);
		
		if(studentPrefs.size()!=0) {
			ArrayList<StudentPref> temp = new ArrayList<StudentPref>();
			
			for (StudentPref studentPref : studentPrefs) {
				
				Course c =courseRepository.findByCourseId(studentPref.getCourseId());
				if (c.getCourseSem()!=semester ||c.getCourseYear()!=year)
					{
						temp.add(studentPref);
					}
					
			}
			
			for (StudentPref studentPref : temp) {
				studentPrefs.remove(studentPref);
			}
			
			ArrayList<StudentAcad> studentAcads = studentAcadRepository.findBySemEqualsAndYearEquals(semester,year);

			Collections.sort(studentAcads);
			
			//for each student in reverse 
			
			for (StudentAcad studentAcad : studentAcads) {
				ArrayList<StudentPref> stud = studentPrefRepository.findByUserName(studentAcad.getUserName());
				
				if(stud.size()!=0) {
					
					Electives prefs[] = new Electives[4];
					int i = 0;
					for (StudentPref studPref : stud) {
						prefs[i]= studPref.getElective();
						i+=1;
					}
					
					int prefNo = 1;
					int flag = 0;
					for (Electives pref : prefs) {
						ElectiveVacancyPrefCounts e = electiveVacancyPrefCountsRepository.findByElectiveId(pref.getElectiveCourseId());
						
						if (e.getVacancyCount()>0)
						{
							e.setVacancyCount(e.getVacancyCount()+1);
//							StudentAllocCourse s = new StudentAllocCourse(elective_id,pref,studentAcad.getUserName(),prefNo);
							StudentAllocCourse s = new StudentAllocCourse(pref, pref.getCourse(), studentAcad.getUserName(), prefNo);
							studentAllocCourseRepository.save(s);
							flag = 1;
							break;
						}
						prefNo+=1;
					}
					if(flag==0) {
						//assign popular course
						System.out.println("No preference left!");
						System.out.println("Assigning course according to popularity!");
						for (Electives e : popularElectives) {
							ElectiveVacancyPrefCounts eC = electiveVacancyPrefCountsRepository.findByElectiveId(e.getElectiveCourseId());
							if (eC.getVacancyCount()>0)
							{
								eC.setVacancyCount(eC.getVacancyCount()+1);
								StudentAllocCourse s = new StudentAllocCourse(e,e.getCourse(),studentAcad.getUserName(),-1);
								studentAllocCourseRepository.save(s);
								flag = 1;
								break;
							}
						}
						if(flag==0) {
							System.out.println("NO OPTION LEFT!!!! NEED TO INCREASE CAPACITY!!!");
						}
					}
					
				}else {
					//assign popular course
					System.out.println("Hasn't given preference");
					System.out.println("Assigning course according to popularity!");
					int flag=0;
					for (Electives e : popularElectives) {
						ElectiveVacancyPrefCounts eC = electiveVacancyPrefCountsRepository.findByElectiveId(e.getElectiveCourseId());
						if (eC.getVacancyCount()>0)
						{
							eC.setVacancyCount(eC.getVacancyCount()+1);
							StudentAllocCourse s = new StudentAllocCourse(e,e.getCourse(),studentAcad.getUserName(),-1);
							studentAllocCourseRepository.save(s);
							flag = 1;
							break;
						}
					}
					if(flag==0) {
						System.out.println("NO OPTION LEFT!!!! NEED TO INCREASE CAPACITY!!!");
					}

				}
				
			}
			return true;
		}else {
			return false;
		}
		
	}

	private ArrayList<Electives> calculatePrefCounts(String course_id,String year,int semester){

		ArrayList <ElectiveVacancyPrefCounts> electiveVacancyPrefCounts = electiveVacancyPrefCountsRepository.findByCourseId(course_id);
		Collections.sort(electiveVacancyPrefCounts);
		

		ArrayList<Electives> electivesList = new ArrayList<>();
		
		
		for (ElectiveVacancyPrefCounts e : electiveVacancyPrefCounts) {
			Course c = courseRepository.findByCourseId(e.getCourseId());
			if(c.getCourseSem()==semester && c.getCourseYear()==year) {
				electivesList.add(electivesRepository.findByElectiveCourseId(e.getElectiveId()));
			}
		}
		return electivesList;
	}
	
	//for clearing preferences of a specific elective id, sem, year
	@RequestMapping(value="/findElectivesToClear",method=RequestMethod.GET)
	public ModelAndView get_find_electives_to_clear() {
		ModelAndView model = new ModelAndView();
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.addObject("course",new Course());
		model.setViewName("/admin/clearStudPref");
		return model;
	}

	//for clearing preferences of a specific elective id, sem, year
		@RequestMapping(value="/findElectivesToClear",method=RequestMethod.POST)
		public ModelAndView set_find_electives_to_clear(Course course, String dept) {
			ModelAndView model = new ModelAndView();
			Department department = departmentRepository.findByDeptId(dept);
			
			System.out.println(course.getCourseSem()+" "+course.getCourseYear());
			System.out.println(department.getDeptId());
			
			ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,1);

			for(Course el : elective_ids) {
				System.out.println(el.getCourseName());
			}
			
			ArrayList<Department> departments = departmentRepository.findAll();
			
			model.addObject("departments",departments);
			model.addObject("course",new Course());
			model.addObject("elective_ids",elective_ids);
			model.setViewName("/admin/clearStudPref");
			return model;
		}
		//for clearing preferences of a specific elective id, sem, year
		@Transactional
		@RequestMapping(value="/clear_preferences",method=RequestMethod.POST)
		public ModelAndView clear_prefernces(String electiveIdOption) {
			
			ModelAndView model = new ModelAndView();
			System.out.println(electiveIdOption);
			studentPrefRepository.deleteByCourseId(electiveIdOption);
			//deletes the department -_-
			
			
			
			//reason - cascade.all
			ArrayList<Department> departments = departmentRepository.findAll();
			model.addObject("departments",departments);
			model.addObject("course",new Course());
			model.setViewName("/admin/clearStudPref");
			model.addObject("msg","Cleared preferences for Course Id: "+electiveIdOption);
			return model;
		}
}
