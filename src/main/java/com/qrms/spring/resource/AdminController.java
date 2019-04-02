package com.qrms.spring.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentAllocCourse;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.FacultyUsers;
import com.qrms.spring.queryBeans.PrefNumCountPerElective;
import com.qrms.spring.queryBeans.StudentPrefCountInfo;
import com.qrms.spring.queryBeans.CombinedCourseElective;
import com.qrms.spring.queryBeans.StudentUsers;
import com.qrms.spring.queryBeans.FacultyPrefChainedComparator;
import com.qrms.spring.queryBeans.FacultyPrefNoComparator;
import com.qrms.spring.queryBeans.FacultyPrefPrereqExp2Comparator;
import com.qrms.spring.queryBeans.FacultyPrefPrereqExp1Comparator;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.CompanionCourse;
import com.qrms.spring.model.CoursePrerequisites;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.FacultyAllocCourse;
import com.qrms.spring.model.FacultyPref;
import com.qrms.spring.repository.CourseCompanionRespositoy;
import com.qrms.spring.repository.CoursePrerequisitesRepository;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.ElectiveVacancyPrefCountsRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.FacultyAllocCourseRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentAllocCourseRepository;
import com.qrms.spring.repository.StudentPrefRepository;
import com.qrms.spring.service.CustomUserDetailsService;
import com.qrms.spring.service.FacultyAcadService;
import com.qrms.spring.service.StudentAcadServiceImpl;
import com.qrms.spring.service.StudentPrefServiceImpl;

@Controller
@RequestMapping("/u/admin")
public class AdminController {
	
	@Autowired
	private CustomUserDetailsService userDetails;
	
	@Autowired
	private StudentPrefServiceImpl studPrefService;
	
	@Autowired
	private FacultyAcadService facAcadService;
	
	@Autowired
	private StudentAcadServiceImpl studAcadService;
	
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
	
	@Autowired
	private CourseCompanionRespositoy courseCompanionRepository;
	
	@Autowired
	private CoursePrerequisitesRepository coursePrerequisitesRepository;
	
	@Autowired
	private FacultyPrefRepository facultyPrefRepository;
	
	@Autowired
	private FacultyAllocCourseRepository facultyAllocCourseRepository;
	
	private FacultyAcad faculty;
	
	private List<Department> departments; 
	
	private List<Role> roles; 
	
	private String g_msg,g_err_msg;
	
	private List<StudentPrefCountInfo> prefSummaryList;
	
	
	//show home page, without tables
	@GetMapping("/home")
	public ModelAndView adminHome() {
		//allocFaculty(1);
		return getViewAdminHome(null);
	}
	
	//show home page
	public ModelAndView getViewAdminHome(List<StudentPrefCountInfo> studCountInfo) {
		ModelAndView model = new ModelAndView();
		
		if(studCountInfo!=null) {
			if(studCountInfo.isEmpty())
				model.addObject("err_msg","There are no open student elective preference forms");
			else {
				model.addObject("studCountInfo",studCountInfo);
				if(g_msg!=null)
					model.addObject("msg",g_msg);
				else
					model.addObject("err_msg",g_err_msg);
			}
		}
		model.setViewName("/admin/home");
		return model;		
	
	}
	
		
	@RequestMapping(value = "/getStudPrefDetailsTable_async", method = RequestMethod.GET)
	public String getStudPrefDetailsTable(Model model) {
		
		List<StudentPrefCountInfo> studCountInfo = studPrefService.computeStudPrefTable();
		if(studCountInfo.isEmpty()) {
			model.addAttribute("err_msg","There are no open student elective preference forms");
			return "admin/home:: messageDiv";
		}
		else {
				model.addAttribute("studCountInfo",studCountInfo);
				return "admin/home:: studPrefTable";
		}
		
	}
	
//************Departments Page****************
	@GetMapping("/getDepartmentsPage")
	public ModelAndView getDepartmentsPage() {
		ModelAndView model = new ModelAndView();
		departments = departmentRepository.findAll();
		
		model.addObject("departments", departments);
		model.addObject("newDept", new Department());
		model.setViewName("admin/departments");
		return model;
	}
	
	@RequestMapping(value = "/addDept", method = RequestMethod.POST)
	public ModelAndView addDept(Department newDept) {
		departmentRepository.save(newDept);
		return getDepartmentsPage();
	}
	
	@GetMapping("/manageDept")
	public String getManageDept(Model model, String dept) {
		Department department = departmentRepository.findByDeptId(dept);
		System.out.println(dept);
		model.addAttribute("manageDept",department);
		return "admin/departments:: manageDeptFragment";
	}
	
//***************end departments page************	
	@GetMapping("/getStudPrefDetailsTable")
	public ModelAndView getStudPrefDetailsTable() {		
	
		return getViewAdminHome(studPrefService.computeStudPrefTable());		
	}
		
