package com.qrms.spring.resource;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentAllocCourse;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.TimeSlots;
import com.qrms.spring.model.TimeTable;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.FacultyUsers;
import com.qrms.spring.queryBeans.FacultyAllocations;
import com.qrms.spring.queryBeans.PrefNumCountPerElective;
import com.qrms.spring.queryBeans.StudentPrefCountInfo;
import com.qrms.spring.queryBeans.ElectiveBatchCount;
import com.qrms.spring.queryBeans.ElectiveBatchCountList;
import com.qrms.spring.queryBeans.FacPrefCountInfo;
import com.qrms.spring.queryBeans.StudentUsers;
import com.qrms.spring.model.Course;
import com.qrms.spring.model.CourseList;
import com.qrms.spring.comparators.AlphaNumericalComparator;
import com.qrms.spring.comparators.CourseListChainedComaparator;
import com.qrms.spring.comparators.CourseListYearComparator;
import com.qrms.spring.comparators.DivisionsChainedComparator;
import com.qrms.spring.comparators.DivisionsYearComparator;
import com.qrms.spring.comparators.FacultyAllocationsChainedComparator;
import com.qrms.spring.comparators.FacultyPrefChainedComparator;
import com.qrms.spring.comparators.FacultyPrefCourseExpComparator;
import com.qrms.spring.comparators.FacultyPrefNoComparator;
import com.qrms.spring.comparators.FacultyPrefPrereqExp1Comparator;
import com.qrms.spring.comparators.FacultyPrefPrereqExp2Comparator;
import com.qrms.spring.model.CompanionCourse;
import com.qrms.spring.model.CoursePrerequisites;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.DesignationToHours;
import com.qrms.spring.model.Divisions;
import com.qrms.spring.model.ElectiveBatches;
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.FacultyAllotedHours;
import com.qrms.spring.model.FacultyPref;
import com.qrms.spring.model.OpenFacultyPrefs;
import com.qrms.spring.model.PracticalList;
import com.qrms.spring.model.Resource;
import com.qrms.spring.repository.CourseCompanionRespositoy;
import com.qrms.spring.repository.CourseListRepository;
import com.qrms.spring.repository.CoursePrerequisitesRepository;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.DesignationToHoursRepository;
import com.qrms.spring.repository.DivisionsRepository;
import com.qrms.spring.repository.ElectiveBatchesRepository;
import com.qrms.spring.repository.ElectiveVacancyPrefCountsRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.FacultyAllotedHoursRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
import com.qrms.spring.repository.OpenFacultyPrefsRepository;
import com.qrms.spring.repository.PracticalListRepository;
import com.qrms.spring.repository.ResourceRepository;
import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentAllocCourseRepository;
import com.qrms.spring.repository.StudentPrefRepository;
import com.qrms.spring.repository.TimeTableRepository;
import com.qrms.spring.repository.UsersRepository;
import com.qrms.spring.service.BookingsServiceImpl;
import com.qrms.spring.service.CustomUserDetailsService;
import com.qrms.spring.service.FacPrefServiceImpl;
import com.qrms.spring.service.FacultyAcadService;
import com.qrms.spring.service.StudentAcadServiceImpl;
import com.qrms.spring.service.StudentPrefServiceImpl;

@Controller
@RequestMapping("/u/admin")
public class AdminController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private CustomUserDetailsService userDetails;

	@Autowired
	private StudentPrefServiceImpl studPrefService;

	@Autowired
	private FacPrefServiceImpl facPrefService;

	@Autowired
	private FacultyAcadService facAcadService;

	@Autowired
	private StudentAcadServiceImpl studAcadService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private OpenFacultyPrefsRepository openFacultyPrefsRepository;

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
	private FacultyAllotedHoursRepository facultyAllotedHoursRepository;

	@Autowired
	private DesignationToHoursRepository designationToHoursRepository;

	@Autowired
	private DivisionsRepository divisionsRepository;

	@Autowired
	private ElectiveBatchesRepository electiveBatchesRepository;

	@Autowired
	private TimeTableRepository timeTableRepository;

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private CourseListRepository courseListRepository;

	@Autowired
	private PracticalListRepository practicalListRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BookingsServiceImpl bookingsService;

	private FacultyAcad faculty;

	private List<Department> departments;

	private List<Users> faculties;

	private List<Role> roles;

	private String g_msg, g_err_msg;

	private List<StudentPrefCountInfo> prefSummaryList;

	private List<FacultyAllocations> rs;

	private static final DateFormat TWELVE_TF = new SimpleDateFormat("hh:mma");
	// Replace with kk:mm if you want 1-24 interval
	private static final DateFormat TWENTY_FOUR_TF = new SimpleDateFormat("HH:mm");

	// show home page, without tables
	@GetMapping("/home")
	public ModelAndView adminHome() {
		return getViewAdminHome(null, null);
	}

	// show home page
	public ModelAndView getViewAdminHome(List<StudentPrefCountInfo> studCountInfo,
			List<FacPrefCountInfo> facPrefCountInfo) {
		ModelAndView model = new ModelAndView();

		if (studCountInfo != null) {
			if (studCountInfo.isEmpty())
				model.addObject("err_msg", "There are no open student elective preference forms");
			else {
				model.addObject("studCountInfo", studCountInfo);
				if (g_msg != null)
					model.addObject("msg", g_msg);
				else
					model.addObject("err_msg", g_err_msg);
			}
		} else if (facPrefCountInfo != null) {
			if (facPrefCountInfo.isEmpty())
				model.addObject("err_msg", "There are no open faculty course preference forms");
			else {
				model.addObject("facCountInfo", facPrefCountInfo);
				if (g_msg != null)
					model.addObject("msg", g_msg);
				else
					model.addObject("err_msg", g_err_msg);
			}
		}
		model.setViewName("/admin/home");
		return model;

	}

	@RequestMapping(value = "/getStudPrefDetailsTable_async", method = RequestMethod.GET)
	public String getStudPrefDetailsTable(Model model) {

		List<StudentPrefCountInfo> studCountInfo = studPrefService.computeStudPrefTable();
		if (studCountInfo.isEmpty()) {
			model.addAttribute("err_msg", "There are no open student elective preference forms");
			return "admin/home:: messageDiv";
		} else {
			model.addAttribute("studCountInfo", studCountInfo);
			return "admin/home:: studPrefTable";
		}

	}

	@RequestMapping(value = "/getFacPrefDetailsTable_async", method = RequestMethod.GET)
	public String getFacPrefDetailsTable(Model model) {

		List<FacPrefCountInfo> facCountInfo = facPrefService.computeFacPrefTable();
		if (facCountInfo.isEmpty()) {
			model.addAttribute("err_msg", "There are no open faculty course preference forms");
			return "admin/home:: messageDiv";
		} else {
			model.addAttribute("facCountInfo", facCountInfo);
			return "admin/home:: facPrefTable";
		}

	}

//****************** Departments Page *******************
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
		ArrayList<FacultyAcad> fac = facultyAcadRepository.findByDepartmentEquals(department);
		List<String> facIds = new ArrayList<>();
		for (FacultyAcad f : fac) {
			facIds.add(f.getUserName());
		}
		faculties = usersRepository.findByUserNameList(facIds);
		model.addAttribute("manageDept", department);
		model.addAttribute("div", new Divisions());
		model.addAttribute("res", new Resource());
		model.addAttribute("faculties", faculties);
		return "admin/departments:: manageDeptFragment";
	}

	@RequestMapping(value = "/addDivision", method = RequestMethod.POST)
	String addDivision(Model model, Divisions div, String dept) {
		div.setDepartment(departmentRepository.findByDeptId(dept));
		String divId = div.getYear() + div.getDepartment().getDeptId() + div.getDivName();
		div.setDivId(divId);
		divisionsRepository.save(div);
		model.addAttribute("msg", "Division added in " + div.getYear() + "-" + div.getDepartment().getDeptName());
		return "admin/departments:: messageDiv";
	}

	@RequestMapping(value = "/addResource", method = RequestMethod.POST)
	String addResource(Model model, Resource res, String dept, String incharge) {
		res.setDepartment(departmentRepository.findByDeptId(dept));
		res.setResourceIncharge(facultyAcadRepository.findByUserName(incharge));
		resourceRepository.save(res);
		model.addAttribute("msg", "Resource added for " + res.getDepartment().getDeptName());
		return "admin/departments:: messageDiv";
	}

