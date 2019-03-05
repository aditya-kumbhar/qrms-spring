package com.qrms.spring.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
import com.qrms.spring.queryBeans.PrefGroupByCourseStudent;
import com.qrms.spring.queryBeans.StudentCountByYearSem;
import com.qrms.spring.queryBeans.StudentPrefCountInfo;
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
	
	private String g_msg,g_err_msg;
	
	@GetMapping("/home")
	public ModelAndView adminHome() {
		
		return getViewAdminHome(null);
	}
	
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
	
	@GetMapping("/getStudPrefDetailsTable")
	public ModelAndView getStudPrefDetailsTable() {
		
		List<StudentCountByYearSem> totalStudentCount;
		List<PrefGroupByCourseStudent> prefsPerElective;
		List<StudentPrefCountInfo> studCountInfo = new ArrayList<StudentPrefCountInfo>();
	
		totalStudentCount = studentAcadRepository.findStudentCountByYearSemDept();
		prefsPerElective = studentPrefRepository.findPrefsGroupByCourseStudent();
		Course c;
		
		List<Course> openCourses = courseRepository.findByStudAllocFlag(1);
		
		for(PrefGroupByCourseStudent p: prefsPerElective) {
			c = courseRepository.findByCourseId(p.getCourseId());
			
			for(StudentCountByYearSem s: totalStudentCount) {
			
				if(s.getSem() == c.getCourseSem() && s.getYear().equals(c.getCourseYear())) {
					StudentPrefCountInfo si = new StudentPrefCountInfo();
					si.setCourseId(c.getCourseId());
					si.setCourseName(c.getCourseName());
					si.setDeptId(c.getDepartment().getDeptId());
					si.setSem(c.getCourseSem());
					si.setSubmitCount(p.getCount());
					si.setTotalStudentCount(s.getCount());
					si.setYear(c.getCourseYear());
					studCountInfo.add(si);
					openCourses.remove(c);
					break;
				}
			}
		}
		
		for(Course openCourse: openCourses) {
			StudentPrefCountInfo si = new StudentPrefCountInfo();
			si.setCourseId(openCourse.getCourseId());
			si.setCourseName(openCourse.getCourseName());
			si.setDeptId(openCourse.getDepartment().getDeptId());
			si.setSem(openCourse.getCourseSem());
			si.setSubmitCount(0);
			for(StudentCountByYearSem s: totalStudentCount) {
				if(s.getSem() == openCourse.getCourseSem() && s.getYear().equals(openCourse.getCourseYear())) {
					si.setTotalStudentCount(s.getCount());
					break;
				}
			}
			si.setYear(openCourse.getCourseYear());
			studCountInfo.add(si);
			
		}
		return getViewAdminHome(studCountInfo);		
	}
	
	//Display register user form
	@Transactional
	@RequestMapping(value = "/performQuickAction-student", method = RequestMethod.POST)
	public ModelAndView studentAllocQuickAction(String courseId, String courseSem, String deptId, String coureYear, String selectAction) {
		System.out.println(courseId);
		System.out.println(selectAction);
		String courses[] = courseId.split(",");
		String actions[] = selectAction.split(",");
		int i=0;
		for(i=0; i<actions.length;i++) {
			if(!actions[i].equals("none")) {
				break;
			}
		}
		ModelAndView mv = new ModelAndView(),model = null;
		
		if(actions[i].equals("performAllocation")) {
			set_process_student_allocation(courses[i]);
			
			
		} else if(actions[i].equals("clearPrefs")) {
			clear_preferences(courses[i]);			
			
		} else {
			//action = close pref forms
			Course course = courseRepository.findByCourseId(courses[i]);				
			course.setStudAllocFlag(0);
			courseRepository.save(course);
			g_msg = "Preference forms for Course-id: "+courses[i]+" have been closed";
			g_err_msg = null;
		}
		
		return getStudPrefDetailsTable();
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
	public ModelAndView addCourse(@Valid Course course, String dept) {
		ModelAndView model = new ModelAndView();
		
		Department deptObj = departmentRepository.findByDeptName(dept);
		course.setDepartment(deptObj);
		course.setStudAllocFlag(0);
		
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
	public ModelAndView set_all_elective(String suffix, Electives elective,String courseId) {
		
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
			model.addObject("msg","Elective added successfully");
		
		}
		electivesRepository.save(elective);
		
		ArrayList<Course> electivesList = courseRepository.findByCourseTypeNot('R');
		
		model.addObject("electivesList",electivesList);
		model.addObject("elective",elective);
		
		model.setViewName("/admin/addElective");
		return model;
		
	}
	
	//Get studStartAllocation HTML page
	@RequestMapping(value="/process_student_allocation",method=RequestMethod.GET)
	public ModelAndView process_student_allocation(ArrayList<Course> elective_ids,String msg,String err_msg) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.setViewName("/admin/studStartAllocation");
		model.addObject("course",new Course());
		
		if(elective_ids!=null && !elective_ids.isEmpty())
			model.addObject("elective_ids",elective_ids);
		
		if(msg!=null && !msg.equals(""))
			model.addObject("msg",msg);
		else if(err_msg!=null && !err_msg.equals(""))
			model.addObject("err_msg",err_msg);
		
		return model;
	}

	//Retrieve all electives for specified dept, year and sem 
	@RequestMapping(value="/findElectiveForStartAllocation",method=RequestMethod.POST)
	public ModelAndView findElectiveForStartAllocation(@Valid Course course, String dept) {
	
		Department department = departmentRepository.findByDeptId(dept);
		
		System.out.println(course.getCourseSem()+" "+course.getCourseYear());
		System.out.println(department.getDeptId());
		
		ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,1);

		return process_student_allocation(elective_ids,"","");
	
	}

	@RequestMapping(value="/process_student_allocation_post",method=RequestMethod.POST)
	public ModelAndView set_process_student_allocation(String electiveIdOption) {

		//check whether course is open for preferences or not
		Course course = courseRepository.findByCourseId(electiveIdOption);
		
		
		ArrayList<Electives> all_electives = electivesRepository.findByCourse(course);
		
		if(all_electives.size()!=0) {
			
			int alloc = allocation_of_students_to_elective_course(course.getCourseId(),course.getCourseYear(),course.getCourseSem()); 
			if (alloc==1) {
				 g_msg = "The allocation has been completed!";
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
				
		}else {
			g_err_msg = "No electives found for the course Id: ".concat(electiveIdOption);
			g_msg = null;
		}
		
		return process_student_allocation(null,g_msg,g_err_msg);
	}	
	
	//Get studCourseAllocation HTML page
	@RequestMapping(value="/openCourseAllocation",method=RequestMethod.GET)
	public ModelAndView openCourseAllocation(ArrayList<Course> elective_ids,String msg) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.setViewName("/admin/studCourseAllocation");
		model.addObject("course",new Course());
		
		if(!elective_ids.isEmpty())
			model.addObject("elective_ids",elective_ids);
		
		if(msg!=null)
			model.addObject("msg",msg);
		
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
					
					model.addObject("msg","Student course allocation process started for : "
							+startCourse.getCourseYear()+" Semester: "+startCourse.getCourseSem()
							+" "+startCourse.getCourseName());
				}
				}else {
					model.addObject("err_msg","No electives found for the Course Id: ".concat(electiveIdOption));
				}
							
			}
		
		model.addObject("course",new Course());
		model.setViewName("/admin/studCourseAllocation");		
		return model;
	}	
	
	
	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES
	
	private int allocation_of_students_to_elective_course(String course_id,String year,int semester) {
		
		ArrayList<Electives> popularElectives = calculatePrefCounts(course_id,year,semester);
		ArrayList<StudentPref> studentPrefs = studentPrefRepository.findByCourseIdEquals(course_id);
		ArrayList<StudentAllocCourse> studentAllocs = studentAllocCourseRepository.findByCourseId(courseRepository.findByCourseId(course_id));
		
		Course ElCourse = courseRepository.findByCourseId(course_id);
		
		if(studentAllocs.size()==0) {
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
				
				ArrayList<StudentAcad> studentAcads = studentAcadRepository.findBySemEqualsAndYearEqualsAndDepartmentEquals(semester,year,ElCourse.getDepartment());

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
								e.setVacancyCount(e.getVacancyCount()-1);
//								StudentAllocCourse s = new StudentAllocCourse(elective_id,pref,studentAcad.getUserName(),prefNo);
								StudentAllocCourse s = new StudentAllocCourse(pref, pref.getCourse(), studentAcad, prefNo);
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
									eC.setVacancyCount(eC.getVacancyCount()-1);
									StudentAllocCourse s = new StudentAllocCourse(e,e.getCourse(),studentAcad,-1);
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
								eC.setVacancyCount(eC.getVacancyCount()-1);
								StudentAllocCourse s = new StudentAllocCourse(e,e.getCourse(),studentAcad,-1);
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
				return 1;
			}else {
				return 0;
			}
		}
		else {
			return -1;
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
	@RequestMapping(value="/clearPreferences",method=RequestMethod.GET)
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
	
	@Transactional
	@RequestMapping(value="/clear_preferences",method=RequestMethod.POST)
	public ModelAndView clear_preferences(String electiveIdOption) {
		
		ModelAndView model = new ModelAndView();
		System.out.println(electiveIdOption);
		studentPrefRepository.deleteByCourseId(electiveIdOption);
		
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.addObject("course",new Course());
		model.setViewName("/admin/clearStudPref");
		g_msg = "Cleared preferences for Course Id: "+electiveIdOption;
		g_err_msg = null;
		model.addObject("msg",g_msg);
		
		return model;
	}
	

	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES

	//change seats
	@RequestMapping(value="/getChangeSeats",method=RequestMethod.GET)
	public ModelAndView getChangeSeats(ArrayList<Course> elective_ids,ArrayList<ElectiveVacancyPrefCounts> electives,String msg,String err_msg) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.setViewName("/admin/changeTotalSeats");
		model.addObject("course",new Course());
		model.addObject("eCount",new ElectiveVacancyPrefCounts());
		if(!elective_ids.isEmpty())
			model.addObject("elective_ids",elective_ids);
		
		if(msg!=null)
			model.addObject("msg",msg);
		
		if(err_msg!=null)
			model.addObject("err_msg",err_msg);
		return model;
	}
	
	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES

	//change seats
	@RequestMapping(value="/findElectiveToChangeSeats",method=RequestMethod.POST)
	public ModelAndView findCourseToChangeSeats(@Valid Course course,ArrayList<ElectiveVacancyPrefCounts> electives, String dept,String msg1) {
	
		Department department = departmentRepository.findByDeptId(dept);
		
		System.out.println(course.getCourseSem()+" "+course.getCourseYear());
		System.out.println(department.getDeptId());
		
		ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,1);
		
		if(elective_ids.size()==0) {
			String err_msg = "No elective preference forms are opened for specified year and sem.";
			return getChangeSeats(elective_ids,electives,null,err_msg);
		}
		if(msg1!=null)
			return getChangeSeats(elective_ids,electives,msg1,null);
		return getChangeSeats(elective_ids, electives, null,null);
		
	}
	
	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES

	//change seats
	@RequestMapping(value="/findElectivesForCourse",method=RequestMethod.POST)
	public ModelAndView findElectiveForCourse(ArrayList<ElectiveVacancyPrefCounts> electives1,String electiveIdOption) {
		ArrayList<ElectiveVacancyPrefCounts> electives = electiveVacancyPrefCountsRepository.findByCourseId(electiveIdOption);
		ModelAndView model = new ModelAndView();
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.setViewName("/admin/changeTotalSeats");
		model.addObject("electives",electives);
		model.addObject("course",new Course());
		model.addObject("eCount",new ElectiveVacancyPrefCounts());

		if (electives.size()==0)
		{
			String err_msg = "No electives found for the specified course!";
			model.addObject("err_msg",err_msg);
		}
		return model;
		
	}
	
	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES

	//change seats
	@RequestMapping(value="/changeElectiveSeats",method=RequestMethod.POST)
	public ModelAndView changeElectiveSeats(ElectiveVacancyPrefCounts eCount) {
		
		ModelAndView model = new ModelAndView();
		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments",departments);
		model.setViewName("/admin/changeTotalSeats");
		model.addObject("course",new Course());
		ElectiveVacancyPrefCounts e = electiveVacancyPrefCountsRepository.findByElectiveId(eCount.getElectiveId());
		e.setVacancyCount(eCount.getVacancyCount());
		electiveVacancyPrefCountsRepository.save(e);
		model.addObject("msg","Changed Number of Seats for Elective "+e.getCourseId());
		return model;
		
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
		
		ArrayList<Course> elective_ids= courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(course.getCourseSem(),course.getCourseYear(),'R',department,1,1);
		
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
}