	@Transactional
	@RequestMapping(value = "/performQuickAction-student", method = RequestMethod.POST)
	public ModelAndView studentAllocQuickAction(String courseId,  String selectAction, String courseName) {
		System.out.println(courseId);
		System.out.println(selectAction);
		String courseIds[] = courseId.split(",");
		String actions[] = selectAction.split(",");
		int i=0;
		for(i=0; i<actions.length;i++) {
			if(!actions[i].equals("none")) {
				break;
			}
		}
		
		if(actions[i].equals("clearPrefs")) {
			clear_preferences(courseIds[i]);			
			
		} else if(actions[i].equals("summary")) {
			//give summary and perform allocation
			prefSummaryList = new ArrayList<StudentPrefCountInfo>();
			Course course = courseRepository.findByCourseId(courseIds[i]);
			List<Electives> electives = electivesRepository.findByCourse(course);
			List<PrefNumCountPerElective> countPerElectiveList = studentPrefRepository.findPrefNumCountPerElective();
			
			for(Electives e: electives) {
				StudentPrefCountInfo ps = new StudentPrefCountInfo(0); //initialing all prefCounts = 0
				ps.setCourseId(e.getElectiveCourseId());
				ps.setCourseName(e.getElectiveName());
				
				for(PrefNumCountPerElective countPerElective : countPerElectiveList) {
					if(countPerElective.getElective().getElectiveCourseId().equals(e.getElectiveCourseId())) {
						switch(countPerElective.getPrefNo()) {
							case 1: ps.setCount1(countPerElective.getCount());	break;
							case 2: ps.setCount2(countPerElective.getCount());	break;
							case 3: ps.setCount3(countPerElective.getCount());	break;
							case 4: ps.setCount4(countPerElective.getCount());	break;													
						}
					}
				}				
				prefSummaryList.add(ps);
			}
			
			List<StudentPrefCountInfo> studentPrefInfo = studPrefService.computeStudPrefTable();
			ModelAndView model = new ModelAndView();
			model.addObject("studCountInfo",studentPrefInfo);
			model.addObject("prefSummaryList",prefSummaryList);
			model.setViewName("/admin/home");
			return model;
		}
		
		else {
			//action = close pref forms		
			Course course = courseRepository.findByCourseId(courseIds[i]);
			if(course.getStudAllocFlag()!=2) {
				course.setStudAllocFlag(2);
				courseRepository.save(course);
				g_msg = "Preference forms for Course-id: "+courseIds[i]+" have been closed";
				g_err_msg = null;						
			}
			else
			{
				g_err_msg = "Preference forms for Course-id: "+courseIds[i]+" are already closed";
				g_msg = null;									
			}
		}
		
		return getStudPrefDetailsTable();
	}
	
	
	@RequestMapping(value="/viewUsers", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		ModelAndView model = new ModelAndView();
		departments = departmentRepository.findAll();
		roles = roleRepository.findAll();
		
		model.addObject("roles",roles);
		model.addObject("department",departments);
		model.setViewName("admin/viewUsers");
		return model;
	}
	
	
	@RequestMapping(value="/viewStudents", method = RequestMethod.POST)
	public String viewStudents(Model model,  String year, String dept ) {
		
		Department department = departmentRepository.findByDeptId(dept);
		ArrayList<StudentUsers> studUsersList= studAcadService.getStudentList(department, year);
		model.addAttribute("studUsersList",studUsersList);
		return "admin/viewUsers:: studTable";
	}
	
	@RequestMapping(value="/viewAdmins", method = RequestMethod.GET)
	public String viewAdmins(Model model) {
		
		Set<Role> adminRole = new HashSet<Role>();
		adminRole.add(new Role(1,"ADMIN"));
		ArrayList<Users> adminUsers = userDetails.findByRole(adminRole);
		model.addAttribute("adminUsersList",adminUsers);
		return "admin/viewUsers:: adminsTable";
	
	}
	

	@RequestMapping(value="/viewFaculty", method = RequestMethod.POST)
	public String viewFaculty(Model model,String dept) {
		
		Department department = departmentRepository.findByDeptId(dept);
		ArrayList<FacultyUsers> facUsersList= facAcadService.getFacultyList(department);
		
		model.addAttribute("facultyUsersList",facUsersList);
		return "admin/viewUsers:: facultyTable";
	
	}
		
	@Transactional
	@RequestMapping(value = "/changeSeatsAndAllocate", method = RequestMethod.POST)
	public ModelAndView changeSeatsAndAllocate(String courseIdList, String seatList) {
		String electiveIds[] = courseIdList.split(",");
		String seats[] = seatList.split(",");
		String courseId = "";
		for(int i=0;i<electiveIds.length;i++) {
			ElectiveVacancyPrefCounts ec = electiveVacancyPrefCountsRepository.findByElectiveId(electiveIds[i]);
			ec.setVacancyCount(Integer.parseInt(seats[i]));
			electiveVacancyPrefCountsRepository.save(ec);
			courseId = ec.getCourseId();
		}
		set_process_student_allocation(courseId);
		return getStudPrefDetailsTable();
	}
	