//***************end departments page***************

	@GetMapping("/getStudPrefDetailsTable")
	public ModelAndView getStudPrefDetailsTable() {

		return getViewAdminHome(studPrefService.computeStudPrefTable(), null);
	}

	@Transactional
	@RequestMapping(value = "/performQuickAction-student", method = RequestMethod.POST)
	public ModelAndView studentAllocQuickAction(String courseId, String selectAction, String courseName) {
		String courseIds[] = courseId.split(",");
		String actions[] = selectAction.split(",");
		int i = 0;
		for (i = 0; i < actions.length; i++) {
			if (!actions[i].equals("none")) {
				break;
			}
		}

		if (actions[i].equals("clearPrefs")) {
			clear_preferences(courseIds[i]);

		} else if (actions[i].equals("summary")) {
			// give summary and perform allocation
			prefSummaryList = new ArrayList<StudentPrefCountInfo>();
			Course course = courseRepository.findByCourseId(courseIds[i]);
			List<Electives> electives = electivesRepository.findByCourse(course);
			List<PrefNumCountPerElective> countPerElectiveList = studentPrefRepository.findPrefNumCountPerElective();

			for (Electives e : electives) {
				StudentPrefCountInfo ps = new StudentPrefCountInfo(0); // initialing all prefCounts = 0
				ps.setCourseId(e.getElectiveCourseId());
				ps.setCourseName(e.getElectiveName());

				for (PrefNumCountPerElective countPerElective : countPerElectiveList) {
					if (countPerElective.getElective().getElectiveCourseId().equals(e.getElectiveCourseId())) {
						switch (countPerElective.getPrefNo()) {
						case 1:
							ps.setCount1(countPerElective.getCount());
							break;
						case 2:
							ps.setCount2(countPerElective.getCount());
							break;
						case 3:
							ps.setCount3(countPerElective.getCount());
							break;
						case 4:
							ps.setCount4(countPerElective.getCount());
							break;
						}
					}
				}
				prefSummaryList.add(ps);
			}

			List<StudentPrefCountInfo> studentPrefInfo = studPrefService.computeStudPrefTable();
			ModelAndView model = new ModelAndView();
			model.addObject("studCountInfo", studentPrefInfo);
			model.addObject("prefSummaryList", prefSummaryList);
			model.setViewName("/admin/home");
			return model;
		}

		else {
			// action = close pref forms
			Course course = courseRepository.findByCourseId(courseIds[i]);
			if (course.getStudAllocFlag() != 2) {
				course.setStudAllocFlag(2);
				courseRepository.save(course);
				g_msg = "Preference forms for Course-id: " + courseIds[i] + " have been closed";
				g_err_msg = null;
			} else {
				g_err_msg = "Preference forms for Course-id: " + courseIds[i] + " are already closed";
				g_msg = null;
			}
		}

		return getStudPrefDetailsTable();
	}

	@GetMapping("/getFacPrefDetailsTable")
	public ModelAndView getFacPrefDetailsTable() {

		return getViewAdminHome(null, facPrefService.computeFacPrefTable());
	}

	@Transactional
	@RequestMapping(value = "/performQuickAction-faculty", method = RequestMethod.POST)
	public ModelAndView facultyAllocQuickAction(String deptName, String selectActionFac, String semType,
			String totalFacultyCount, String submitCount) {

		String actions[] = selectActionFac.split(",");
		String deptNames[] = deptName.split(",");
		String semTypes[] = semType.split(",");
		String submitCounts[] = submitCount.split(",");
		String totalFacultyCounts[] = totalFacultyCount.split(",");

		int i;
		for (i = 0; i < actions.length; i++) {
			if (!actions[i].equals("none")) {
				break;
			}
		}

		String action = actions[i];
		String selectedDeptName = deptNames[i];
		String selectedSemType = semTypes[i];
		int selectedSubmitCount = Integer.parseInt(submitCounts[i]);
		int selectedTotalFacultyCount = Integer.parseInt(totalFacultyCounts[i]);
		Department dept = departmentRepository.findByDeptId(selectedDeptName);
		OpenFacultyPrefs ofp = openFacultyPrefsRepository.findByDeptId(dept.getDeptId());

		if (action.equals("clearPrefs")) {
			if (ofp.getStatus() == 0) {
				facultyPrefRepository.deleteByDepartment(dept);
				openFacultyPrefsRepository.deleteByDeptId(dept.getDeptId());
			} else {
				g_err_msg = "Close preference forms before performing this action";
				g_msg = null;
			}

		} else if (action.equals("performAllocation")) {
			if (ofp.getStatus() == 0) {
				if (selectedSemType.charAt(0) == 'E')
					allocFaculty(0, dept);
				else
					allocFaculty(1, dept);
				g_msg = "Faculty allocation has been completed for " + dept.getDeptName();
				g_err_msg = null;
			} else {
				g_err_msg = "Close preference forms before performing this action";
				g_msg = null;
			}

		}

		else {
			// action = close pref forms
			if (ofp.getStatus() == 0) {
				g_err_msg = "Preference forms are already closed";
				g_msg = null;
			} else if (selectedSubmitCount != selectedTotalFacultyCount) {

				g_err_msg = "All faculties have not given preferences. Form has been closed but allocation cannot be performed.<br>"
						+ "Clear preferences to remove this entry";
				g_msg = null;
				ofp.setStatus(0);
				openFacultyPrefsRepository.save(ofp);
			} else {
				g_msg = "Preference forms have been closed";
				g_err_msg = null;
				ofp.setStatus(0);
				openFacultyPrefsRepository.save(ofp);
			}

		}

		return getFacPrefDetailsTable();
	}

	@RequestMapping(value = "/view-courses", method = RequestMethod.GET)
	public ModelAndView viewCourses() {
		ModelAndView model = new ModelAndView();
		departments = departmentRepository.findAll();
		model.addObject("department", departments);
		model.setViewName("admin/viewCourses");
		return model;
	}

	@RequestMapping(value = "/view-courses", method = RequestMethod.POST)
	public String viewCoursesUsingRequirements(Model model, String dept, String year, char sem) {
		ArrayList<Course> courseList;
		System.out.println("dept " + dept);
		System.out.println("year " + year);
		System.out.println("sem " + sem);

		if (dept.equals("none") && year.equals("none") && sem == '0') {
			courseList = courseRepository.findAll();

			System.out.println("all");
		} else {
			if (dept.equals("none") && year.equals("none") && sem != '0') {

				if (sem == 'o') {
					// odd
					courseList = courseRepository.findOddSemCourses();
				} else {
					// even
					courseList = courseRepository.findEvenSemCourses();
				}

			} else if (dept.equals("none") && !year.equals("none") && sem == '0') {
				courseList = courseRepository.findByCourseYear(year);

			} else if (!dept.equals("none") && year.equals("none") && sem == '0') {
				Department department = departmentRepository.findByDeptId(dept);
				courseList = courseRepository.findByDepartment(department);

			} else if (dept.equals("none") && !year.equals("none") && sem != '0') {
				Integer semester = Character.getNumericValue(sem);
				courseList = courseRepository.findByCourseSemAndCourseYear(semester, year);

			} else if (!dept.equals("none") && !year.equals("none") && sem == '0') {
				Department department = departmentRepository.findByDeptId(dept);
				courseList = courseRepository.findByCourseYearAndDepartment(year, department);

			} else if (!dept.equals("none") && year.equals("none") && sem != '0') {
				Department department = departmentRepository.findByDeptId(dept);

				if (sem == 'o') {
					// odd
					courseList = courseRepository.findByDepartmentAndOddCourseSem(department);
				} else {
					// even
					courseList = courseRepository.findByDepartmentAndEvenCourseSem(department);
				}
			} else {
				Department department = departmentRepository.findByDeptId(dept);
				Integer semester = Character.getNumericValue(sem);
				courseList = courseRepository.findByDepartmentAndCourseSemAndCourseYear(department, semester, year);

			}
		}
		if (courseList.size() != 0) {
			model.addAttribute("courses", courseList);
			return "admin/viewCourses:: courseTableDiv";
		} else {
			model.addAttribute("errmsg", "No courses found!");
			return "admin/viewCourses:: messageDiv";
		}

	}

	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		ModelAndView model = new ModelAndView();
		departments = departmentRepository.findAll();
		roles = roleRepository.findAll();
		model.addObject("roles", roles);
		model.addObject("department", departments);
		model.setViewName("admin/viewUsers");
		return model;

	}

	@RequestMapping(value = "/viewStudents", method = RequestMethod.POST)
	public String viewStudents(Model model, String year, String dept) {

		Department department = departmentRepository.findByDeptId(dept);
		ArrayList<StudentUsers> studUsersList = studAcadService.getStudentList(department, year);
		model.addAttribute("studUsersList", studUsersList);
		return "admin/viewUsers:: studTable";
	}

	@RequestMapping(value = "/viewAdmins", method = RequestMethod.GET)
	public String viewAdmins(Model model) {

		Set<Role> adminRole = new HashSet<Role>();
		adminRole.add(new Role(1, "ADMIN"));
		ArrayList<Users> adminUsers = userDetails.findByRole(adminRole);
		model.addAttribute("adminUsersList", adminUsers);
		return "admin/viewUsers:: adminsTable";

	}

	@RequestMapping(value = "/viewFaculty", method = RequestMethod.POST)
	public String viewFaculty(Model model, String dept) {

		Department department = departmentRepository.findByDeptId(dept);
		ArrayList<FacultyUsers> facUsersList = facAcadService.getFacultyList(department);

		model.addAttribute("facultyUsersList", facUsersList);
		return "admin/viewUsers:: facultyTable";

	}

	@Modifying
	@Transactional
	@RequestMapping(value = "/changeSeatsAndAllocate", method = RequestMethod.POST)
	public ModelAndView changeSeatsAndAllocate(String courseIdList, String seatList) {
		String electiveIds[] = courseIdList.split(",");
		String seats[] = seatList.split(",");
		String courseId = "";

		// check whether no of students is more than seats available
		// TODO

		for (int i = 0; i < electiveIds.length; i++) {
			ElectiveVacancyPrefCounts ec = electiveVacancyPrefCountsRepository.findByElectiveId(electiveIds[i]);
			ec.setVacancyCount(Integer.parseInt(seats[i]));
			electiveVacancyPrefCountsRepository.save(ec);
			courseId = ec.getCourseId();
		}
		set_process_student_allocation(courseId);

		ModelAndView model = new ModelAndView();

		if (g_err_msg != null) {
			return getStudPrefDetailsTable();
		}

		// return getStudPrefDetailsTable();

		Course c = courseRepository.findByCourseId(courseId);
//		System.out.println("course "+c.getCourseId());
		ArrayList<StudentAllocCourse> allocs = studentAllocCourseRepository.findByCourseId(c);
//		System.out.println("allocs size "+allocs.size());
		HashMap<String, Integer> electiveToCount = new HashMap<>();
		for (StudentAllocCourse sac : allocs) {
//			System.out.println("sac "+sac.getCourseId());
			String elective = sac.getElective().getElectiveCourseId();
			if (electiveToCount.containsKey(elective)) {
				electiveToCount.replace(elective, electiveToCount.get(elective) + 1);
			} else {
				electiveToCount.put(elective, 1);
			}
		}

		model.addObject("electiveToCount", electiveToCount);
		model.addObject("deptId", c.getDepartment().getDeptId());
		model.addObject("year", c.getCourseYear());
		model.setViewName("admin/electiveBatches");

		return model;

	}

	@Transactional
	@Modifying
	@ResponseBody
	@RequestMapping(value = "/set-batches", method = RequestMethod.POST)
	public String setNoOfBatches(Model model, @RequestBody ElectiveBatchCountList electiveBatchCounts) {
		String dept = electiveBatchCounts.getDeptId();
		String year = electiveBatchCounts.getYear();
		Course delCourse = electivesRepository
				.findByElectiveCourseId(electiveBatchCounts.getElectiveBatchCounts().get(0).getElectiveId())
				.getCourse();
		System.out.println(delCourse.getCourseId());
		electiveBatchesRepository.deleteByCourseId(delCourse);

		for (ElectiveBatchCount ebc : electiveBatchCounts.getElectiveBatchCounts()) {
			String batchId = "";
			List<String> batchIdList = new ArrayList<String>();
			for (int i = 0; i < ebc.getNoOfBatches(); i++) {
				ElectiveBatches eb = new ElectiveBatches();
				batchId = year + dept + "-" + ebc.getElectiveId() + "-" + (i + 1);
				eb.setBatchId(batchId);
				eb.setYear(year);
				eb.setDepartment(departmentRepository.findByDeptId(dept));
				eb.setElectiveId(ebc.getElectiveId());
				electiveBatchesRepository.save(eb);
				batchIdList.add(batchId);
			}
			if (ebc.getNoOfBatches() == 1)
				studentAllocCourseRepository.updateBatchIdByElectiveId(
						electivesRepository.findByElectiveCourseId(ebc.getElectiveId()), batchId);
			else {
				ArrayList<StudentAllocCourse> sacList = studentAllocCourseRepository
						.findByElectiveIdSortedByDiv(electivesRepository.findByElectiveCourseId(ebc.getElectiveId()));
				int totalStudents = sacList.size();
				int studentsPerBatch = Math.round(totalStudents / ebc.getNoOfBatches());
				int i = 0, extra = 0;

				if (studentsPerBatch * ebc.getNoOfBatches() < totalStudents)
					extra = totalStudents - studentsPerBatch * ebc.getNoOfBatches();
				else
					extra = studentsPerBatch * ebc.getNoOfBatches() - totalStudents;

				System.out.println("Extra: " + extra);
				System.out.println("StudentsPerBatch: " + studentsPerBatch);
				for (int j = 0; j < ebc.getNoOfBatches(); j++) {
					int batchCount = 0;
					if (extra-- > 0)
						batchCount = studentsPerBatch + 1;
					else
						batchCount = studentsPerBatch;

					System.out.println(batchCount);
					int cur = i;
					for (; i < cur + batchCount; i++) {
						StudentAllocCourse st = sacList.get(i);
						st.setBatchId(batchIdList.get(j));
						studentAllocCourseRepository.save(st);
					}
				}
			}
		}
		return "success";
	}

	// display uploadTT page
	@RequestMapping(value = "/uploadTT", method = RequestMethod.GET)
	public ModelAndView uploadTT() {
		ModelAndView model = new ModelAndView();
		departments = departmentRepository.findAll();
		model.addObject("departments", departments);

		model.setViewName("admin/uploadTT");
		return model;
	}

	// Handle upload TT form
	@Transactional
	@RequestMapping(value = "/upload_TT", method = RequestMethod.POST)
	public ModelAndView upload_TT(@RequestParam("timeTableFile") MultipartFile file, String dept, String day) {
		ModelAndView model = new ModelAndView();

		if (file.isEmpty()) {
			model.addObject("err_msg", "Please select a file to upload");
		} else {
			System.out.println(file.getOriginalFilename());

			try {
				String uploadsDir = "/uploads/";
				String realPathToUploads = request.getServletContext().getRealPath(uploadsDir);
				System.out.println(realPathToUploads);
				if (!new File(realPathToUploads).exists()) {
					new File(realPathToUploads).mkdir();
				}

				String orgName = file.getOriginalFilename();
				String filePath = realPathToUploads + orgName;
				System.out.println(filePath);
				File dest = new File(filePath);
				file.transferTo(dest);

				String msg = readTT(filePath, dept, day);

				if (msg.equals("Time Table has been uploaded successfully.")) {
					model.addObject("msg", msg);
				} else {
					model.addObject("err_msg", msg);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		departments = departmentRepository.findAll();
		model.addObject("departments", departments);
		model.setViewName("admin/uploadTT");
		return model;

	}

	// Display register user form
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUsers(String msg, String err_msg) {
		ModelAndView model = new ModelAndView();
		Users user = new Users();
		roles = roleRepository.findAll();
		departments = departmentRepository.findAll();
		model.addObject("user", user);
		model.addObject("student", new StudentAcad());
		model.addObject("roles", roles);
		model.addObject("department", departments);
		model.setViewName("admin/registerUsers");

		if (msg == null && err_msg != null) {
			model.addObject("errmsg", err_msg);
		} else if (msg != null && err_msg == null) {
			model.addObject("msg", msg);
		}
		return model;
	}

	// Handle register user form
	@RequestMapping(value = "/register_users", method = RequestMethod.POST)
	public ModelAndView createUser(Users user, String role, StudentAcad student, String dept, String dept1,
			Double facExp, String facDesignation, String facQualification, String divName) {
		ModelAndView model = new ModelAndView();
		Role userRole = roleRepository.findByRole(role);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		// check unique email
		String email = user.getEmail();
		if (!userDetails.isUniqueEmail(email)) {
			String errmsg = "A user is already registered with the given email";
			return registerUsers(null, errmsg);
		}

		if (role.equals("STUDENT")) {
			System.out.println("Adding user to studAcad");
			Department department = departmentRepository.findByDeptId(dept);
			student.setDepartment(department);
			if (studAcadService.validateAndSetStudDiv(student, divName)) {
				userDetails.saveUser(user);
				student.setUserName(user.getUserName());
				student.setUserDets(user);
				studentAcadRepository.save(student);
			} else
				return registerUsers(null, "Invalid division");
		} else if (role.equals("FACULTY")) {

			userDetails.saveUser(user);

			faculty = new FacultyAcad();
			System.out.println("Adding user to facultyAcad");
			faculty.setUserName(user.getUserName());
			Department department = departmentRepository.findByDeptId(dept1);

			faculty.setDepartment(department);
			faculty.setDesignation(facDesignation);
			faculty.setQualification(facQualification);
			faculty.setYearsOfExperience(facExp);
			faculty.setUserDets(user);
			facultyAcadRepository.save(faculty);

		} else {
			userDetails.saveUser(user);
		}

		departments = departmentRepository.findAll();
		model.addObject("msg", "User has been successfully registered");
		model.addObject("user", new Users());
		model.addObject("roles", roles);
		model.addObject("department", departments);
		model.addObject("student", new StudentAcad());
		model.setViewName("admin/registerUsers");
		return model;

	}

	// Display add course page
	@RequestMapping(value = "/add-course", method = RequestMethod.GET)
	public ModelAndView addCourses() {
		ModelAndView model = new ModelAndView();
		Course course = new Course();
		departments = departmentRepository.findAll();
		model.addObject("course", course);
		model.addObject("departments", departments);
		model.setViewName("admin/addCourses");
		return model;
	}

	// Handle add course form
	@RequestMapping(value = "/add_courses", method = RequestMethod.POST)
	public ModelAndView addCourse(@Valid Course course, String dept, String companionTheory, String prerequisiteNo1,
			String prerequisiteNo2) {
		ModelAndView model = new ModelAndView();

		Department deptObj = departmentRepository.findByDeptName(dept);
		course.setDepartment(deptObj);
		course.setStudAllocFlag(0);

		System.out.println(companionTheory);
		System.out.println(prerequisiteNo1 + " " + prerequisiteNo2);

		if (companionTheory.equals("") && prerequisiteNo1.equals("") && prerequisiteNo2.equals("")) {
			model.addObject("msg", "Course has been added successfully");
			model.addObject("course", new Course());
			courseRepository.save(course);
		} else if (!companionTheory.equals("")) {
			Optional<Course> thCourse = courseRepository
					.findByCourseIdAndDepartmentAndCourseYearAndCourseSemAndIsTheoryAndCourseType(companionTheory,
							course.getDepartment(), course.getCourseYear(), course.getCourseSem(), 1, 'R');

			if (thCourse.isPresent()) {
				// saving course
				model.addObject("msg", "Course has been added successfully");
				model.addObject("course", new Course());
				courseRepository.save(course);

				CompanionCourse cc = new CompanionCourse(thCourse.get().getCourseId(), course.getCourseId());
				courseCompanionRepository.save(cc);

				CompanionCourse ncc = new CompanionCourse(course.getCourseId(), thCourse.get().getCourseId());
				courseCompanionRepository.save(ncc);

			} else {
				model.addObject("err_msg", "Companion theory course doesn't exist!");
				model.addObject("course", new Course());
			}
		} else if (!prerequisiteNo1.equals("") && !prerequisiteNo2.equals("")) {
			Optional<Course> pr1Course = courseRepository.findByCourseIdAndDepartmentAndIsTheoryAndCourseType(
					prerequisiteNo1, course.getDepartment(), 1, 'R');
			Optional<Course> pr2Course = courseRepository.findByCourseIdAndDepartmentAndIsTheoryAndCourseType(
					prerequisiteNo2, course.getDepartment(), 1, 'R');

			if (pr1Course.isPresent() && pr2Course.isPresent()) {
				CoursePrerequisites cr = new CoursePrerequisites(course.getCourseId(), 0, 0, prerequisiteNo1,
						prerequisiteNo2);
				courseRepository.save(course);
				coursePrerequisitesRepository.save(cr);
				model.addObject("msg", "Course has been added successfully");
				model.addObject("course", new Course());

			} else if (!pr1Course.isPresent() && !pr2Course.isPresent()) {
				model.addObject("err_msg", "Prerequisite 1 and 2 theory courses don't exist!");
				model.addObject("course", new Course());

			} else if (!pr1Course.isPresent()) {
				model.addObject("err_msg", "Prerequisite 1 theory course doesn't exist!");
				model.addObject("course", new Course());

			} else if (!pr2Course.isPresent()) {
				model.addObject("err_msg", "Prerequisite 2 theory course doesn't exist!");
				model.addObject("course", new Course());

			}
		} else if (!prerequisiteNo1.equals("") && prerequisiteNo2.equals("")) {
			Optional<Course> pr1Course = courseRepository.findByCourseIdAndDepartmentAndIsTheoryAndCourseType(
					prerequisiteNo1, course.getDepartment(), 1, 'R');

			if (pr1Course.isPresent()) {
				CoursePrerequisites cr = new CoursePrerequisites(course.getCourseId(), 0, -1, prerequisiteNo1, "NA");
				courseRepository.save(course);
				coursePrerequisitesRepository.save(cr);
				model.addObject("msg", "Course has been added successfully");
				model.addObject("course", new Course());

			} else if (!pr1Course.isPresent()) {
				model.addObject("err_msg", "Prerequisite 1 theory course doesn't exist!");
				model.addObject("course", new Course());

			}
		} else {
			model.addObject("err_msg", "Cannot add course, something went wrong!");
			model.addObject("course", new Course());
		}

		model.addObject("departments", departments);
		model.setViewName("admin/addCourses");
		return model;
	}

	// Display add elective page
	@RequestMapping(value = "/add-elective", method = RequestMethod.GET)
	public ModelAndView get_all_elective() {

		ModelAndView model = new ModelAndView();
		Electives elective = new Electives();

		ArrayList<Course> electivesList = courseRepository.findByCourseTypeNot('R');

		model.addObject("electivesList", electivesList);
		model.addObject("elective", elective);
		model.setViewName("/admin/addElective");
		return model;

	}

	// Handle add elective form
	@RequestMapping(value = "/add_elective", method = RequestMethod.POST)
	public ModelAndView set_all_elective(String suffix, Electives elective, String courseId, String companionTheory,
			String prerequisiteNo1, String prerequisiteNo2) {

		ModelAndView model = new ModelAndView();
		System.out.println("checkL-" + courseId);
		System.out.println(companionTheory);
		System.out.println(prerequisiteNo1);
		System.out.println(prerequisiteNo2);
		elective.setElectiveCourseId(courseId.concat(suffix));
		Course course = courseRepository.findByCourseId(courseId);
		elective.setCourse(course);

		if (electivesRepository.findByElectiveName(elective.getElectiveName()).isPresent()
				|| electivesRepository.findByElectiveCourseId(elective.getElectiveCourseId()) != null) {
			System.out.println("Elective with same name or ID already exists");
			model.addObject("err_msg", "Elective with same name or ID already exists");
		} else {
			if (companionTheory.equals("") && prerequisiteNo1.equals("") && prerequisiteNo2.equals("")) {
				model.addObject("msg", "Elective has been added successfully");
				electivesRepository.save(elective);
			} else if (!companionTheory.equals("")) {
				Electives compElective = electivesRepository.findByElectiveCourseId(companionTheory);

				if (compElective != null) {
					electivesRepository.save(elective);
					CompanionCourse cc = new CompanionCourse(compElective.getElectiveCourseId(),
							elective.getElectiveCourseId());
					courseCompanionRepository.save(cc);

					CompanionCourse ncc = new CompanionCourse(elective.getElectiveCourseId(),
							compElective.getElectiveCourseId());
					courseCompanionRepository.save(ncc);
					model.addObject("msg", "Elective has been added successfully");
				} else {
					model.addObject("err_msg", "Companion theory course doesn't exist!");
					model.addObject("course", new Course());
				}
			} else if (!prerequisiteNo1.equals("") && !prerequisiteNo2.equals("")) {
				Optional<Course> pr1Course = courseRepository.findByCourseIdAndDepartmentAndIsTheoryAndCourseType(
						prerequisiteNo1, course.getDepartment(), 1, 'R');
				Optional<Course> pr2Course = courseRepository.findByCourseIdAndDepartmentAndIsTheoryAndCourseType(
						prerequisiteNo2, course.getDepartment(), 1, 'R');
				Electives pr1Elective = electivesRepository.findByElectiveCourseId(prerequisiteNo1);
				Electives pr2Elective = electivesRepository.findByElectiveCourseId(prerequisiteNo2);

				// both preq are regular
				if (pr1Course.isPresent() && pr2Course.isPresent() && pr1Elective == null && pr2Elective == null) {
					electivesRepository.save(elective);
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(), 0, 0,
							prerequisiteNo1, prerequisiteNo2);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg", "Elective has been added successfully");

					// both preq are electives
				} else if (!pr1Course.isPresent() && !pr2Course.isPresent() && pr1Elective != null
						&& pr2Elective != null) {
					electivesRepository.save(elective);
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(), 1, 1,
							prerequisiteNo1, prerequisiteNo2);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg", "Elective has been added successfully");

					// first is regular and second is elective
				} else if (pr1Course.isPresent() && !pr2Course.isPresent() && pr1Elective == null
						&& pr2Elective != null) {
					electivesRepository.save(elective);
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(), 0, 1,
							prerequisiteNo1, prerequisiteNo2);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg", "Elective has been added successfully");

					// first is elective and second is regular
				} else if (!pr1Course.isPresent() && pr2Course.isPresent() && pr1Elective != null
						&& pr2Elective == null) {
					electivesRepository.save(elective);
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(), 1, 0,
							prerequisiteNo1, prerequisiteNo2);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg", "Elective has been added successfully");

				} else if (pr1Course.isPresent() && pr2Course.isPresent() && pr1Elective != null
						&& pr2Elective != null) {
					model.addObject("err_msg", "Ambiguous Ids entered.");

				} else if (!pr1Course.isPresent() && !pr2Course.isPresent() && pr1Elective == null
						&& pr2Elective == null) {
					model.addObject("err_msg", "Prerequisite 1 and 2 theory courses don't exist!");

				} else if (!pr1Course.isPresent() && pr1Elective == null) {
					model.addObject("err_msg", "Prerequisite 1 theory course doesn't exist!");

				} else if (!pr2Course.isPresent() && pr2Elective == null) {
					model.addObject("err_msg", "Prerequisite 2 theory course doesn't exist!");

				}
			} else if (!prerequisiteNo1.equals("") && prerequisiteNo2.equals("")) {
				Optional<Course> pr1Course = courseRepository.findByCourseIdAndDepartmentAndIsTheoryAndCourseType(
						prerequisiteNo1, course.getDepartment(), 1, 'R');
				Electives pr1Elective = electivesRepository.findByElectiveCourseId(prerequisiteNo1);

				if (pr1Course.isPresent() && pr1Elective == null) {
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(), 0, -1,
							prerequisiteNo1, "NA");
					electivesRepository.save(elective);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg", "Elective has been added successfully");

				} else if (!pr1Course.isPresent() && pr1Elective != null) {
					CoursePrerequisites cr = new CoursePrerequisites(elective.getElectiveCourseId(), 1, -1,
							prerequisiteNo1, "NA");
					electivesRepository.save(elective);
					coursePrerequisitesRepository.save(cr);
					model.addObject("msg", "Elective has been added successfully");

				} else if (!pr1Course.isPresent() && pr1Elective == null) {
					model.addObject("err_msg", "Prerequisite 1 theory course doesn't exist!");

				} else if (pr1Course.isPresent() && pr1Elective != null) {
					model.addObject("err_msg", "Ambigious Ids entered");
				}
			} else {
				model.addObject("err_msg", "Cannot add course, something went wrong!");
			}
			// model.addObject("msg","Elective added successfully");
		}

		ArrayList<Course> electivesList = courseRepository.findByCourseTypeNot('R');
		model.addObject("electivesList", electivesList);
		model.addObject("elective", new Electives());
		model.setViewName("/admin/addElective");
		return model;

	}

	// Get studCourseAllocation HTML page for opening course allocation forms
	@RequestMapping(value = "/openCourseAllocation", method = RequestMethod.GET)
	public ModelAndView openCourseAllocation(ArrayList<Course> elective_ids, String err_msg) {
		ModelAndView model = new ModelAndView();

		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments", departments);
		model.setViewName("/admin/studCourseAllocation");
		model.addObject("course", new Course());

		if (elective_ids != null && !elective_ids.isEmpty())
			model.addObject("elective_ids", elective_ids);

		if (err_msg != null)
			model.addObject("err_msg", err_msg);

		return model;
	}

	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES
	// Retrieve all electives for specified dept, year and sem
	@RequestMapping(value = "/findElective", method = RequestMethod.POST)
	public ModelAndView findElective(@Valid Course course, String dept) {

		Department department = departmentRepository.findByDeptId(dept);

		System.out.println(course.getCourseSem() + " " + course.getCourseYear());
		System.out.println(department.getDeptId());

		ArrayList<Course> courses = courseRepository
				.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheory(course.getCourseSem(),
						course.getCourseYear(), 'R', department, 1);
		if (courses.size() == 0) {
			String msg = "No Elective Courses found!";
			return openCourseAllocation(null, msg);
		}

		ArrayList<Course> elective_ids = courseRepository
				.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(
						course.getCourseSem(), course.getCourseYear(), 'R', department, 1, 0);

		if (elective_ids.size() == 0) {
			String msg = "Student elective preference forms have already been released for the specified department, year and semester.";
			return openCourseAllocation(elective_ids, msg);
		}

		return openCourseAllocation(elective_ids, null);
	}

	// open course allocation forms for specified electives, (set studAllocFlag = 1)
	@RequestMapping(value = "/open_student_allocation", method = RequestMethod.POST)
	public ModelAndView open_student_allocation(String electiveIdOption) {

		ModelAndView model = new ModelAndView();

		Course startCourse = courseRepository.findByCourseId(electiveIdOption);

		if (startCourse == null)
			model.addObject("err_msg", "Specified elective does not exist for the given Year and Semester");
		else {
			ArrayList<Electives> all_electives = electivesRepository.findByCourse(startCourse);
			if (all_electives.size() != 0) {
				for (Electives electives : all_electives) {
					ElectiveVacancyPrefCounts electiveVacancyPrefCounts = new ElectiveVacancyPrefCounts();
					System.out.println(startCourse.getCourseId());
					electiveVacancyPrefCounts.setCourseId(startCourse.getCourseId());
					electiveVacancyPrefCounts.setPrefCount(0);
					electiveVacancyPrefCounts.setVacancyCount(2); // total seats available for an elective course
					electiveVacancyPrefCounts.setElectiveId(electives.getElectiveCourseId());
					electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);

					startCourse.setStudAllocFlag(1);
					courseRepository.save(startCourse);

					model.addObject("msg", "Student preference forms are released for: " + startCourse.getCourseYear()
							+ " Semester: " + startCourse.getCourseSem() + " " + startCourse.getCourseName());
				}
			} else {
				model.addObject("err_msg", "No electives found for the Course Id: ".concat(electiveIdOption));
			}

		}
		ArrayList<Department> departments = departmentRepository.findAll();

		model.addObject("departments", departments);
		model.addObject("course", new Course());
		model.setViewName("/admin/studCourseAllocation");
		return model;
	}

	// showing allocations - getShowAllocations
	@RequestMapping(value = "/getShowAllocations", method = RequestMethod.GET)
	public ModelAndView getShowAllocations(ArrayList<Course> elective_ids, String msg, String err_msg) {
		ModelAndView model = new ModelAndView();

		ArrayList<Department> departments = departmentRepository.findAll();

		model.addObject("course", new Course());
		model.addObject("departments", departments);
		model.setViewName("/admin/showAllocations");
		if (elective_ids.size() != 0)
			model.addObject("elective_ids", elective_ids);
		if (msg != null)
			model.addObject("msg", msg);
		if (err_msg != null)
			model.addObject("err_msg", err_msg);
		return model;
	}

	// Get facCourseAllocation HTML page for opening course allocation forms
	@RequestMapping(value = "/openFacCourseAllocation", method = RequestMethod.GET)
	public ModelAndView openFacCourseAllocation() {
		ModelAndView model = new ModelAndView();

		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments", departments);
		model.setViewName("/admin/openFacPrefs");

		return model;
	}

	@Transactional
	@Modifying
	@RequestMapping(value = "/open_faculty_allocation", method = RequestMethod.POST)
	public ModelAndView open_faculty_allocation(String deptId, String semType) {

		ModelAndView model = new ModelAndView();

		OpenFacultyPrefs openFacPrefs = new OpenFacultyPrefs();
		openFacPrefs.setDeptId(deptId);
		openFacPrefs.setSemType(Integer.parseInt(semType));
		openFacPrefs.setStatus(1);

		openFacultyPrefsRepository.save(openFacPrefs);

		Department dept = departmentRepository.findByDeptId(deptId);

		facultyPrefRepository.deleteByDepartment(dept);

		ArrayList<Department> departments = departmentRepository.findAll();
		model.addObject("departments", departments);
		model.addObject("msg", "Faculty preference forms have been opened successfully");

		model.setViewName("/admin/openFacPrefs");
		return model;
	}

	// @RequestMapping(value="/process_student_allocation_post",method=RequestMethod.POST)
	@Transactional
	private void set_process_student_allocation(String electiveIdOption) {

		// check whether course is open for preferences or not
		Course course = courseRepository.findByCourseId(electiveIdOption);
		System.out.println(course.getCourseId() + " " + course.getStudAllocFlag());
		if (course.getStudAllocFlag() == 2) {
			ArrayList<Electives> all_electives = electivesRepository.findByCourse(course);

			if (all_electives.size() != 0) {

				int alloc = allocation_of_students_to_elective_course(course.getCourseId(), course.getCourseYear(),
						course.getCourseSem());
				if (alloc == 1) {
					g_msg = "The allocation has been completed for Course-Id: " + course.getCourseId();
					g_err_msg = null;
				} else if (alloc == 0) {
					g_err_msg = "No preferences are recorded!";
					g_msg = null;
				} else if (alloc == -1) {
					g_err_msg = "Allocation has already been performed for Course-id: " + electiveIdOption;
					g_msg = null;
				} else if (alloc == -2) {
					g_err_msg = "Total number of seats is less than number of students.";
					g_msg = null;
				}

			} else {
				g_err_msg = "No electives found for the course Id: ".concat(electiveIdOption);
				g_msg = null;
			}
		} else {
			g_err_msg = "Preference forms should be closed before performing allocation.";
			g_msg = null;
		}

		// return process_student_allocation(null,g_msg,g_err_msg);
	}

	// CHANGE NEEDED AFTER HANDLING OPEN ELECTIVES
	private int allocation_of_students_to_elective_course(String course_id, String year, int semester) {

		ArrayList<StudentPref> studentPrefs = studentPrefRepository.findByCourseIdEquals(course_id);

		Course ElCourse = courseRepository.findByCourseId(course_id);
		ArrayList<StudentAllocCourse> studentAllocs = studentAllocCourseRepository.findByCourseId(ElCourse);

		if (studentAllocs.size() != 0) {
			studentAllocCourseRepository.deleteByCourseId(ElCourse);
		}
		if (studentPrefs.size() != 0) {

			ArrayList<StudentAcad> studentAcads = studentAcadRepository
					.findBySemEqualsAndYearEqualsAndDepartmentEquals(semester, year, ElCourse.getDepartment());

			Collections.sort(studentAcads);

			// Store all vacancy counts for all courses

			ArrayList<ElectiveVacancyPrefCounts> allElectiveCounts = electiveVacancyPrefCountsRepository
					.findByCourseId(course_id);

			HashMap<String, Integer> eVHM = new HashMap<String, Integer>();

			for (ElectiveVacancyPrefCounts e : allElectiveCounts) {
				eVHM.put(e.getElectiveId(), e.getVacancyCount());
			}

			ArrayList<Electives> popularElectives = calculatePrefCounts(course_id, year, semester, allElectiveCounts);

			HashMap<StudentAcad, StudentAllocCourse> studAllocs = new HashMap<StudentAcad, StudentAllocCourse>();

			// for each student in reverse
			for (StudentAcad studentAcad : studentAcads) {
				ArrayList<StudentPref> stud = studentPrefRepository.findByUserNameAndCourseId(studentAcad.getUserName(),
						course_id);

				if (stud.size() != 0) {

					Electives prefs[] = new Electives[stud.size()];
					int i = 0;
					for (StudentPref studPref : stud) {
						prefs[i] = studPref.getElective();
						i += 1;
					}

					int prefNo = 1;
					int flag = 0;

					for (Electives pref : prefs) {
						int vCount = eVHM.get(pref.getElectiveCourseId());
						if (vCount > 0) {
							eVHM.replace(pref.getElectiveCourseId(), vCount - 1);
							StudentAllocCourse s = new StudentAllocCourse(pref, pref.getCourse(), studentAcad, prefNo,
									"");
							studAllocs.put(studentAcad, s);
							flag = 1;
							break;
						}
						prefNo += 1;
					}
					if (flag == 0) {
						// assign popular course
						System.out.println("No preference left!");
						System.out.println("Assigning course according to popularity!");
						for (Electives e : popularElectives) {
							int vCount = eVHM.get(e.getElectiveCourseId());
							if (vCount > 0) {
								eVHM.replace(e.getElectiveCourseId(), vCount - 1);
								StudentAllocCourse s = new StudentAllocCourse(e, e.getCourse(), studentAcad, -1, "");
								studAllocs.put(studentAcad, s);
								flag = 1;
								break;
							}
						}
						if (flag == 0) {
							System.out.println("NO OPTION LEFT!!!! NEED TO INCREASE CAPACITY!!!");
							return -2;
						}
					}

				} else {
					// assign popular course
//						System.out.println("Hasn't given preference");
//						System.out.println("Assigning course according to popularity!");
					int flag = 0;
					for (Electives e : popularElectives) {
						int vCount = eVHM.get(e.getElectiveCourseId());
						if (vCount > 0) {
							eVHM.replace(e.getElectiveCourseId(), vCount - 1);
							StudentAllocCourse s = new StudentAllocCourse(e, e.getCourse(), studentAcad, -1, "");
							studAllocs.put(studentAcad, s);
							flag = 1;
							break;
						}
					}
					if (flag == 0) {
						System.out.println("NO OPTION LEFT!!!! NEED TO INCREASE CAPACITY!!!");
						return -2;
					}

				}

			}
			for (StudentAcad s : studAllocs.keySet()) {
				studentAllocCourseRepository.save(studAllocs.get(s));
			}

			return 1;
		} else {
			return 0;
		}

	}

	private ArrayList<Electives> calculatePrefCounts(String course_id, String year, int semester,
			ArrayList<ElectiveVacancyPrefCounts> electiveVacancyPrefCounts) {

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
		if (status != 2) {
			g_msg = null;
			if (status == 1)
				g_err_msg = "Cannot clear preferences for open forms. Close forms before clearing preferences";
			else
				g_err_msg = "Preferences have already been cleared";
		} else {
			studentPrefRepository.deleteByCourseId(electiveIdOption);
			electiveVacancyPrefCountsRepository.deleteByCourseId(electiveIdOption);
			Course c = courseRepository.findByCourseId(electiveIdOption);
			c.setStudAllocFlag(0);
			courseRepository.save(c);

			g_msg = "Cleared preferences for Course Id: " + electiveIdOption;
			g_err_msg = null;

		}
	}

	// findElectivesToShow
	// @ResponseBody
	@RequestMapping(value = "/findElectivesToShow", method = RequestMethod.POST)
	public ModelAndView findElectivesToShow(Course course, String dept) {

		String year = course.getCourseYear();
		Integer sem = course.getCourseSem();
		Department department = departmentRepository.findByDeptId(dept);

		ArrayList<Course> elective_ids = courseRepository
				.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(sem, year, 'R',
						department, 1, 2);

		if (elective_ids.size() == 0) {
			String err_msg = "No electives are opened for preference forms.";
			return getShowAllocations(elective_ids, null, err_msg);

		}
		return getShowAllocations(elective_ids, null, null);

	}

	// showAllocations
	@RequestMapping(value = "/showAllocations", method = RequestMethod.POST)
	public ModelAndView showAllocations(String electiveIdOption) {
		ModelAndView model = new ModelAndView();

		ArrayList<Department> departments = departmentRepository.findAll();

		model.addObject("course", new Course());
		model.addObject("departments", departments);
		model.setViewName("/admin/showAllocations");

		Course c = courseRepository.findByCourseId(electiveIdOption);
		ArrayList<StudentAllocCourse> studAllocations = studentAllocCourseRepository.findByCourseId(c);
		if (studAllocations.size() != 0)
			model.addObject("studAllocations", studAllocations);
		else
			model.addObject("err_msg", "No allocations done yet for Course Id: " + electiveIdOption);
		return model;
	}

	// delete course or elective
	@Transactional
	@RequestMapping(value = "/delete-course-elective", method = RequestMethod.GET)
	public ModelAndView getDelCourseOrElective(String msg, String err_msg) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/deleteCourseOrElective");
		if (msg != null)
			model.addObject("msg", msg);
		else if (err_msg != null)
			model.addObject("err_msg", err_msg);
		return model;
	}

	@Transactional
	@RequestMapping(value = "/delete-course-elective", method = RequestMethod.POST)
	public ModelAndView setDelCourseOrElective(String c_id, String e_id) {
		String msg = null;
		String err_msg = null;
		if (!c_id.equals("")) {
			System.out.println("course");
			Course c = courseRepository.findByCourseId(c_id);
			CoursePrerequisites cprereq = coursePrerequisitesRepository.findByCourseId(c_id);
			ArrayList<StudentPref> cstudPref = studentPrefRepository.findByCourseIdEquals(c_id);
			if (c != null) {
				courseRepository.delete(c);

				if (cprereq != null) {
					coursePrerequisitesRepository.deleteByCourseId(c_id);
					// msg.concat("Corresponding prerequisites mapping are deleted.\n");
				}
				if (cstudPref.size() != 0) {
					studentPrefRepository.deleteByCourseId(c_id);
					// msg.concat("Corresponding prerequisites mapping are deleted.\n");
				}
				msg = "Course has been deleted successfully.";
			} else {
				err_msg = "Specified Course does not exist. Please check again.";
			}
		} else if (!e_id.equals("")) {
			System.out.println("elective");
			Electives e = electivesRepository.findByElectiveCourseId(e_id);

			ArrayList<StudentPref> estudPref = studentPrefRepository.findByElective(e);

			if (e != null) {
				if (e.getCourse().getStudAllocFlag() != 0) {
					err_msg = "Cannot delete the elective as its status is Open or Closed.";

				} else {

					electivesRepository.delete(e);
					if (estudPref.size() != 0) {
						studentPrefRepository.deleteByCourseId(e_id);
						// msg.concat("Corresponding prerequisites mapping are deleted.\n");
					}
					msg = "Elective has been deleted successfully.";
				}
			} else {
				err_msg = "Specified Elective does not exist. Please check again.";
			}
		} else if (c_id.equals("") && e_id.equals("")) {
			System.out.println("error");
			err_msg = "Something went wrong.";
		}

		return getDelCourseOrElective(msg, err_msg);
	}

