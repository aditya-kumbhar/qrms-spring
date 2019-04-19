package com.qrms.spring.resource;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.FacultyPref;
import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeSlots;
import com.qrms.spring.model.TimeTable;
import com.qrms.spring.model.Course;
import com.qrms.spring.model.CoursePrerequisites;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.CourseAndElectives;
import com.qrms.spring.queryBeans.FacPrefsList;
import com.qrms.spring.repository.CoursePrerequisitesRepository;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
import com.qrms.spring.repository.TimeSlotsRepository;
import com.qrms.spring.service.BookingsService;
import com.qrms.spring.service.BookingsServiceImpl;
import com.qrms.spring.repository.FacultyAcadRepository;


@Controller
@RequestMapping("/u/faculty")
public class FacultyController {
	
	@Autowired
	private FacultyPrefRepository facultyPrefRepository;
	
	@Autowired
	private FacultyAcadRepository facultyAcadRepository;
	
	@Autowired
	private ElectivesRepository electivesRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CoursePrerequisitesRepository coursePrerequisitesRepository;
	
	@Autowired
	private BookingsServiceImpl bookingsService;
	
	@GetMapping("/home")
	public String facultyHome() {
		return "faculty/home";
	}
	
	@RequestMapping(value = "/viewTT",method = RequestMethod.GET)
	public ModelAndView viewTT() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/faculty/viewTT");
		return model;
	}
	
	@RequestMapping(value = "/givePreferenceChoice", method = RequestMethod.GET)
	public ModelAndView facultyPref(String msg) {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		
		FacultyAcad currUserAcad = facultyAcadRepository.findByUserName(userName);
		
		ArrayList <FacultyPref> facultyPrefs = facultyPrefRepository.findByUserName(currUserAcad.getUserName());
		if(facultyPrefs.size()!=0) 
		{
			model.addObject("pref_submitted_msg","You have already submitted your preferences. Please wait until allocation process takes place.");
		}
		
		model.setViewName("/faculty/facultyPref");
		return model;
	}
	
	@RequestMapping(value = "/getFacPrefForm", method = RequestMethod.GET)
	public String getFacPrefForm(Model model, String year) {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(year);
		
		FacultyAcad currUserAcad = facultyAcadRepository.findByUserName(userName);
		
		//ArrayList <FacultyPref> facultyPrefs = facultyPrefRepository.findByUserNameAndYear(currUserAcad.getUserName(),year);
		
		ArrayList<CourseAndElectives> resultSet = new ArrayList<CourseAndElectives>() ;
		//change later when admin gives current Sem input
		ArrayList<Course> regCourses = courseRepository.findByCourseYearAndCourseTypeAndDepartment(year,'R', currUserAcad.getDepartment());
		ArrayList<Course> elCourses = courseRepository.findByCourseYearAndCourseTypeAndDepartment(year,'E', currUserAcad.getDepartment());
		
		if(regCourses.isEmpty() && elCourses.isEmpty())
		{
			model.addAttribute("err_msg","No courses found for the selected year");
			return "faculty/facultyPref :: messageDiv";
		}
		else {
			for(Course elCourse: elCourses) {
				ArrayList<Electives> electives = electivesRepository.findByCourse(elCourse);
				
				for(Electives el: electives) {
					System.out.println(elCourse.getCourseId());
					CoursePrerequisites cp = coursePrerequisitesRepository.findByCourseId(el.getElectiveCourseId());
					CourseAndElectives ce = new CourseAndElectives();

					if(cp == null) {
						ce.setPreReq1("NA");
						ce.setPreReq2("NA");
					}
					else {
						String prereq1,prereq2;
						
						if(cp.getIsPrereq1Elective() == 1)
							prereq1 = electivesRepository.findByElectiveCourseId(cp.getPrerequisiteNo1()).getElectiveName();				
						else if(cp.getIsPrereq1Elective() == 0)
							prereq1 = courseRepository.findByCourseId(cp.getPrerequisiteNo1()).getCourseName();
						else
							prereq1 = "NA";	
						
						if(cp.getIsPrereq2Elective() == 1)
							prereq2 = electivesRepository.findByElectiveCourseId(cp.getPrerequisiteNo2()).getElectiveName();				
						else if(cp.getIsPrereq1Elective() == 0)
							prereq2 = courseRepository.findByCourseId(cp.getPrerequisiteNo2()).getCourseName();
						else
							prereq2="NA";
					
						ce.setPreReq1(prereq1);
						ce.setPreReq2(prereq2);						
					}
					
					ce.setCourse(elCourse);
					ce.setElective(el);
							
					resultSet.add(ce);
					
				}				
			}
			for(Course regCourse: regCourses) {
				CourseAndElectives ce = new CourseAndElectives();
				CoursePrerequisites cp = coursePrerequisitesRepository.findByCourseId(regCourse.getCourseId());
				if(cp == null) {
					ce.setPreReq1("NA");
					ce.setPreReq2("NA");
				}
				else {
					String prereq1,prereq2;
					
					if(cp.getIsPrereq1Elective() == 1)
						prereq1 = electivesRepository.findByElectiveCourseId(cp.getPrerequisiteNo1()).getElectiveName();				
					else if(cp.getIsPrereq1Elective() == 0)
						prereq1 = courseRepository.findByCourseId(cp.getPrerequisiteNo1()).getCourseName();
					else
						prereq1="NA";
					if(cp.getIsPrereq2Elective() == 1)
						prereq2 = electivesRepository.findByElectiveCourseId(cp.getPrerequisiteNo2()).getElectiveName();				
					else if(cp.getIsPrereq1Elective() == 0)
						prereq2 = courseRepository.findByCourseId(cp.getPrerequisiteNo2()).getCourseName();	
					else
						prereq2="NA";
					
					ce.setPreReq1(prereq1);
					ce.setPreReq2(prereq2);						
				}
				ce.setCourse(regCourse);			
				resultSet.add(ce);				
			}
		}
		model.addAttribute("resultSet",resultSet);
		
		return "faculty/facultyPref :: selectPreferenceFragment";
	}
	
	@ResponseBody
	@RequestMapping(value = "/givePreference", method = RequestMethod.GET)
	public String givePreference(Model model, String selectPref, int courseExp, int prereq1Exp, int prereq2Exp) {
		//Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(selectPref);
		
		return selectPref;
	}
	
	//--------------------------------------------------------------------------------------
	//MODIFY THIS
	//--------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value = "/setFacPrefs", method = RequestMethod.POST)
	public String setFacPreferences(Model model, @RequestBody FacPrefsList facultyPrefs ) {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		List<FacultyPref> prefArray = facultyPrefs.getFacultyPrefs();
		
		for(FacultyPref fp : prefArray) {
			fp.setUserName(userName);
			
			Course c = courseRepository.findByCourseId(fp.getCourseId());
			if(c==null)
			{
				fp.setElectiveId(fp.getCourseId());
				fp.setCourseId(null);
			}
			else
			{
				fp.setElectiveId(null);
			}
			facultyPrefRepository.save(fp);
		}
		
		return "success";
		
	}
	
	/*
	@RequestMapping(value = "/getFacultyPrefs", method = RequestMethod.GET)
	public ModelAndView studentPref(String year) {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		
		FacultyAcad currUserAcad = facultyAcadRepository.findByUserName(userName);
		
		ArrayList <StudentPref> facultyPrefs = facultyPrefRepository.findByUserNameAndYear(currUserAcad.getUserName(),year);
		if(facultyPrefs.size()!=0) 
			return facultyPref("Your preferences for chosen elective have been recorded already!");
		else {
			ArrayList<Course> chosen_year_courses = courseRepository.findByCourseYear(year);
//			ArrayList<Electives> electiveList = electivesRepository.findByCourse(chosen_year); 
//			if(electiveList.size()==0) {
//				System.out.println("No courses exist");
//				String msg = "Please choose other elective-id!";
//				return getElectiveId(msg);
//			}
		
//			ArrayList<Course> elective_ids = courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(currUserAcad.getSem(),currUserAcad.getYear(),'R',currUserAcad.getDepartment(),1,1);
//			model.addObject("chosen_course_name",chosen_course.getCourseName());
//			model.addObject("chosen_course_id",chosen_course.getCourseId());
//			model.addObject("elective_ids",elective_ids);
//			model.addObject("studentPref",new StudentPref());
//			model.addObject("courseList", electiveList);
//			model.setViewName("student/studentPref");
			return model;
		}
		
		
	}*/
	
	
	@RequestMapping(value="/bookings",method=RequestMethod.GET)
	public ModelAndView getRequirements() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/faculty/bookings");
		ArrayList<Department> depts = bookingsService.listDepartments();
		model.addObject("departments", depts);
		return model;
	}
	
	@RequestMapping(value="/getOptions",method=RequestMethod.POST)
	public String setRequirements(Model model,String dept,String rType,Integer minSeats) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("/faculty/bookings");