	//Display register user form
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUsers(String msg, String err_msg) {
		ModelAndView model = new ModelAndView();
		Users user = new Users();
		roles = roleRepository.findAll();
		departments = departmentRepository.findAll();
		model.addObject("user",user);
		model.addObject("student",new StudentAcad());
		model.addObject("roles",roles);
		model.addObject("department", departments);
		model.setViewName("admin/registerUsers");
		
		if(msg == null && err_msg!=null) {
			model.addObject("errmsg",err_msg);
		}
		else if(msg !=null && err_msg==null) {
			model.addObject("msg",msg);
		}
		return model;
	}
	
	//Handle register user form
	@RequestMapping(value = "/register_users", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid Users user, String role, StudentAcad student,String dept,
			String dept1, Integer facExp, String facDesignation, String facQualification
			) {
		ModelAndView model = new ModelAndView();	
		Role userRole = roleRepository.findByRole(role);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		System.out.println(role);
		//check unique email
		String email = user.getEmail();
		if(!userDetails.isUniqueEmail(email)) {
			String errmsg = "A user is already registered with the given email";
			return registerUsers(null,errmsg);
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
			Department department = departmentRepository.findByDeptId(dept1);
			
			faculty.setDepartment(department);
			faculty.setDesignation(facDesignation);
			faculty.setQualification(facQualification);
			faculty.setYearsOfExperience(facExp);
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
	public ModelAndView addCourse(@Valid Course course, String dept,String companionTheory,String prerequisiteNo1,String prerequisiteNo2) {
		ModelAndView model = new ModelAndView();
		
		Department deptObj = departmentRepository.findByDeptName(dept);
		course.setDepartment(deptObj);
		course.setStudAllocFlag(0);
		
		System.out.println(companionTheory);
		System.out.println(prerequisiteNo1+" "+prerequisiteNo2);
		
		if(companionTheory.equals("") && prerequisiteNo1.equals("") && prerequisiteNo2.equals("")) {
			model.addObject("msg","Course has been added successfully");
			model.addObject("course",new Course());
			courseRepository.save(course);
		}
		
		else if(!companionTheory.equals("")) {
			Optional<Course> thCourse = courseRepository.findByCourseIdAndDepartmentAndCourseYearAndCourseSemAndIsTheory(companionTheory,course.getDepartment(),course.getCourseYear(),course.getCourseSem(),1);
			
			if(thCourse.isPresent()) {
				//saving course
				model.addObject("msg","Course has been added successfully");
				model.addObject("course",new Course());
				courseRepository.save(course);
				
				CompanionCourse cc = new CompanionCourse(thCourse.get().getCourseId(), course.getCourseId());
				courseCompanionRepository.save(cc);
				
				CompanionCourse ncc = new CompanionCourse(course.getCourseId(), thCourse.get().getCourseId());
				courseCompanionRepository.save(ncc);
				
				
			}
			else {
				model.addObject("err_msg","Companion theory course doesn't exist!");
				model.addObject("course",new Course());
			}
		}else if(!prerequisiteNo1.equals("") && !prerequisiteNo2.equals("")) {
			Optional<Course> pr1Course = courseRepository.findByCourseIdAndDepartmentAndIsTheory(prerequisiteNo1,course.getDepartment(),1);
			Optional<Course> pr2Course = courseRepository.findByCourseIdAndDepartmentAndIsTheory(prerequisiteNo2,course.getDepartment(),1);
			Electives pr1Elective = electivesRepository.findByElectiveCourseId(prerequisiteNo1);
			Electives pr2Elective = electivesRepository.findByElectiveCourseId(prerequisiteNo2);
		
			if(pr1Course.isPresent() && pr2Course.isPresent() && pr1Elective ==null && pr2Elective ==null) {
				CoursePrerequisites cr = new CoursePrerequisites(course.getCourseId(),0,0,prerequisiteNo1,prerequisiteNo2);
				courseRepository.save(course);
				coursePrerequisitesRepository.save(cr);
				model.addObject("msg","Course has been added successfully");
				model.addObject("course",new Course());
				
			} else if(!pr1Course.isPresent() && !pr2Course.isPresent() && pr1Elective !=null && pr2Elective !=null){
				CoursePrerequisites cr = new CoursePrerequisites(course.getCourseId(),1,1,prerequisiteNo1,prerequisiteNo2);
				courseRepository.save(course);
				coursePrerequisitesRepository.save(cr);
				model.addObject("msg","Course has been added successfully");
				model.addObject("course",new Course());
				
			}else if(pr1Course.isPresent() && pr2Course.isPresent() && pr1Elective !=null && pr2Elective !=null){
				model.addObject("err_msg", "Ambiguous Ids entered.");
				model.addObject("course",new Course());
				
			} else if(!pr1Course.isPresent() && !pr2Course.isPresent() && pr1Elective ==null && pr2Elective ==null){
				model.addObject("err_msg","Prerequisite 1 and 2 theory courses don't exist!");
				model.addObject("course",new Course());	
				
			}else if(!pr1Course.isPresent() && pr1Elective==null){
				model.addObject("err_msg","Prerequisite 1 theory course doesn't exist!");
				model.addObject("course",new Course());	
				
			}else if(!pr2Course.isPresent() && pr2Elective==null){
				model.addObject("err_msg","Prerequisite 2 theory course doesn't exist!");
				model.addObject("course",new Course());
				
			}
		}else {
			model.addObject("err_msg","Cannot add course, something went wrong!");
			model.addObject("course",new Course());
		}
		
		
		model.addObject("departments",departments);
		model.setViewName("admin/addCourses");
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
	public ModelAndView set_all_elective(String suffix, Electives elective,String courseId, String companionTheory,String prerequisiteNo1,String prerequisiteNo2) {
		
		ModelAndView model = new ModelAndView();
		System.out.println("checkL-"+courseId);
		System.out.println(companionTheory);
		System.out.println(prerequisiteNo1);
		System.out.println(prerequisiteNo2);
		elective.setElectiveCourseId(courseId.concat(suffix));
		Course course = courseRepository.findByCourseId(courseId);
		elective.setCourse(course);
		
		if(electivesRepository.findByElectiveName(elective.getElectiveName()).isPresent()) {
			System.out.println("Elective with same name already exists");
			model.addObject("msg","Elective with same name already exists");
		}
		else {
			
			if(!companionTheory.equals("")) {
				Optional<Course> thCourse = courseRepository.findByCourseIdAndDepartmentAndCourseYearAndCourseSemAndIsTheory(companionTheory,course.getDepartment(),course.getCourseYear(),course.getCourseSem(),1);
				Electives compElective = electivesRepository.findByElectiveCourseId(companionTheory);
				
				if(thCourse.isPresent() && compElective==null) {
					electivesRepository.save(elective);
					CompanionCourse cc = new CompanionCourse(thCourse.get().getCourseId(), elective.getElectiveCourseId());
					courseCompanionRepository.save(cc);
					
					CompanionCourse ncc = new CompanionCourse(elective.getElectiveCourseId(), thCourse.get().getCourseId());
					courseCompanionRepository.save(ncc);	
					
					model.addObject("msg","Elective has been added successfully");

				}
				else if(!thCourse.isPresent() && compElective!=null) {
					electivesRepository.save(elective);
					CompanionCourse cc = new CompanionCourse(compElective.getElectiveCourseId(), elective.getElectiveCourseId());
					courseCompanionRepository.save(cc);
					
					CompanionCourse ncc = new CompanionCourse(elective.getElectiveCourseId(), compElective.getElectiveCourseId());
					courseCompanionRepository.save(ncc);
					model.addObject("msg","Elective has been added successfully");
				}
				else {
					model.addObject("err_msg","Companion theory course doesn't exist!");
					model.addObject("course",new Course());
				}
			}else if(!prerequisiteNo1.equals("") && !prerequisiteNo2.equals("")) {
				Optional<Course> pr1Course = courseRepository.findByCourseIdAndDepartmentAndIsTheory(prerequisiteNo1,course.getDepartment(),1);
				Optional<Course> pr2Course = courseRepository.findByCourseIdAndDepartmentAndIsTheory(prerequisiteNo2,course.getDepartment(),1);
				Electives pr1Elective = electivesRepository.findByElectiveCourseId(prerequisiteNo1);
				Electives pr2Elective = electivesRepository.findByElectiveCourseId(prerequisiteNo2);
			
				if(pr1Course.isPresent() && pr2Course.isPresent() && pr1Elective ==null && pr2Elective ==null) {
					electivesRepository.save(elective);
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(),0,0,prerequisiteNo1,prerequisiteNo2);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg","Elective has been added successfully");
					
				} else if(!pr1Course.isPresent() && !pr2Course.isPresent() && pr1Elective !=null && pr2Elective !=null){
					electivesRepository.save(elective);
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(),1,1,prerequisiteNo1,prerequisiteNo2);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg","Elective has been added successfully");
					
				}else if(pr1Course.isPresent() && pr2Course.isPresent() && pr1Elective !=null && pr2Elective !=null){
					model.addObject("err_msg", "Ambiguous Ids entered.");
					
				} else if(!pr1Course.isPresent() && !pr2Course.isPresent() && pr1Elective ==null && pr2Elective ==null){
					model.addObject("err_msg","Prerequisite 1 and 2 theory courses don't exist!");
					
				}else if(!pr1Course.isPresent() && pr1Elective==null){
					model.addObject("err_msg","Prerequisite 1 theory course doesn't exist!");
					
				}else if(!pr2Course.isPresent() && pr2Elective==null){
					model.addObject("err_msg","Prerequisite 2 theory course doesn't exist!");
					
				}
			}else {
				model.addObject("err_msg","Cannot add course, something went wrong!");
			}
			//model.addObject("msg","Elective added successfully");		
		}
		
		
		ArrayList<Course> electivesList = courseRepository.findByCourseTypeNot('R');
		
		model.addObject("electivesList",electivesList);
		model.addObject("elective",new Electives());
		
		model.setViewName("/admin/addElective");
		return model;
		
	}
		
	//Get studCourseAllocation HTML page for opening course allocation forms
	@RequestMapping(value="/openCourseAllocation",method=RequestMethod.GET)
	public ModelAndView openCourseAllocation(ArrayList<Course> elective_ids,String err_msg) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.setViewName("/admin/studCourseAllocation");
		model.addObject("course",new Course());
		
		if(!elective_ids.isEmpty())
			model.addObject("elective_ids",elective_ids);
		
		if(err_msg!=null)
			model.addObject("err_msg",err_msg);
		
		return model;
	}
	
	
	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES	
	//Retrieve all electives for specified dept, year and sem 
	@RequestMapping(value="/findElective",method=RequestMethod.POST)
	public ModelAndView findElective(@Valid Course course, String dept) {
	
		Department department = departmentRepository.findByDeptId(dept);
		
		System.out.println(course.getCourseSem()+" "+course.getCourseYear());
		System.out.println(department.getDeptId());
		
		ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,0);