//	@RequestMapping(value="/allocFaculty",method=RequestMethod.POST)
//	public ModelAndView
	// 0 -- odd, 1 -- even
	public void allocFaculty(int isSemOdd, Department dept) {

		// find all the courses
		// get data of designation and faculty for that department

		// designationToHours objects list
		List<DesignationToHours> desigList = designationToHoursRepository.findAll();
		// all faculty list for that department
		List<FacultyAcad> allFacs = facultyAcadRepository.findByDepartmentEquals(dept);

		// clear courseList and practicalList tables
		List<String> facIdList = new ArrayList<String>();
		for (FacultyAcad f : allFacs) {
			facIdList.add(f.getUserName());
		}

		courseListRepository.deleteByFacultyIdList(facIdList);
		practicalListRepository.deleteByFacultyIdList(facIdList);

		// designation to min max hours hashmap
		HashMap<String, int[]> desigHours = new HashMap<>();

		for (DesignationToHours d : desigList) {
			desigHours.put(d.getDesignation(), new int[] { d.getMinLimit(), d.getMaxLimit() });
		}

		// Hashmap for limiting no of thoery courses to 2/faculty
		HashMap<String, Integer> facTheoryLimit = new HashMap<>();
		for (FacultyAcad f : allFacs) {
			facTheoryLimit.put(f.getUserName(), 2);
		}

		// faculty to min hours
		// max hours hashmap, faculty to alloted hours hashmap
		// key: facultyID, value: current_alloted_hrs
		HashMap<String, Integer> facAllotedHours = new HashMap<>();

		// key: facultyID, value: <minLimit, maxLimit>
		HashMap<String, int[]> facLimits = new HashMap<>();

		// key: facultyID, value: loadLeft (maxLimit - current_alloted_hrs)
		HashMap<String, Integer> facLoadLeft = new HashMap<>();
		HashMap<String, Integer> facTheoryHours = new HashMap<String, Integer>();
		HashMap<String, Integer> facPracticalHours = new HashMap<String, Integer>();
		int totalCourseHours = 0, totalFacLoad = 0;

		for (FacultyAcad f : allFacs) {
			totalFacLoad += desigHours.get(f.getDesignation())[1];
		}
		// divisions for each year sem
		List<Divisions> divisionNeeds = divisionsRepository.findByDepartment(dept);

		List<ElectiveBatches> electiveNeeds = electiveBatchesRepository.findByDepartment(dept);

		Collections.sort(divisionNeeds, new DivisionsChainedComparator(new DivisionsYearComparator()));

		// theory courses for that sem
		ArrayList<CourseList> courseList = new ArrayList<>();

		ArrayList<PracticalList> practicalList = new ArrayList<>();
		// maps all course ids with their practical courses in prac List
		HashMap<String, List<Integer>> practicalListPointer = new HashMap<String, List<Integer>>();
		HashMap<String, List<Integer>> practicalListPointerPerDiv = new HashMap<String, List<Integer>>();

		ArrayList<Course> allTheoryCourses;
		ArrayList<Course> allTheoryElectiveCourses;
		ArrayList<Course> allElectivePracticals;

		if (isSemOdd == 1) { // odd
			allTheoryCourses = courseRepository.findOddSemCoursesAndCourseTypeRegAndIsTheoryAndDepartment(dept);
			allTheoryElectiveCourses = courseRepository
					.findOddSemCoursesAndCourseTypeNotRegAndIsTheoryAndDepartment(dept);
			allElectivePracticals = courseRepository
					.findOddSemCoursesAndCourseTypeNotRegAndIsTheoryNotAndDepartment(dept);
		} else { // even
			allTheoryCourses = courseRepository.findEvenSemCoursesAndCourseTypeRegAndIsTheoryAndDepartment(dept);
			allTheoryElectiveCourses = courseRepository
					.findEvenSemCoursesAndCourseTypeNotRegAndIsTheoryAndDepartment(dept);
			allElectivePracticals = courseRepository
					.findEvenSemCoursesAndCourseTypeNotRegAndIsTheoryNotAndDepartment(dept);
		}

		int pl = 0;

		// add regular theory courses to courseList and practical courses to
		// practicalList
		for (Course c : allTheoryCourses) {
			for (Divisions d : divisionNeeds) {

				if (d.getDepartment().equals(c.getDepartment()) && d.getYear().equals(c.getCourseYear())) {
					courseList.add(new CourseList(c.getCourseId(), d.getDivId(), "", c.getNoOfHours()));
					totalCourseHours += c.getNoOfHours();
					CompanionCourse cc = courseCompanionRepository.findByCourse(c.getCourseId());
					if (cc != null) {
						// lab
						for (int i = 1; i <= d.getNoOfBatches(); i++) {
							PracticalList p = new PracticalList();
							p.setFacultyId("");
							System.out.println(d.getDivId());
							p.setDivId(d.getDivId());
							p.setLabId(d.getDivId().concat(Integer.toString(i)));
							p.setNoOfHours(courseRepository.findByCourseId(cc.getCompanionCourse()).getNoOfHours());
							p.setPracticalCourseId(cc.getCompanionCourse());
							p.setTheoryCourseId(cc.getCourse());
							if (practicalListPointer.get(cc.getCourse()) == null) {
								List<Integer> li = new ArrayList<Integer>();
								li.add(pl);
								practicalListPointer.put(cc.getCourse(), li);
							} else {
								practicalListPointer.get(cc.getCourse()).add(pl);
							}
							if (practicalListPointerPerDiv.get(cc.getCourse() + d.getDivId()) == null) {
								List<Integer> li = new ArrayList<Integer>();
								li.add(pl);
								practicalListPointerPerDiv.put(cc.getCourse() + d.getDivId(), li);
							} else {
								practicalListPointerPerDiv.get(cc.getCourse() + d.getDivId()).add(pl);
							}
							totalCourseHours += p.getNoOfHours();
							pl++;
							practicalList.add(p);
						}
					}
				}
			}
		}

		// add elective theory courses to course list
		for (Course c : allTheoryElectiveCourses) {
			ArrayList<Electives> allTheoryElectives = electivesRepository.findByCourse(c);

			for (Electives e : allTheoryElectives) {
				for (ElectiveBatches eb : electiveNeeds) {

					if (e.getElectiveCourseId().equals(eb.getElectiveId())
							&& eb.getDepartment().equals(c.getDepartment()) && eb.getYear().equals(c.getCourseYear())) {
						courseList.add(new CourseList(e.getElectiveCourseId(), eb.getBatchId(), "", c.getNoOfHours()));
						totalCourseHours += c.getNoOfHours();
					}
				}

			}
		}

		// add elective practical courses to practical list
		for (Course c : allElectivePracticals) {
			System.out.println(c.getCourseId());
			ArrayList<CompanionCourse> ccs = courseCompanionRepository
					.findByCompanionCourseAndCourseIdInElectiveBatches(c.getCourseId());
//			System.out.println("ccs size "+ccs.size());
//			CompanionCourse cc = courseCompanionRepository.findByCompanionCourse(c.getCourseId());

			for (CompanionCourse cc : ccs) {
				ArrayList<Electives> courseElectives = electivesRepository.findByCourse(courseRepository.findByCourseId(cc.getCourse()));

				for (Divisions d : divisionNeeds) {
					if (d.getDepartment().equals(c.getDepartment()) && d.getYear().equals(c.getCourseYear())) {
						for (int i = 1; i <= d.getNoOfBatches(); i++) {
							PracticalList p = new PracticalList();
							p.setFacultyId("");
							p.setDivId(d.getDivId());
							p.setLabId(d.getDivId().concat(Integer.toString(i)));
							p.setNoOfHours(c.getNoOfHours());
							p.setPracticalCourseId(c.getCourseId());
							p.setTheoryCourseId(cc.getCourse());
							for (Electives e : courseElectives) {
								if (practicalListPointer.get(e.getElectiveCourseId()) == null) {
									List<Integer> li = new ArrayList<Integer>();
									li.add(pl);
									practicalListPointer.put(e.getElectiveCourseId(), li);
								} else {
									practicalListPointer.get(e.getElectiveCourseId()).add(pl);
								}
								for (ElectiveBatches eb : electiveNeeds) {
									if (eb.getElectiveId().equals(e.getElectiveCourseId())) {
										if (practicalListPointerPerDiv
												.get(e.getElectiveCourseId() + d.getDivId()) == null) {
											List<Integer> li = new ArrayList<Integer>();
											li.add(pl);
											practicalListPointerPerDiv.put(e.getElectiveCourseId() + eb.getBatchId(),
													li);
										} else {
											practicalListPointerPerDiv.get(e.getElectiveCourseId() + eb.getBatchId())
													.add(pl);
										}
									}
								}

							}
							totalCourseHours += p.getNoOfHours();
							pl++;
							practicalList.add(p);
						}
					}
				}
			}
		}

		// more fac hrs than courses
		if (totalCourseHours < totalFacLoad) {
			HashMap<String, Integer> facsPerDesig = new HashMap<String, Integer>();
			for (Entry<String, int[]> entry : desigHours.entrySet()) {
				int count = facultyAcadRepository.countFacultyByDesignationAndDepartment(entry.getKey(), dept);
				facsPerDesig.put(entry.getKey(), count);
			}
			int cur = 0;
			cur = totalFacLoad;
			while (cur >= totalCourseHours) {
				cur = 0;
				for (Entry<String, int[]> entry : desigHours.entrySet()) {
					cur += facsPerDesig.get(entry.getKey()) * (entry.getValue()[1] - 1);
					desigHours.put(entry.getKey(), new int[] { entry.getValue()[0], entry.getValue()[1] - 1 });
				}
			}
			for (Entry<String, int[]> entry : desigHours.entrySet()) {
				desigHours.put(entry.getKey(), new int[] { entry.getValue()[0], entry.getValue()[1] + 1 });
			}
		} else {
			// less fac hrs than courses
			HashMap<String, Integer> facsPerDesig = new HashMap<String, Integer>();

			for (Entry<String, int[]> entry : desigHours.entrySet()) {
				int count = facultyAcadRepository.countFacultyByDesignationAndDepartment(entry.getKey(), dept);
				facsPerDesig.put(entry.getKey(), count);
			}
			int cur = 0;
			cur = totalFacLoad;
			while (cur < totalCourseHours) {
				cur = 0;
				for (Entry<String, int[]> entry : desigHours.entrySet()) {
					cur += facsPerDesig.get(entry.getKey()) * (entry.getValue()[1] + 1);
					desigHours.put(entry.getKey(), new int[] { entry.getValue()[0], entry.getValue()[1] + 1 });
				}
			}
		}

		for (FacultyAcad f : allFacs) {
			facAllotedHours.put(f.getUserName(), 0);
			facLimits.put(f.getUserName(), desigHours.get(f.getDesignation()));
			facLoadLeft.put(f.getUserName(), desigHours.get(f.getDesignation())[1]);
			facTheoryHours.put(f.getUserName(), 0);
			facPracticalHours.put(f.getUserName(), 0);
			totalFacLoad += desigHours.get(f.getDesignation())[1];
		}

		int courseIndex = -1;
		ArrayList<Integer> nonPreferredCourseIndices = new ArrayList<>();
		String prevCourse = "";
		HashMap<String, LinkedHashSet<String>> courseFacs = new HashMap<>();

		// Collections.sort(courseList,new CourseListChainedComaparator(new
		// CourseListYearComparator()));

		for (int prefNo = 1; prefNo < 9; prefNo++) {
			courseIndex = -1;
			for (CourseList c : courseList) {

				courseIndex++;
				ArrayList<FacultyPref> fpref = new ArrayList<>();

				// allocate unalloted practicals for prevIterated course
				if (!c.getCourseId().equals(prevCourse) && !prevCourse.equals("")) {
					List<Integer> pracListptrs = practicalListPointer.get(prevCourse);
					LinkedHashSet<String> facs = courseFacs.get(prevCourse);

					if (facs != null && pracListptrs != null)
						for (int i : pracListptrs) {

							PracticalList p = practicalList.get(i);

							if (p.getFacultyId().equals("")) {
								for (String fId : facs) {
									if (facAllotedHours.get(fId) + p.getNoOfHours() <= facLimits.get(fId)[1]) {
										p.setFacultyId(fId);
										// System.out.println(p.getFacultyId());
										facAllotedHours.replace(fId, facAllotedHours.get(fId) + p.getNoOfHours());
										facLoadLeft.replace(fId, facLoadLeft.get(fId) - p.getNoOfHours());
										facPracticalHours.replace(fId, facPracticalHours.get(fId) + p.getNoOfHours());
									}
								}

							}
						}
				}

				prevCourse = c.getCourseId();
				fpref = facultyPrefRepository.findByElectiveIdAndPrefNo(c.getCourseId(), prefNo);

				if (fpref.size() == 0) {
					fpref = facultyPrefRepository.findByCourseIdAndPrefNo(c.getCourseId(), prefNo);
				}

				if (fpref.size() == 0) {
					// No faculty gave pref for this course

					continue;
				}

				Collections.sort(fpref,
						new FacultyPrefChainedComparator(new FacultyPrefNoComparator(),
								new FacultyPrefCourseExpComparator(), new FacultyPrefPrereqExp1Comparator(),
								new FacultyPrefPrereqExp2Comparator()));

//				List<Integer> pracListptrs1 = practicalListPointer.get(c.getCourseId());
				List<Integer> pracListptrs = practicalListPointerPerDiv.get(c.getCourseId() + c.getDivisionId());
				int pracAllotCounter = 0;
				for (FacultyPref fp : fpref) {
					if (facTheoryLimit.get(fp.getUserName()) <= 0)
						continue;

					if (facAllotedHours.get(fp.getUserName()) >= facLimits.get(fp.getUserName())[1])
						continue;

					if (c.getFacultyId().equals("")) {

						if (facAllotedHours.get(fp.getUserName())
								+ c.getNoOfHours() <= facLimits.get(fp.getUserName())[1]) {
//							System.out.println("Alloting course "+c.getCourseId()+" "+c.getDivisionId()+" to "+fp.getUserName());
							c.setFacultyId(fp.getUserName());
							facAllotedHours.replace(fp.getUserName(),
									facAllotedHours.get(fp.getUserName()) + c.getNoOfHours());
							facLoadLeft.replace(fp.getUserName(), facLoadLeft.get(fp.getUserName()) - c.getNoOfHours());
							if (courseFacs.get(c.getCourseId()) == null) {
								LinkedHashSet<String> temp = new LinkedHashSet<>();
								temp.add(fp.getUserName());
								courseFacs.put(c.getCourseId(), temp);
							} else {
								courseFacs.get(c.getCourseId()).add(fp.getUserName());
							}
							facTheoryHours.replace(fp.getUserName(),
									facTheoryHours.get(fp.getUserName()) + c.getNoOfHours());

							facTheoryLimit.put(fp.getUserName(), facTheoryLimit.get(fp.getUserName()) - 1);
						}
					}

					if (facAllotedHours.get(fp.getUserName()) >= facLimits.get(fp.getUserName())[1])
						continue;
					if (pracListptrs != null && pracAllotCounter < pracListptrs.size())
						for (int i : pracListptrs) {

							PracticalList p = practicalList.get(i);
//							System.out.println("Checking for prac "+p.getTheoryCourseId()+" "+p.getPracticalCourseId()+" "+p.getLabId());
							if (p.getFacultyId().equals("")) {

								if (facAllotedHours.get(fp.getUserName())
										+ p.getNoOfHours() <= facLimits.get(fp.getUserName())[1]) {
									System.out.println("Alloting practical " + p.getPracticalCourseId() + " "
											+ p.getLabId() + " to " + fp.getUserName());
									pracAllotCounter++;
									p.setFacultyId(fp.getUserName());
									facAllotedHours.replace(fp.getUserName(),
											facAllotedHours.get(fp.getUserName()) + p.getNoOfHours());
									facLoadLeft.replace(fp.getUserName(),
											facLoadLeft.get(fp.getUserName()) - p.getNoOfHours());
									facPracticalHours.replace(fp.getUserName(),
											facPracticalHours.get(fp.getUserName()) + p.getNoOfHours());

								}
							}
						}
				}
			}
		}

		// allocate remaining pracs for last courseID
		if (!prevCourse.equals("")) {
			List<Integer> pracListptrs = practicalListPointer.get(prevCourse);
			LinkedHashSet<String> facs = courseFacs.get(prevCourse);
			if (pracListptrs != null && facs != null)
				for (int i : pracListptrs) {

					PracticalList p = practicalList.get(i);

					if (p.getFacultyId().equals("")) {
						for (String fId : facs) {
							if (facAllotedHours.get(fId) + p.getNoOfHours() <= facLimits.get(fId)[1]) {
								p.setFacultyId(fId);
								// System.out.println(p.getFacultyId());
								facAllotedHours.replace(fId, facAllotedHours.get(fId) + p.getNoOfHours());
								facLoadLeft.replace(fId, facLoadLeft.get(fId) - p.getNoOfHours());
								facPracticalHours.replace(fId, facPracticalHours.get(fId) + p.getNoOfHours());
							}
						}
					}
				}
		}

		ArrayList<Integer> temp = new ArrayList<>();
		int facLimitReached = 0;

		int ind = 0;
		for (CourseList c : courseList) {
			if(c.getFacultyId().isEmpty())
				{
					nonPreferredCourseIndices.add(ind);
				}
				
			ind++;
		}
		
		// for each unpreferred course, find fac with lowest load and allocate
		for (int i : nonPreferredCourseIndices) {
			// find fac with highest load left and allocate
			int ll = Integer.MIN_VALUE;
			String bestFac = null;

			for (Entry<String, Integer> fac : facLoadLeft.entrySet()) {
				if (fac.getValue() > ll) {
					ll = fac.getValue();
					bestFac = fac.getKey();
				}
			}
			if (bestFac == null) {
				// No faculty has load left
				facLimitReached = 1;
				break;
			}

			CourseList c = courseList.get(i);

			if (facTheoryLimit.get(bestFac) <= 0)
				continue;

			if (facLoadLeft.get(bestFac) >= c.getNoOfHours()) {
				// allocate
				c.setFacultyId(bestFac);
				facAllotedHours.replace(bestFac, facAllotedHours.get(bestFac) + c.getNoOfHours());
				facLoadLeft.replace(bestFac, facLoadLeft.get(bestFac) - c.getNoOfHours());
				temp.add(i);
				facTheoryHours.replace(bestFac, facTheoryHours.get(bestFac) + c.getNoOfHours());

				facTheoryLimit.put(bestFac, facTheoryLimit.get(bestFac) - 1);
			}
			List<Integer> pracListptrs = practicalListPointer.get(c.getCourseId());
			if (pracListptrs != null)
				for (int pIndex : pracListptrs) {
					PracticalList p = practicalList.get(pIndex);
					if (p.getFacultyId().equals("")) {
						if (facLoadLeft.get(bestFac) >= p.getNoOfHours()) {
							p.setFacultyId(bestFac);
							// System.out.println(p.getFacultyId());
							facAllotedHours.replace(bestFac, facAllotedHours.get(bestFac) + p.getNoOfHours());
							facLoadLeft.replace(bestFac, facLoadLeft.get(bestFac) - p.getNoOfHours());
							facPracticalHours.replace(bestFac, facPracticalHours.get(bestFac) + p.getNoOfHours());
						}
					}
				}
		}

		// remove alloted non-preferred courses from list
		for (int i : temp) {
			nonPreferredCourseIndices.remove(new Integer(i));
		}
		
		for(int i:nonPreferredCourseIndices) {
			CourseList p = courseList.get(i);
			
			if (p.getFacultyId().equals("")) {
				String bestFac = null;
				int ll = Integer.MIN_VALUE;
				System.out.println("Finding fac for " + p.getCourseId());
				// find fac with highest load left and allocate
				for (Entry<String, Integer> fac : facLoadLeft.entrySet()) {
					if (fac.getValue() > ll) {
						ll = fac.getValue();
						bestFac = fac.getKey();
					}
				}
				if (bestFac == null) {
					facLimitReached = 1;
					break;
				}
				if (facTheoryLimit.get(bestFac) <= 0)
					continue;
				if (facLoadLeft.get(bestFac) >= p.getNoOfHours()) {
					p.setFacultyId(bestFac);
					facAllotedHours.replace(bestFac, facAllotedHours.get(bestFac) + p.getNoOfHours());
					facLoadLeft.replace(bestFac, facLoadLeft.get(bestFac) - p.getNoOfHours());
					facTheoryHours.replace(bestFac, facTheoryHours.get(bestFac) + p.getNoOfHours());
				} else {
					// increment bestFac max limit
					System.out.println("Incrementing for " + bestFac);
					p.setFacultyId(bestFac);
					int newHrs = facAllotedHours.get(bestFac) + p.getNoOfHours();
					facAllotedHours.replace(bestFac, newHrs);
					facLoadLeft.replace(bestFac, 0);
					facTheoryHours.replace(bestFac, facTheoryHours.get(bestFac) + p.getNoOfHours());
					facLimits.put(bestFac, new int[] { facLimits.get(bestFac)[0], newHrs });
					System.out.println("Hours " + newHrs);
				}
			}
			
		}
		// allot to all remaining pracs
		for (PracticalList p : practicalList) {

			if (p.getFacultyId().equals("")) {
				String bestFac = null;
				int ll = Integer.MIN_VALUE;
				System.out.println("Finding fac for " + p.getPracticalCourseId());
				// find fac with highest load left and allocate
				for (Entry<String, Integer> fac : facLoadLeft.entrySet()) {
					if (fac.getValue() > ll) {
						ll = fac.getValue();
						bestFac = fac.getKey();
					}
				}
				if (bestFac == null) {
					facLimitReached = 1;
					break;
				}
				if (facLoadLeft.get(bestFac) >= p.getNoOfHours()) {
					p.setFacultyId(bestFac);
					facAllotedHours.replace(bestFac, facAllotedHours.get(bestFac) + p.getNoOfHours());
					facLoadLeft.replace(bestFac, facLoadLeft.get(bestFac) - p.getNoOfHours());
					facPracticalHours.replace(bestFac, facPracticalHours.get(bestFac) + p.getNoOfHours());
				} else {
					// increment bestFac max limit
					System.out.println("Incrementing for " + bestFac);
					p.setFacultyId(bestFac);
					int newHrs = facAllotedHours.get(bestFac) + p.getNoOfHours();
					facAllotedHours.replace(bestFac, newHrs);
					facLoadLeft.replace(bestFac, 0);
					facPracticalHours.replace(bestFac, facPracticalHours.get(bestFac) + p.getNoOfHours());
					facLimits.put(bestFac, new int[] { facLimits.get(bestFac)[0], newHrs });
					System.out.println("Hours " + newHrs);
				}
			}
		}
		if (facLimitReached == 1) {
			System.out.println("All facs have reached limit");
		}

		int exceptCase = 0;
		if (allFacs.size() > courseList.size()) {
			exceptCase = 1;
		}

		if (exceptCase == 0) {
			// Find and allocate th-courses to faculties with 0 alloted theory courses
			for (Entry<String, Integer> fac : facTheoryLimit.entrySet()) {
				if (fac.getValue() == 2) {
					System.out.println("fac " + fac.getKey());

					ArrayList<FacultyPref> fprefs = facultyPrefRepository.findByUserName(fac.getKey());

					Collections.sort(fprefs, new FacultyPrefChainedComparator(new FacultyPrefNoComparator()));
					String prefCourse;

					int flag = 0;

					for (FacultyPref fp : fprefs) {
						prefCourse = fp.getCourseId();
						if (prefCourse == null) {
							prefCourse = fp.getElectiveId();
						}
						String borrowFromFac = null;
						CourseList toBorrow = null;
						HashMap<String, Integer> borrowFromFacList = new HashMap<>();
						for (CourseList c : courseList) {
							if (c.getCourseId().equals(prefCourse)) {
								if (borrowFromFacList.containsKey(c.getFacultyId())) {
									borrowFromFac = c.getFacultyId();
									c.setFacultyId(fac.getKey());
									facAllotedHours.put(borrowFromFac,
											facAllotedHours.get(borrowFromFac) - c.getNoOfHours());
									facTheoryHours.put(borrowFromFac,
											facTheoryHours.get(borrowFromFac) - c.getNoOfHours());
									facLoadLeft.put(borrowFromFac, facLoadLeft.get(borrowFromFac) + c.getNoOfHours());

									facAllotedHours.put(fac.getKey(),
											facAllotedHours.get(fac.getKey()) + c.getNoOfHours());
									facTheoryHours.put(fac.getKey(),
											facTheoryHours.get(fac.getKey()) + c.getNoOfHours());
									facLoadLeft.put(fac.getKey(), facLoadLeft.get(fac.getKey()) - c.getNoOfHours());

									int hoursToReplace = c.getNoOfHours();

									for (PracticalList p : practicalList) {
										if (hoursToReplace > 0) {

											if (p.getFacultyId().equals(fac.getKey())) {
												p.setFacultyId(borrowFromFac);
												facAllotedHours.put(borrowFromFac,
														facAllotedHours.get(borrowFromFac) + p.getNoOfHours());
												facPracticalHours.put(borrowFromFac,
														facPracticalHours.get(borrowFromFac) + p.getNoOfHours());
												facLoadLeft.put(borrowFromFac,
														facLoadLeft.get(borrowFromFac) - p.getNoOfHours());

												facAllotedHours.put(fac.getKey(),
														facAllotedHours.get(fac.getKey()) - p.getNoOfHours());
												facPracticalHours.put(fac.getKey(),
														facPracticalHours.get(fac.getKey()) - p.getNoOfHours());
												facLoadLeft.put(fac.getKey(),
														facLoadLeft.get(fac.getKey()) + p.getNoOfHours());

												hoursToReplace -= p.getNoOfHours();
											}
										} else {
											break;
										}
									}
									break;
								} else
									borrowFromFacList.put(c.getFacultyId(), 1);

							}
						}

						if (borrowFromFac != null) {
							flag = 1;
							break;
						}

					}
					if (flag == 0) {

						String borrowFromFac;

						for (Entry<String, Integer> fac1 : facTheoryLimit.entrySet()) {
							if (fac1.getValue() == 0) {

								for (CourseList c : courseList) {
									if (c.getFacultyId().equals(fac1.getKey())) {
										borrowFromFac = fac1.getKey();
										c.setFacultyId(fac.getKey());
										facAllotedHours.put(borrowFromFac,
												facAllotedHours.get(borrowFromFac) - c.getNoOfHours());
										facTheoryHours.put(borrowFromFac,
												facTheoryHours.get(borrowFromFac) - c.getNoOfHours());
										facLoadLeft.put(borrowFromFac,
												facLoadLeft.get(borrowFromFac) + c.getNoOfHours());

										facAllotedHours.put(fac.getKey(),
												facAllotedHours.get(fac.getKey()) + c.getNoOfHours());
										facTheoryHours.put(fac.getKey(),
												facTheoryHours.get(fac.getKey()) + c.getNoOfHours());
										facLoadLeft.put(fac.getKey(), facLoadLeft.get(fac.getKey()) - c.getNoOfHours());

										int hoursToReplace = c.getNoOfHours();

										for (PracticalList p : practicalList) {
											if (hoursToReplace > 0) {

												if (p.getFacultyId().equals(fac.getKey())) {
													p.setFacultyId(borrowFromFac);
													facAllotedHours.put(borrowFromFac,
															facAllotedHours.get(borrowFromFac) + p.getNoOfHours());
													facPracticalHours.put(borrowFromFac,
															facPracticalHours.get(borrowFromFac) + p.getNoOfHours());
													facLoadLeft.put(borrowFromFac,
															facLoadLeft.get(borrowFromFac) - p.getNoOfHours());

													facAllotedHours.put(fac.getKey(),
															facAllotedHours.get(fac.getKey()) - p.getNoOfHours());
													facPracticalHours.put(fac.getKey(),
															facPracticalHours.get(fac.getKey()) - p.getNoOfHours());
													facLoadLeft.put(fac.getKey(),
															facLoadLeft.get(fac.getKey()) + p.getNoOfHours());

													hoursToReplace -= p.getNoOfHours();
												}
											}
										}
									}

									else {
										break;
									}
								}

							}
						}
					}

				}

			}
		}

		
		  

		System.out.println("FacGroups"); 
		for (Entry<String, LinkedHashSet<String>>fac : courseFacs.entrySet()) {
			System.out.println(fac.getKey() + " "+fac.getValue().toString()); 
			}

		System.out.println("course list");
		System.out.println("courseID divisionID facID noOfHrs"); 
		
		
		
		for(CourseList c:courseList) { courseListRepository.save(c); if(c.getFacultyId().equals(""))
				{ System.out.println(c.getCourseId()+" "+c.getDivisionId()+" NA "+c.
						getNoOfHours()); } else {
							System.out.println(c.getCourseId()+" "+c.getDivisionId()+" "+c.getFacultyId()
							+" "+c.getNoOfHours()); } }

		System.out.println("practical list");
		System.out.println("courseID labID  practicalID facID noOfHrs");

		for(PracticalList p:practicalList) { practicalListRepository.save(p);
		if(p.getFacultyId().equals(""))
			System.out.println(p.getTheoryCourseId()+" "+p.getLabId()+" "+p.
					getPracticalCourseId()+" NA "+p.getNoOfHours()); else
						System.out.println(p.getTheoryCourseId()+" "+p.getLabId()+" "+p.
								getPracticalCourseId()+" "+p.getFacultyId()+" "+p.getNoOfHours()); }

		FacultyAllotedHours fh = new FacultyAllotedHours();
		System.out.println("\n\nFac Details");
		System.out.println("FacID  facMax facAlloted facLoadLeft"); int
		totalLoadLeft=0,totalLoadAlloted=0,maxLoad=0; for (Entry<String, int[]> fac :
			facLimits.entrySet()) { System.out.println(fac.getKey() + " "+
					fac.getValue()[1] + " "+ facAllotedHours.get(fac.getKey()) + " " +
					facLoadLeft.get(fac.getKey()) );
			totalLoadLeft+=facLoadLeft.get(fac.getKey()); maxLoad+=fac.getValue()[1];
			totalLoadAlloted+=facAllotedHours.get(fac.getKey());
			fh.setFacultyId(fac.getKey()); fh.setMaxHours(fac.getValue()[1]);
			fh.setAllotedHours(facAllotedHours.get(fac.getKey()));
			fh.setTheoryHours(facTheoryHours.get(fac.getKey()));
			fh.setPracticalHours(facPracticalHours.get(fac.getKey()));
			facultyAllotedHoursRepository.save(fh); }

		System.out.println("Total hrs to be alloted: "+totalCourseHours);
		System.out.println("MaxLoad: "+maxLoad+" TotalLoadAlloted: "
				+totalLoadAlloted+" TotalLoadLeft: "+totalLoadLeft);

		
		System.out.println("Lets count the preferences for each faculty!");
		
		HashMap<String,ArrayList<String>> allotedCourses = new HashMap<String, ArrayList<String>>();
		for(CourseList c:courseList) {
			if(allotedCourses.containsKey(c.getFacultyId())) {
				allotedCourses.get(c.getFacultyId()).add(c.getCourseId());
			}else {
				ArrayList<String> ac = new ArrayList<>();
				ac.add(c.getCourseId());
				allotedCourses.put(c.getFacultyId(),ac);
			}
		}
		
		HashMap<String, ArrayList<FacultyPref>> prefsPerFac = new HashMap<>();
		
		HashMap<String,ArrayList<Integer>> prefSatisfaction = new HashMap<>(); 
		
		for(FacultyAcad f:allFacs) {
			ArrayList<FacultyPref> fprefs = facultyPrefRepository.findByUserName(f.getUserName());
			prefsPerFac.put(f.getUserName(),fprefs);
			
			int prefNo = 100;
			ArrayList<Integer> aprefNo = new ArrayList<Integer>();
			
			for(String s:allotedCourses.get(f.getUserName())) {
				for(FacultyPref fp:fprefs) {
					if((fp.getCourseId()!=null && fp.getCourseId().equals(s)) || (fp.getElectiveId()!=null && fp.getElectiveId().equals(s))){
						if(prefNo>fp.getPrefNo()) {
							prefNo = fp.getPrefNo();
							aprefNo.add(prefNo);
							break;
						}
					}
				}
			}
			
			prefSatisfaction.put(f.getUserName(), aprefNo);
			System.out.println("Faculty: "+f.getUserName()+" pref No: "+prefNo);
		}
		
		System.out.println("Faculty satisfaction summary: ");
		float satisPercent;

		float t = 0;
		int divBy = 8;
		if(isSemOdd==0) {
			divBy=7;
		}
		for(int i=1;i<9;i++) {
			int cnt = 0;
			for (Entry<String, ArrayList<Integer>> fac1 : prefSatisfaction.entrySet()) {
				
				for(Integer p:fac1.getValue()) {
					if(p==i) {
						cnt++;
						//t += 1-i/prefsPerFac.get(fac1.getKey()).size();
						t += 1-i/divBy;
					}
				}
			}
			
			System.out.println("Pref No "+i+" : "+cnt);
			
		}
		System.out.println("t: "+t);
		satisPercent = t/courseList.size();
		System.out.println("Average Satisfaction Percentage: "+satisPercent*100);
		
		
	}

	@GetMapping("/getfacultyAllocationPage")
	public ModelAndView getFacAllocationPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/facultyAllocation");
		departments = departmentRepository.findAll();
		model.addObject("departments", departments);
		return model;
	}

	@RequestMapping(value = "/showFacultyAllocation", method = RequestMethod.POST)
	public ModelAndView showFacultyAllocation(String dept) {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/facultyAllocation");
		departments = departmentRepository.findAll();
		model.addObject("departments", departments);

		Department d = departmentRepository.findByDeptId(dept);
		List<FacultyAllotedHours> facs = facultyAllotedHoursRepository.findFacsByDepartment(d);
		if (facs.isEmpty()) {
			model.addObject("err_msg", "Allocation has not been performed for " + d.getDeptName());
		} else {
			List<FacultyAllocations> facAllocs = generateFacultyAllotedList(d);
			Collections.sort(facAllocs, new FacultyAllocationsChainedComparator(new AlphaNumericalComparator()));
			model.addObject("facAllotmentList", facAllocs);
		}
		return model;
	}

	public List<FacultyAllocations> generateFacultyAllotedList(Department dept) {
		List<FacultyAllotedHours> facs = facultyAllotedHoursRepository.findFacsByDepartment(dept);
		List<CourseList> courses = courseListRepository.findByFacultyIdDepartment(dept);
		List<PracticalList> practicals = practicalListRepository.findByFacultyIdDepartment(dept);
		rs = new ArrayList<FacultyAllocations>();

		// {key: facID, value:{key:courseId,value:courseList} }
		HashMap<String, List<CourseList>> facCourses = new HashMap<String, List<CourseList>>();
		HashMap<String, List<PracticalList>> facPracticalCourses = new HashMap<String, List<PracticalList>>();
		HashMap<String, Integer> facTheoryHours = new HashMap<String, Integer>();
		HashMap<String, Integer> facPracticalHours = new HashMap<String, Integer>();

		// init all hashmaps
		for (FacultyAllotedHours f : facs) {
			List<CourseList> cList = new ArrayList<CourseList>();
			facCourses.put(f.getFacultyId(), cList);
			facTheoryHours.put(f.getFacultyId(), 0);

			List<PracticalList> pList = new ArrayList<PracticalList>();
			facPracticalCourses.put(f.getFacultyId(), pList);
			facPracticalHours.put(f.getFacultyId(), 0);
		}

		for (CourseList c : courses) {

			facCourses.get(c.getFacultyId()).add(c);
			facTheoryHours.replace(c.getFacultyId(), facTheoryHours.get(c.getFacultyId()) + c.getNoOfHours());
		}

		for (PracticalList p : practicals) {

			facPracticalCourses.get(p.getFacultyId()).add(p);
			facPracticalHours.replace(p.getFacultyId(), facPracticalHours.get(p.getFacultyId()) + p.getNoOfHours());

		}

		for (FacultyAllotedHours f : facs) {
			Users faculty = userDetails.findByUserName(f.getFacultyId());
			FacultyAllocations fa = new FacultyAllocations();
			fa.setName(faculty.getFirstName() + " " + faculty.getLastName());
			fa.setAllotedLoad(f.getAllotedHours());
			fa.setFacultyId(f.getFacultyId());
			fa.setMaxLoad(f.getMaxHours());
			fa.setCourseAndDivs(facCourses.get(f.getFacultyId()));
			fa.setPracticalsAndBatches(facPracticalCourses.get(f.getFacultyId()));
			fa.setPracticalHours(f.getPracticalHours());
			fa.setTheoryHours(f.getTheoryHours());
			ArrayList<String> courseNames = new ArrayList<>();
			ArrayList<String> pracNames = new ArrayList<>();

			for (CourseList c : facCourses.get(f.getFacultyId())) {
				Course tempc = courseRepository.findByCourseId(c.getCourseId());
				if (tempc != null) {
					courseNames.add(tempc.getCourseName());
				} else {
					Electives tempe = electivesRepository.findByElectiveCourseId(c.getCourseId());
					courseNames.add(tempe.getElectiveName());
				}
			}

			for (PracticalList p : facPracticalCourses.get(f.getFacultyId())) {
				Course tempc = courseRepository.findByCourseId(p.getPracticalCourseId());
				System.out.println(p.getPracticalCourseId() + "   " + p.getTheoryCourseId());
				if (tempc != null) {
					pracNames.add(tempc.getCourseName());
				}
			}

			fa.setCourses(courseNames);
			fa.setPracticals(pracNames);
			rs.add(fa);
		}
		return rs;
	}

	@RequestMapping(value = "/getFacultyAllocationByIndex", method = RequestMethod.GET)
	public String getFacultyAllocationByIndex(Model model, Integer i) {
		model.addAttribute("facultyAllocation", rs.get(i - 1));
		return "admin/facultyAllocation :: viewDetailsDiv";
	}

	public static String convertTo24HoursFormat(String twelveHourTime) throws ParseException {
		return TWENTY_FOUR_TF.format(TWELVE_TF.parse(twelveHourTime));
	}

	@Transactional
	String readTT(String path, String dept, String day) {

		Department department = departmentRepository.findByDeptId(dept);

		HashMap<Integer, Time[]> timeSlots = new HashMap<>();

		File myFile = new File(path);
		FileInputStream fis;

		List<TimeTable> timetable = new ArrayList<>();

		timeTableRepository.deleteByDepartmentAndDay(department, day);

		String msg = "Time Table has been uploaded successfully.";

		try {
			fis = new FileInputStream(myFile);
			// Finds the workbook instance for XLSX file
			XSSFWorkbook myWorkBook;
			myWorkBook = new XSSFWorkbook(fis);

			// Return first sheet from the XLSX workbook
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

			Row row0 = mySheet.getRow(0);

			Iterator<Cell> c = row0.cellIterator();
			c.next();
			while (c.hasNext()) {
				Cell cNext = c.next();

				String arr[] = cNext.getStringCellValue().trim().split(" to ");
				String startTime = convertTo24HoursFormat(arr[0]);
				String endTime = convertTo24HoursFormat(arr[1]);
				DateFormat formatter = new SimpleDateFormat("HH:mm");
				timeSlots.put(cNext.getColumnIndex(), new Time[] { new Time(formatter.parse(startTime).getTime()),
						new Time(formatter.parse(endTime).getTime()) });
			}

			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = mySheet.iterator();

			rowIterator.next();

			// Traversing over each row of XLSX file
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Cell cprev = row.cellIterator().next();
				String div = cprev.getStringCellValue().trim();

				if (cprev.getStringCellValue().equals("END") || cprev.getStringCellValue().equals("")
						|| cprev.getCellType() == Cell.CELL_TYPE_BLANK) {
					break;
				}

				for (int i : timeSlots.keySet()) {

					Time[] slot = timeSlots.get(i);
					if (row.getCell(i) == null) {

					} else if (row.getCell(i).getStringCellValue().equals("")
							|| row.getCell(i).getCellType() == Cell.CELL_TYPE_BLANK) {

					} else {
						String delim = " \n\t";
						StringTokenizer st = new StringTokenizer(row.getCell(i).getStringCellValue().trim(), delim);
						int j = 1;
						while (st.hasMoreTokens()) {
							String activityName = "Time Table";
							if (j == 1) {
								activityName = st.nextToken().trim();
								activityName = activityName.concat(" (" + div + ")");
								j++;
							}
							if (j == 2) {

								String str = st.nextToken().trim();
								if (str.contains(",")) {
									String[] temp = str.split(",");
									for (String temps : temp) {
										Resource r = resourceRepository.findByResourceId(dept.concat(temps));
										timetable.add(new TimeTable(slot[0], slot[1], r, day, department,
												r.getResourceIncharge(), activityName));
									}
								} else {
									Resource r = resourceRepository.findByResourceId(dept.concat(str));
									System.out.println("resource-" + r.getResourceId());
									timetable.add(new TimeTable(slot[0], slot[1], r, day, department,
											r.getResourceIncharge(), activityName));
								}
								j = 0;
							} else {
								if (st.hasMoreTokens()) {
									st.nextToken();
								}
								j++;
							}
						}
					}
				}
			}

			for (TimeTable tt : timetable) {
				timeTableRepository.save(tt);
			}

			myWorkBook.close();

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Uploaded timetable is in incorrect format.";
			myFile.delete();
			return msg;
		}
		myFile.delete();
		return msg;
	}

	@RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
	public ModelAndView getViewSchedule() {
		ModelAndView model = new ModelAndView();
		ArrayList<Department> depts = bookingsService.listDepartments();
		model.addObject("departments", depts);

		model.setViewName("/admin/viewSchedule");
		return model;
	}

	@RequestMapping(value = "/getScheduleForResource", method = RequestMethod.GET)
	public String getScheduleForResource(Model model, String getTT, String cur_date) {

		List<TimeSlots> list = bookingsService.getTimeSlotsForDate(cur_date, getTT);

		if (list.size() == 0) {
			model.addAttribute("msg", "All slots are empty!");
			return "admin/viewSchedule:: messageDiv";
		} else {
			model.addAttribute("ttForResource", list);
			return "admin/viewSchedule:: resourceTT";
		}
	}

	@RequestMapping(value = "/getTTForResourceForDate", method = RequestMethod.POST)
	public String getTTForResourceForDate(Model model, String booking_date, String getTT) {
		System.out.println("hello :)" + booking_date + getTT);

		List<TimeSlots> list = bookingsService.getTimeSlotsForDate(booking_date, getTT);

		if (list.isEmpty()) {
			model.addAttribute("msg", "All slots are empty!");
			return "admin/viewSchedule:: messageDiv";
		} else {
			model.addAttribute("ttForResource", list);
			return "admin/viewSchedule:: resourceTT";
		}
	}

	@RequestMapping(value = "/getViewOptions", method = RequestMethod.POST)
	public String getViewOptions(Model model, String dept, String rType, Integer minSeats) {

		if (minSeats == null) {
			minSeats = 0;
		}
		ArrayList<Resource> options = bookingsService.listResourcesByDepartmentAndRTypeAndMinSeats(dept, rType,
				minSeats);

		if (options.isEmpty()) {
			model.addAttribute("err_msg", "No suitable rooms/halls/classrooms were found.");
			return "admin/viewSchedule:: messageDiv";
		} else {
			model.addAttribute("options", options);
			return "admin/viewSchedule:: resourceOptionsTable";
		}
	}

}