//		ArrayList<Department> depts = bookingsService.listDepartments();
//		model.addObject("departments", depts);
		
		System.out.println(dept+" "+rType+" "+minSeats);
		ArrayList<Resource> options = bookingsService.listResourcesByDepartmentAndRTypeAndMinSeats(dept, rType, minSeats);
		System.out.println("ok2"+" "+options.size());
		
		
		if(options.isEmpty()) {
			model.addAttribute("err_msg","No suitable rooms/halls/classrooms were found.");
			return "faculty/bookings:: messageDiv";
		}
		else {
			model.addAttribute("options",options);
			return "faculty/bookings:: resourceOptionsTable";
		}
	}
	
	@RequestMapping(value="/getTTForResource", method=RequestMethod.GET)
	public String getTTForResource(Model model,String getTT){
		System.out.println("resource = "+getTT);
		

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse("2019-04-08", df);
		Date sqlDate = java.sql.Date.valueOf(date.toString());
		String day = date.getDayOfWeek().name();
		
		Collection <TimeSlots> ts = bookingsService.findTimeSlotsByResourceForDate(getTT,day,sqlDate);
		
		List<TimeSlots> list;
		if (ts instanceof List)
		  list = (List<TimeSlots>)ts;
		else
		  list = new ArrayList<TimeSlots>(ts);
		
		Collections.sort(list);
		
		if(ts.isEmpty()) {
			model.addAttribute("err_msg","No Slots are booked!");
			return "faculty/bookings:: messageDiv";
		}else {
			System.out.println(list.size());
			for(TimeSlots tss:ts)
				System.out.println(tss.getStartTime());
			model.addAttribute("ttForResource",list);
			return "faculty/bookings:: resourceTT";
		}
	}
	
	@RequestMapping(value="/getTTForResourceForDate",method=RequestMethod.POST)
	public String getTTForResourceForDate(Model model,String booking_date,String getTT)
	{
		System.out.println("hello :)"+booking_date+getTT);
		
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(booking_date, df);
		Date sqlDate = java.sql.Date.valueOf(date.toString());
		String day = date.getDayOfWeek().name();
		
		Collection <TimeSlots> ts = bookingsService.findTimeSlotsByResourceForDate(getTT,day,sqlDate);
		
		List<TimeSlots> list;
		if (ts instanceof List)
		  list = (List<TimeSlots>)ts;
		else
		  list = new ArrayList<TimeSlots>(ts);
		
		Collections.sort(list);
		
		if(ts.isEmpty()) {
			model.addAttribute("err_msg","No Slots are booked!");
			return "faculty/bookings:: messageDiv";
		}else {
			System.out.println(list.size());
			for(TimeSlots tss:ts)
				System.out.println(tss.getStartTime());
			model.addAttribute("ttForResource",list);
			return "faculty/bookings:: resourceTT";
		}
		
	}
}