		if(elective_ids.size()==0) {
			String msg = "Student elective preference forms have already been released for the specified department, year and semester.";
			return openCourseAllocation(elective_ids,msg);
		}
		
		return openCourseAllocation(elective_ids,null);	
	}
	

	//open course allocation forms for specified electives, (set studAllocFlag = 1)
	@RequestMapping(value="/open_student_allocation",method=RequestMethod.POST)
	public ModelAndView open_student_allocation(String electiveIdOption) {
		
		ModelAndView model = new ModelAndView();
		
		Course startCourse = courseRepository.findByCourseId(electiveIdOption);				
				
		if(startCourse== null)
			model.addObject("err_msg","Specified elective does not exist for the given Year and Semester");
		else {
			ArrayList<Electives> all_electives = electivesRepository.findByCourse(startCourse);
			if(all_electives.size()!=0) {
				for (Electives electives : all_electives) {
					ElectiveVacancyPrefCounts electiveVacancyPrefCounts = new ElectiveVacancyPrefCounts();
					System.out.println(startCourse.getCourseId());
					electiveVacancyPrefCounts.setCourseId(startCourse.getCourseId());
					electiveVacancyPrefCounts.setPrefCount(0);
					electiveVacancyPrefCounts.setVacancyCount(2);	//total seats available for an elective course
					electiveVacancyPrefCounts.setElectiveId(electives.getElectiveCourseId());
					electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);
					
					startCourse.setStudAllocFlag(1);
					courseRepository.save(startCourse);	
					
					model.addObject("msg","Student preference forms are released for: "
							+startCourse.getCourseYear()+" Semester: "+startCourse.getCourseSem()
							+" "+startCourse.getCourseName());
				}
			}else {
				model.addObject("err_msg","No electives found for the Course Id: ".concat(electiveIdOption));
			}
							
			}
		ArrayList<Department> departments = departmentRepository.findAll();

		model.addObject("departments",departments);		
		model.addObject("course",new Course());
		model.setViewName("/admin/studCourseAllocation");		
		return model;
	}	
		
	//@RequestMapping(value="/process_student_allocation_post",method=RequestMethod.POST)
	@Transactional	
	private void set_process_student_allocation(String electiveIdOption) {

		//check whether course is open for preferences or not
		Course course = courseRepository.findByCourseId(electiveIdOption);
		System.out.println(course.getCourseId()+" "+course.getStudAllocFlag());
		if(course.getStudAllocFlag()==2) {
		ArrayList<Electives> all_electives = electivesRepository.findByCourse(course);
		
		if(all_electives.size()!=0) {
			
			int alloc = allocation_of_students_to_elective_course(course.getCourseId(),course.getCourseYear(),course.getCourseSem()); 
			if (alloc==1) {
				 g_msg = "The allocation has been completed for Course-Id: "+course.getCourseId();
				 g_err_msg = null;
			}
			else if(alloc==0) {
				g_err_msg = "No preferences are recorded!";
				g_msg = null;
			}
			else if(alloc==-1) {
				g_err_msg = "Allocation has already been performed for Course-id: "+electiveIdOption;
				g_msg = null;
			}
			else if(alloc==-2) {
				g_err_msg = "Number of total seats is less than number of students.";
				g_msg = null;
			}
				
		}else {
			g_err_msg = "No electives found for the course Id: ".concat(electiveIdOption);
			g_msg = null;
		}
		}else {
			g_err_msg = "Preference forms should be closed before performing allocation.";
			g_msg = null;
		}
	//	return process_student_allocation(null,g_msg,g_err_msg);
	}
	
	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES	
	private int allocation_of_students_to_elective_course(String course_id,String year,int semester) {
		
		ArrayList<StudentPref> studentPrefs = studentPrefRepository.findByCourseIdEquals(course_id);

		Course ElCourse = courseRepository.findByCourseId(course_id);
		ArrayList<StudentAllocCourse> studentAllocs = studentAllocCourseRepository.findByCourseId(ElCourse);
		
		
		
		if(studentAllocs.size()!=0) {
			studentAllocCourseRepository.deleteByCourseId(ElCourse);
		}
			if(studentPrefs.size()!=0) {
				
				ArrayList<StudentAcad> studentAcads = studentAcadRepository.findBySemEqualsAndYearEqualsAndDepartmentEquals(semester,year,ElCourse.getDepartment());

				Collections.sort(studentAcads);
				
				
				//Store all vacancy counts for all courses
				
				ArrayList <ElectiveVacancyPrefCounts> allElectiveCounts = electiveVacancyPrefCountsRepository.findByCourseId(course_id);
				

				HashMap<String,Integer> eVHM = new HashMap<String,Integer>();
				
				for (ElectiveVacancyPrefCounts e : allElectiveCounts) {
					eVHM.put(e.getElectiveId(), e.getVacancyCount());							
				}
				
				ArrayList<Electives> popularElectives = calculatePrefCounts(course_id,year,semester,allElectiveCounts);
				
				
				HashMap<StudentAcad,StudentAllocCourse> studAllocs = new HashMap<StudentAcad,StudentAllocCourse>();
				
				//for each student in reverse 				
				for (StudentAcad studentAcad : studentAcads) {
					ArrayList<StudentPref> stud = studentPrefRepository.findByUserNameAndCourseId(studentAcad.getUserName(),course_id);
					
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
							int vCount = eVHM.get(pref.getElectiveCourseId());
							if (vCount>0) {
								eVHM.replace(pref.getElectiveCourseId(), vCount-1);
								StudentAllocCourse s = new StudentAllocCourse(pref, pref.getCourse(), studentAcad, prefNo);
								studAllocs.put(studentAcad, s);
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
								int vCount = eVHM.get(e.getElectiveCourseId());
								if (vCount>0) {
									eVHM.replace(e.getElectiveCourseId(), vCount-1);
									StudentAllocCourse s = new StudentAllocCourse(e,e.getCourse(),studentAcad,-1);
									studAllocs.put(studentAcad, s);
									flag = 1;
									break;
								}
							}
							if(flag==0) {
								System.out.println("NO OPTION LEFT!!!! NEED TO INCREASE CAPACITY!!!");
								return -2;
							}
						}
						
					}else {
						//assign popular course
						System.out.println("Hasn't given preference");
						System.out.println("Assigning course according to popularity!");
						int flag=0;
						for (Electives e : popularElectives) {
							int vCount = eVHM.get(e.getElectiveCourseId());
							if (vCount>0) {
								eVHM.replace(e.getElectiveCourseId(), vCount-1);
								StudentAllocCourse s = new StudentAllocCourse(e,e.getCourse(),studentAcad,-1);
								studAllocs.put(studentAcad, s);
								flag = 1;
								break;
							}
						}
						if(flag==0) {
							System.out.println("NO OPTION LEFT!!!! NEED TO INCREASE CAPACITY!!!");
							return -2;
						}

					}
					
				}
				for (StudentAcad s : studAllocs.keySet()) {
					studentAllocCourseRepository.save(studAllocs.get(s));
				}
				
				return 1;
			}else {
				return 0;
			}

		
	}

	private ArrayList<Electives> calculatePrefCounts(String course_id,String year,int semester,ArrayList <ElectiveVacancyPrefCounts> electiveVacancyPrefCounts){

		Collections.sort(electiveVacancyPrefCounts);
		
		ArrayList<Electives> electivesList = new ArrayList<>();
				
		for (ElectiveVacancyPrefCounts e : electiveVacancyPrefCounts) {
				electivesList.add(electivesRepository.findByElectiveCourseId(e.getElectiveId()));
		}
		return electivesList;
	}
	

	@Transactional
	private void clear_preferences(String electiveIdOption) {
		
		int status = courseRepository.findByCourseId(electiveIdOption).getStudAllocFlag();
		if(status!=2) {
			g_msg = null;
			if(status == 1)
				g_err_msg = "Cannot clear preferences for open forms. Close forms before clearing preferences";
			else
				g_err_msg = "Preferences have already been cleared";
			
		}
		else {
			System.out.println(electiveIdOption);
			studentPrefRepository.deleteByCourseId(electiveIdOption);
			
			Course c = courseRepository.findByCourseId(electiveIdOption);
			c.setStudAllocFlag(0);
			courseRepository.save(c);
			
			g_msg = "Cleared preferences for Course Id: "+electiveIdOption;
			g_err_msg = null;
			
		}
	}	
	
	//showing allocations - getShowAllocations
	@RequestMapping(value="/getShowAllocations",method=RequestMethod.GET)
	public ModelAndView getShowAllocations(ArrayList<Course> elective_ids,String msg,String err_msg) 
	{
		ModelAndView model = new ModelAndView();
		
		ArrayList<Department> departments = departmentRepository.findAll();
		
		model.addObject("course", new Course());
		model.addObject("departments", departments);
		model.setViewName("/admin/showAllocations");
		if(elective_ids.size()!=0)
			model.addObject("elective_ids",elective_ids);
		if(msg!=null)
			model.addObject("msg", msg);
		if(err_msg!=null)
			model.addObject("err_msg",err_msg);
		return model;
	}
	
	//findElectivesToShow
	@RequestMapping(value="/findElectivesToShow",method=RequestMethod.POST)
	public ModelAndView findElectivesToShow(@Valid Course course,String dept) {
	
		Department department = departmentRepository.findByDeptId(dept);
		
		System.out.println(course.getCourseSem()+" "+course.getCourseYear());
		System.out.println(department.getDeptId());
		
		ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,2);
		
		if(elective_ids.size()==0) {
			String err_msg = "No electives are opened for preference forms.";
			return getShowAllocations(elective_ids,null,err_msg);
		}
		return getShowAllocations(elective_ids, null,null);
		
	}
	
	//showAllocations
	@RequestMapping(value="/showAllocations",method=RequestMethod.POST)	
	public ModelAndView showAllocations(String electiveIdOption) {
		ModelAndView model = new ModelAndView();

		ArrayList<Department> departments = departmentRepository.findAll();
		
		model.addObject("course", new Course());
		model.addObject("departments", departments);
		model.setViewName("/admin/showAllocations");
		
		Course c = courseRepository.findByCourseId(electiveIdOption);
		ArrayList<StudentAllocCourse> studAllocations = studentAllocCourseRepository.findByCourseId(c);
		if(studAllocations.size()!=0)
			model.addObject("studAllocations", studAllocations);
		else
			model.addObject("err_msg", "No allocations done yet for Course Id: "+electiveIdOption);
		return model;
	}
	
	//delete course or elective
	@Transactional
	@RequestMapping(value="/delete-course-elective",method=RequestMethod.GET)
	public ModelAndView getDelCourseOrElective(String msg,String err_msg) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/deleteCourseOrElective");
		if(msg!=null)
			model.addObject("msg",msg);
		else if(err_msg!=null)
			model.addObject("err_msg",err_msg);
		return model;
	}
	
	@Transactional
	@RequestMapping(value="/delete-course-elective",method=RequestMethod.POST)
	public ModelAndView setDelCourseOrElective(String c_id,String e_id) {
		String msg = null;
		String err_msg = null;
		if(!c_id.equals("")) {
			System.out.println("course");
			Course c = courseRepository.findByCourseId(c_id);
			CoursePrerequisites cprereq = coursePrerequisitesRepository.findByCourseId(c_id);
			ArrayList<StudentPref> cstudPref = studentPrefRepository.findByCourseIdEquals(c_id);
			if(c!=null) {
				courseRepository.delete(c);
				
				if(cprereq!=null)
				{
					coursePrerequisitesRepository.deleteByCourseId(c_id);
					//msg.concat("Corresponding prerequisites mapping are deleted.\n");
				}
				if(cstudPref.size()!=0)
				{
					studentPrefRepository.deleteByCourseId(c_id);
					//msg.concat("Corresponding prerequisites mapping are deleted.\n");
				}
				msg = "Course has been deleted successfully.";
			}else {
				err_msg = "Specified Course does not exist. Please check again.";
			}
		}else if(!e_id.equals("")) {
			System.out.println("elective");
			Electives e = electivesRepository.findByElectiveCourseId(e_id);
			
			ArrayList<StudentPref> estudPref = studentPrefRepository.findByElective(e);
			
			if(e!=null) {
				if(e.getCourse().getStudAllocFlag()!=0) {
					err_msg = "Cannot delete the elective as its status is Open or Closed.";
					
				}else {
					
					electivesRepository.delete(e);
					if(estudPref.size()!=0) {
						studentPrefRepository.deleteByCourseId(e_id);
						//msg.concat("Corresponding prerequisites mapping are deleted.\n");
					}
					msg = "Elective has been deleted successfully.";
				}
				
			}else {
				err_msg = "Specified Elective does not exist. Please check again.";
			}
		}else if(c_id.equals("") && e_id.equals("")) {
			System.out.println("error");
			err_msg = "Something went wrong.";
		}
		
		return getDelCourseOrElective(msg,err_msg);
	}


//	@RequestMapping(value="/allocFaculty",method=RequestMethod.POST)
//	public ModelAndView
	
	public void allocFaculty(int oddOrEven) {
		
		//find all the courses
		
		HashMap<String, int[]> desigHours =  new HashMap<>();
		
		List<FacultyAcad> allFacs = facultyAcadRepository.findAll();
		
		HashMap <String,Integer> facAllotedHours = new HashMap<>();
		HashMap <String,int[]> facLimits = new HashMap<>();
		for(FacultyAcad f:allFacs) {
			facAllotedHours.put(f.getUserName(), 0);
			facLimits.put(f.getUserName(), desigHours.get(f.getDesignation()));
		}
		
		ArrayList<FacultyAllocCourse> alloc = new ArrayList<>();
		
		ArrayList<CombinedCourseElective> courses = new ArrayList<>();
		
		if(oddOrEven==0) {
			ArrayList<Course> allOddCourses = courseRepository.findOddSemCoursesAndCourseTypeReg();
			ArrayList<Electives> allOddElectives = electivesRepository.findOddSemCoursesAndCourseTypeNotReg();
			for(Course c:allOddCourses)
			{
				CombinedCourseElective co = new CombinedCourseElective(c.getCourseId(),0,c.getNoOfHours(),c.getCourseYear());
				courses.add(co);
			}
			for(Electives e:allOddElectives)
			{
				CombinedCourseElective ce = new CombinedCourseElective(e.getElectiveCourseId(),1,e.getCourse().getNoOfHours(),e.getCourse().getCourseYear());
				courses.add(ce);
			}
		}else if(oddOrEven==1){
			ArrayList<Course> allEvenCourses = courseRepository.findEvenSemCoursesAndCourseTypeReg();
			ArrayList<Electives> allEvenElectives = electivesRepository.findEvenSemCoursesAndCourseTypeNotReg();
			for(Course c:allEvenCourses)
				{
					CombinedCourseElective co = new CombinedCourseElective(c.getCourseId(),0,c.getNoOfHours(),c.getCourseYear());
					courses.add(co);
				}
			for(Electives e:allEvenElectives)
			{
				CombinedCourseElective ce = new CombinedCourseElective(e.getElectiveCourseId(),1,e.getCourse().getNoOfHours(),e.getCourse().getCourseYear());
				courses.add(ce);
			}
		}else {
			ArrayList<Course> allEvenAndOddCourses = courseRepository.findByCourseType('R');
			List<Electives> allElectives = electivesRepository.findAll();
			for(Course c:allEvenAndOddCourses)
			{
				CombinedCourseElective co = new CombinedCourseElective(c.getCourseId(),0,c.getNoOfHours(),c.getCourseYear());
				courses.add(co);
			}
			for(Electives e:allElectives)
			{
				CombinedCourseElective ce = new CombinedCourseElective(e.getElectiveCourseId(),1,e.getCourse().getNoOfHours(),e.getCourse().getCourseYear());
				courses.add(ce);
			}
		}
		
		for(CombinedCourseElective c:courses) {
			System.out.println(c.getId());
		}
		
		//sort by BE,TE,SE,FE
		
		ArrayList<CombinedCourseElective> sortedCourses = new ArrayList<>();
		
		for(CombinedCourseElective c:courses) {
			if(c.getYear()=="BE") {
				sortedCourses.add(c);
			}
		}
		for(CombinedCourseElective c:courses) {
			if(c.getYear()=="TE") {
				sortedCourses.add(c);
			}
		}
		for(CombinedCourseElective c:courses) {
			if(c.getYear()=="SE") {
				sortedCourses.add(c);
			}
		}
		for(CombinedCourseElective c:courses) {
			if(c.getYear()=="FE") {
				sortedCourses.add(c);
			}
		}
		
		//iterate over all the courses
		
		for(CombinedCourseElective c:sortedCourses) {
			
			ArrayList<FacultyPref> fpref=new ArrayList<>();
			
			if(c.getIsElective()==1) {
				fpref = facultyPrefRepository.findByElectiveId(c.getId());
			}else {
				fpref = facultyPrefRepository.findByCourseId(c.getId());
			}
			
			Collections.sort(fpref,new FacultyPrefChainedComparator(new FacultyPrefNoComparator(),new FacultyPrefPrereqExp1Comparator(),new FacultyPrefPrereqExp2Comparator()));
			
			for (FacultyPref fp : fpref) {
				
				int currPrefCurrentHours = facAllotedHours.get(fp.getUserName());
				
				if(currPrefCurrentHours + c.getNoOfHours() <= facLimits.get(fp.getUserName())[1])
				{
					facAllotedHours.replace(fp.getUserName(), currPrefCurrentHours+c.getNoOfHours());
					//add to the result array
					
					FacultyAllocCourse f = new FacultyAllocCourse();
					f.setCourseId(c.getId());
					f.setIsElective(c.getIsElective());
					f.setNoOfHours(c.getNoOfHours());
					f.setPrefNo(fp.getPrefNo());
					f.setUserName(fp.getUserName());
					f.setYear(c.getYear());
					
					alloc.add(f);
					break;
				}
			
			} 
			
//			facultyPrefRepository.findById(fpref.)
//			
//
//			int i = 1;
//			
//			int pno = 1;
//			
//			ArrayList<FacultyPref> samePref = new ArrayList<>();
//			
//			while(i!=fpref.size() && pno==fpref.get(i).getPrefNo()) {
//				
//				samePref.add(fpref.get(i));
//				i+=1;
//				
//				if(i!=fpref.size() && pno!=fpref.get(i).getPrefNo()) {
//					
//					
//					if(samePref.size()==1) {
//						
//						//String userName, int prefNo, String courseId, int noOfHours, int isElective,String year
//						
//						FacultyPref currPref = samePref.get(0);
//						FacultyAllocCourse f = new FacultyAllocCourse();
//						f.setCourseId(c.getId());
//						f.setIsElective(c.getIsElective());
//						f.setNoOfHours(c.getNoOfHours());
//						f.setPrefNo(currPref.getPrefNo());
//						f.setUserName(currPref.getUserName());
//						f.setYear(c.getYear());
//						
//						int currPrefCurrentHours = facAllotedHours.get(currPref.getUserName());
//						
//						if(currPrefCurrentHours + c.getNoOfHours() <= facLimits.get(currPref.getUserName())[1])
//						{
//							facAllotedHours.replace(currPref.getUserName(), currPrefCurrentHours+c.getNoOfHours());
//							//add to the result array
//							alloc.add(f);
//						}
//						
//						
//					}else {
//						//compare exp
//						
//					}
//					
//					samePref = new ArrayList<>();
//					pno+=1;
//				}
//			}
//			
			
			
		}

			
	}
}
