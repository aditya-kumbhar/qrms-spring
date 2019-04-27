package com.qrms.spring.resource;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.FacultyPref;
import com.qrms.spring.model.OpenFacultyPrefs;
import com.qrms.spring.model.PracticalList;
import com.qrms.spring.model.Resource;
import com.qrms.spring.model.ResourceRequests;
import com.qrms.spring.model.TimeSlots;
import com.qrms.spring.model.TimeTable;
import com.qrms.spring.model.Course;
import com.qrms.spring.model.CourseList;
import com.qrms.spring.model.CoursePrerequisites;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.FacultyAllotedHours;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.CourseAndElectives;
import com.qrms.spring.queryBeans.FacPrefsList;
import com.qrms.spring.queryBeans.FacultyAllocations;
import com.qrms.spring.repository.CourseListRepository;
import com.qrms.spring.repository.CoursePrerequisitesRepository;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
import com.qrms.spring.repository.OpenFacultyPrefsRepository;
import com.qrms.spring.repository.PracticalListRepository;
import com.qrms.spring.repository.ResourceRepository;
import com.qrms.spring.repository.ResourceRequestsRepository;
import com.qrms.spring.repository.TimeSlotsRepository;
import com.qrms.spring.repository.TimeTableRepository;
import com.qrms.spring.service.BookingsServiceImpl;
import com.qrms.spring.service.EmailServiceImpl;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.FacultyAllotedHoursRepository;


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
	
	@Autowired
	private OpenFacultyPrefsRepository openFacultyPrefsRepository;

	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	@Autowired
	private ResourceRequestsRepository resourceRequestsRepository;
	
	@Autowired
	private TimeSlotsRepository timeSlotsRepository;
	
	@Autowired
	private TimeTableRepository timeTableRepository;
	
	@Autowired
	private CourseListRepository courseListRepository;
	
	@Autowired
	private PracticalListRepository practicalListRepository;
	
	@Autowired
	private FacultyAllotedHoursRepository facultyAllotedHoursRepository;

	@Value("${spring.mail.username}")
	private String qrmsEmailId;
	
	@GetMapping("/home")
	public ModelAndView facultyHome() {
		ModelAndView model = new ModelAndView();
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		FacultyAcad facultyProfile = facultyAcadRepository.findByUserName(userName);
		if(facultyProfile!=null)
		
			{
				model.addObject("facultyProfile", facultyProfile);
				
				FacultyAllocations fa = new FacultyAllocations();
				
				FacultyAllotedHours fac = facultyAllotedHoursRepository.findByFacultyId(userName);
				
				if(fac!=null) {
					List<CourseList> courses = courseListRepository.findByFacultyId(userName);
					List<PracticalList> practicals = practicalListRepository.findByFacultyId(userName);
					
					int facTheoryHours = 0;
					for(CourseList c:courses) {
						facTheoryHours += c.getNoOfHours();
					}
					
					int practicalTheoryHours = 0;
					for(PracticalList p:practicals) {
						practicalTheoryHours += p.getNoOfHours();
					}
					
					fa.setAllotedLoad(fac.getAllotedHours());
					fa.setFacultyId(fac.getFacultyId());
					fa.setMaxLoad(fac.getMaxHours());
					fa.setCourseAndDivs(courses);
					fa.setPracticalsAndBatches(practicals);
					fa.setPracticalHours(practicalTheoryHours);
					fa.setTheoryHours(facTheoryHours);
					
					model.addObject("facultyAllocation", fa);
				}
				
			}
		
		model.setViewName("/faculty/home");
		
		return model;
	}
	
	@RequestMapping(value = "/givePreferenceChoice", method = RequestMethod.GET)
	public ModelAndView facultyPref(String msg) {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		FacultyAcad currUserAcad = facultyAcadRepository.findByUserName(userName);
		
		OpenFacultyPrefs ofp = openFacultyPrefsRepository.findByDeptId(currUserAcad.getDepartment().getDeptId());

		if(ofp==null) {
			model.addObject("err_msg_1","Preference forms are closed for "+currUserAcad.getDepartment().getDeptName());
			model.setViewName("/faculty/facultyPref");
			return model;
		}
		ArrayList <FacultyPref> facultyPrefs = facultyPrefRepository.findByUserName(currUserAcad.getUserName());
		if(facultyPrefs.size()!=0) 
		{
			model.addObject("err_msg_1","You have already submitted your preferences. Please wait until allocation process takes place.");
		}
		model.addObject("semType",ofp.getSemType());
		model.setViewName("/faculty/facultyPref");
		return model;
	}
	
	@RequestMapping(value = "/getFacPrefForm", method = RequestMethod.GET)
	public String getFacPrefForm(Model model, String year) {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		FacultyAcad currUserAcad = facultyAcadRepository.findByUserName(userName);
		
		//ArrayList <FacultyPref> facultyPrefs = facultyPrefRepository.findByUserNameAndYear(currUserAcad.getUserName(),year);
		OpenFacultyPrefs ofp = openFacultyPrefsRepository.findByDeptId(currUserAcad.getDepartment().getDeptId());
		System.out.println(ofp.getSemType());
		ArrayList<CourseAndElectives> resultSet = new ArrayList<CourseAndElectives>() ;
		ArrayList<Course> regCourses,elCourses;
		if(ofp.getSemType() == 0) {
			regCourses = courseRepository.findEvenSemCoursesAndCourseTypeRegAndIsTheoryAndDepartmentAndCourseYear(currUserAcad.getDepartment(),year);
			elCourses = courseRepository.findEvenSemCoursesAndCourseTypeNotRegAndIsTheoryAndDepartmentAndCourseYear(currUserAcad.getDepartment(),year);
				
		}else {
			regCourses = courseRepository.findOddSemCoursesAndCourseTypeRegAndIsTheoryAndDepartmentAndCourseYear(currUserAcad.getDepartment(),year);
			elCourses = courseRepository.findOddSemCoursesAndCourseTypeNotRegAndIsTheoryAndDepartmentAndCourseYear(currUserAcad.getDepartment(),year);
				
		}
		//change later when admin gives current Sem input
		
		if(regCourses.isEmpty() && elCourses.isEmpty())
		{
			model.addAttribute("err_msg","No courses found for the selected year");
			return "faculty/facultyPref :: messageDiv";
		}
		else {
			for(Course elCourse: elCourses) {
				ArrayList<Electives> electives = electivesRepository.findByCourse(elCourse);
				
				for(Electives el: electives) {
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
						else if(cp.getIsPrereq2Elective() == 0)
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
					else if(cp.getIsPrereq2Elective() == 0)
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
		
		if(minSeats==null) {
			minSeats=0;
		}
		ArrayList<Resource> options = bookingsService.listResourcesByDepartmentAndRTypeAndMinSeats(dept, rType, minSeats);
		
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
	public String getTTForResource(Model model,String getTT,String cur_date){
		
		List<TimeSlots> list = bookingsService.getTimeSlotsForDate(cur_date, getTT);
		
		if(list.size()==0) {
			model.addAttribute("msg","All slots are empty!");
			return "faculty/bookings:: messageDiv";
		}else {
			model.addAttribute("ttForResource",list);
			return "faculty/bookings:: resourceTT";
		}
	}
		
	@RequestMapping(value="/getTTForResourceForDate",method=RequestMethod.POST)
	public String getTTForResourceForDate(Model model,String booking_date,String getTT){
		List<TimeSlots> list = bookingsService.getTimeSlotsForDate(booking_date, getTT);
		
		if(list.isEmpty()) {
			model.addAttribute("msg","All slots are empty!");
			return "faculty/bookings:: messageDiv";
		}else {
			model.addAttribute("ttForResource",list);
			return "faculty/bookings:: resourceTT";
		}
		
	}
	
	
	@RequestMapping(value="/sendBookingRequest",method=RequestMethod.POST)
	public String sendBookingRequest(Model model,String booking_date,String resource,String startTime,String endTime,String activityName) {
		
		LocalDateTime reqTime = LocalDateTime.now();
		String reqGenTime = reqTime.getYear()+"/"+reqTime.getMonthValue()+"/"+reqTime.getDayOfMonth()+"  "+reqTime.getHour()+":"+reqTime.getMinute()+":"+reqTime.getSecond();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		FacultyAcad requestingFaculty = facultyAcadRepository.findByUserName(userName);
		
		Resource resourceObj = resourceRepository.findByResourceId(resource);
		String resourceIncharge = resourceObj.getResourceIncharge().getUserDets().getEmail();
		
		String body;
		body = "Request BY: "+requestingFaculty.getUserDets().getFirstName()+" "+requestingFaculty.getUserDets().getLastName()+"\n";
		body = body.concat("Resource: "+resource+"\n");
		body = body.concat("Slot time: "+startTime+" - "+endTime+" on "+booking_date+" for the activity \""+activityName+"\""+"\n");
		body = body.concat("Request generated on - "+reqGenTime+"\n\n\n");
		body = body.concat("Please login to your QRMS account to manage the requests!\n\nRegards,\nQRMS Team.");

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate slotDate = LocalDate.parse(booking_date, df);
		Date slotSqlDate = java.sql.Date.valueOf(slotDate.toString());
		String day = slotDate.getDayOfWeek().name();
		
		LocalDate requestDate = LocalDate.parse(reqTime.getYear()+"-"+String.format("%02d", reqTime.getMonthValue())+"-"+String.format("%02d", reqTime.getDayOfMonth()), df);
		Date requestedSqlDate = java.sql.Date.valueOf(requestDate.toString());
		
		ResourceRequests resourceRequest = new ResourceRequests();
		resourceRequest.setSlotActivityName(activityName);
		resourceRequest.setSlotDate(slotSqlDate);
		resourceRequest.setSlotDay(day);
		resourceRequest.setSlotStartTime(Time.valueOf(startTime+":00"));
		resourceRequest.setSlotEndTime(Time.valueOf(endTime+":00"));
		resourceRequest.setRequestBy(requestingFaculty);
		resourceRequest.setResourceId(resourceObj);
		resourceRequest.setRequestedDate(requestedSqlDate);
		resourceRequest.setRequestTime(Time.valueOf(reqTime.getHour()+":"+reqTime.getMinute()+":"+reqTime.getSecond()));
		
		resourceRequestsRepository.save(resourceRequest);
		
		try {
			emailServiceImpl.send(qrmsEmailId, "bmk15897@gmail.com", "QRMS: Request to book resource "+resource, body);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		model.addAttribute("msg","Sent request to the resource incharge, the updates will be mailed to you soon!");
		return "faculty/bookings:: messageDiv";
	}
	
	@Transactional
	@Modifying
	@RequestMapping(value="/resourceRequests",method=RequestMethod.GET)
	public ModelAndView getResourceRequests() {
		
		ModelAndView model = new ModelAndView();
		
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate.toString());
		
		long curTime = new java.util.Date().getTime();
		
		Time t = new Time(curTime);
		
		resourceRequestsRepository.deletePastRequests(sqlDate,t);
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		ArrayList<ResourceRequests> requests = resourceRequestsRepository.findByResourceIncharge(userName);
		
		if(requests.isEmpty()) {
			model.addObject("msg","No requests!");
		}else {
			model.addObject("requests",requests);
		}
		model.setViewName("/faculty/resourceRequests");
		return model;
	}
	
	@Transactional
	@Modifying
	@RequestMapping(value="/getOverlappingSlots",method=RequestMethod.POST)
	public String getOverlappingSlots(Model model,Integer getOverlapsFor) {
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate.toString());
		
		long curTime = new java.util.Date().getTime();
		
		Time t = new Time(curTime);
		resourceRequestsRepository.deletePastRequests(sqlDate,t);
		
		ResourceRequests obj = resourceRequestsRepository.findByRequestId(getOverlapsFor);
		
		ArrayList<ResourceRequests> allRequests = resourceRequestsRepository.findByResourceIdAndSlotDate(obj.getResourceId(),obj.getSlotDate());
		ArrayList<ResourceRequests> overlappingRequests = new ArrayList<>();
		
		for(ResourceRequests rr:allRequests) {
			if(obj.getRequestId() != rr.getRequestId()) {
				Long st = rr.getSlotStartTime().getTime();
				Long et = rr.getSlotEndTime().getTime();
				Long gost = obj.getSlotStartTime().getTime();
				Long goet = obj.getSlotEndTime().getTime();
				if((st>=gost && et<=goet) || (st>=gost && st<goet) || (et>gost && et<=goet) || (st<=gost && et>=goet) || (st<=gost && et>gost && et<=goet)) {
					overlappingRequests.add(rr);
				}
				
			}
		}
		
		ArrayList<TimeSlots> allTimeSlots = timeSlotsRepository.findByResourceIdAndDate(obj.getResourceId(), obj.getSlotDate());
		ArrayList<TimeSlots> overlappingTimeSlots = new ArrayList<>();
		
		for(TimeSlots ts:allTimeSlots) {
			Long gost = ts.getStartTime().getTime();
			Long goet = ts.getEndTime().getTime();
			Long st = obj.getSlotStartTime().getTime();
			Long et = obj.getSlotEndTime().getTime();
			if((st>=gost && et<=goet) || (st>=gost && st<goet) || (et>gost && et<=goet) || (st<=gost && et>=goet) || (st<=gost && et>gost && et<=goet)) {
				overlappingTimeSlots.add(ts);
			}
			
		}
		
		String day = obj.getSlotDay();
		
		ArrayList<TimeTable> allTimeTableSlots = timeTableRepository.findByResourceIdAndDay(obj.getResourceId(), day);
		
		ArrayList<TimeTable> overlappingTimeTableSlots = new ArrayList<>();
		
		for(TimeTable tt:allTimeTableSlots) {
			Long st = tt.getStartTime().getTime();
			Long et = tt.getEndTime().getTime();
			Long gost = obj.getSlotStartTime().getTime();
			Long goet = obj.getSlotEndTime().getTime();
			if((st>=gost && et<=goet) || (st>=gost && st<goet) || (et>gost && et<=goet) || (st<=gost && et>=goet) || (st<=gost && et>gost && et<=goet)) {
				overlappingTimeTableSlots.add(tt);
			}
			
		}
		
		if(!overlappingRequests.isEmpty() || !overlappingTimeSlots.isEmpty() || !overlappingTimeTableSlots.isEmpty()) {
			
			if(!overlappingRequests.isEmpty()) {
				model.addAttribute("overlappingRequests",overlappingRequests);
			}
			if(!overlappingTimeSlots.isEmpty()) {
				model.addAttribute("overlappingTimeSlots",overlappingTimeSlots);
			}
			if(!overlappingTimeTableSlots.isEmpty()) {
				model.addAttribute("overlappingTimeTableSlots",overlappingTimeTableSlots);
			}
			
			return "faculty/resourceRequests:: overlapDiv";
		}else {
			model.addAttribute("msg","No overlapping requests!");
			return "faculty/resourceRequests:: messageDiv"; 
		}
		
	}
	
	@RequestMapping(value="/deleteResourceRequest",method=RequestMethod.POST)
	public String deleteResourceRequest(Model model,Integer deleteRequestFor) {
		
		ResourceRequests obj = resourceRequestsRepository.findByRequestId(deleteRequestFor);
		
		resourceRequestsRepository.delete(obj);
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		ArrayList<ResourceRequests> requests = resourceRequestsRepository.findByResourceIncharge(userName);
		
		if(requests.isEmpty()) {
			model.addAttribute("msg","Deleted successfully! No requests!");
			return "faculty/resourceRequests:: messageDiv";
		}else {
			model.addAttribute("requests",requests);
			return "faculty/resourceRequests:: requestsDiv";
		}
		
	}
	
	@RequestMapping(value="/finalAcceptResourceRequest",method=RequestMethod.POST)
	public String finalAcceptResourceRequest(Model model,Integer getOverlapsFor) {

		ResourceRequests obj = resourceRequestsRepository.findByRequestId(getOverlapsFor);
		
		ArrayList<ResourceRequests> allRequests = resourceRequestsRepository.findByResourceIdAndSlotDate(obj.getResourceId(),obj.getSlotDate());
		
		String body;
		
		
		ArrayList<ResourceRequests> overlappingRequests = new ArrayList<>();
		ArrayList<TimeSlots> overlappingTimeSlots = new ArrayList<>();

		for(ResourceRequests rr:allRequests) {
				Long gost = rr.getSlotStartTime().getTime();
				Long goet = rr.getSlotEndTime().getTime();
				Long st = obj.getSlotStartTime().getTime();
				Long et = obj.getSlotEndTime().getTime();
				if((st>=gost && et<=goet) || (st>=gost && st<goet) || (et>gost && et<=goet) || (st<=gost && et>=goet)) {
					overlappingRequests.add(rr);
					resourceRequestsRepository.delete(rr);
				}
				
		}
		
		ArrayList<TimeSlots> allTimeSlots = timeSlotsRepository.findByResourceIdAndDate(obj.getResourceId(), obj.getSlotDate());
		
		for(TimeSlots ts:allTimeSlots) {
			Long gost = ts.getStartTime().getTime();
			Long goet = ts.getEndTime().getTime();
			Long st = obj.getSlotStartTime().getTime();
			Long et = obj.getSlotEndTime().getTime();
			if((st>=gost && et<=goet) || (st>=gost && st<goet) || (et>gost && et<=goet) || (st<=gost && et>=goet)) {
				overlappingTimeSlots.add(ts);
				timeSlotsRepository.delete(ts);
			}
			
		}
		body = "Your request to book the resource "+obj.getResourceId().getResourceId()+" with Request No: "+obj.getRequestId()+" has been Accepted!\n";
		body = body.concat("Resource: "+obj.getResourceId().getResourceId()+"\n");
		body = body.concat("Activity Name: "+obj.getSlotActivityName()+"\n");
		body = body.concat("Slot: "+obj.getSlotDate()+" "+obj.getSlotStartTime()+" - "+obj.getSlotEndTime()+"\n");
		body = body.concat("Please login to your QRMS account to book another slot!\n\nRegards,\nQRMS Team.");
		TimeSlots timeslot = new TimeSlots(obj.getSlotStartTime(), obj.getSlotEndTime(), obj.getResourceId(), obj.getSlotDate(), obj.getRequestBy(), obj.getSlotActivityName(), obj.getRequestId());
		timeSlotsRepository.save(timeslot);
		
		try {
			emailServiceImpl.send(qrmsEmailId, "bmk15897@gmail.com", "QRMS: Request to book resource "+obj.getResourceId().getResourceId()+" Accepted!", body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ResourceRequests rr:overlappingRequests) {
			body = "Your request to book the resource "+rr.getResourceId().getResourceId()+" with Request No: "+rr.getRequestId()+" has been rejected!\n";
			body = body.concat("Resource: "+rr.getResourceId().getResourceId()+"\n");
			body = body.concat("Activity Name: "+rr.getSlotActivityName()+"\n");
			body = body.concat("Slot: "+rr.getSlotDate()+" "+rr.getSlotStartTime()+" - "+rr.getSlotEndTime()+"\n");
			body = body.concat("Please login to your QRMS account to book another slot!\n\nRegards,\nQRMS Team.");

			try {
			emailServiceImpl.send(qrmsEmailId, "bmk15897@gmail.com", "QRMS: Request to book resource "+rr.getResourceId().getResourceId()+" Rejected", body);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for(TimeSlots ts:overlappingTimeSlots) {
			body = "Your booked slot the resource "+ts.getResourceId().getResourceId()+" with Request No: "+ts.getRequestId()+" has been overridden by another request!\n";
			body = body.concat("Resource: "+ts.getResourceId().getResourceId()+"\n");
			body = body.concat("Activity Name: "+ts.getActivityName()+"\n");
			body = body.concat("Slot: "+ts.getDate()+" "+ts.getStartTime()+" - "+ts.getEndTime()+"\n");
			body = body.concat("Please login to your QRMS account to book another slot!\n\nRegards,\nQRMS Team.");
			try {
				emailServiceImpl.send(qrmsEmailId, "bmk15897@gmail.com", "QRMS: Request to book resource "+ts.getResourceId().getResourceId()+" Overridden", body);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		model.addAttribute("msg", "Request Accepted!");
		return "faculty/resourceRequests:: messageDiv";
	}
	
	@RequestMapping(value = "/viewSchedule",method=RequestMethod.GET)
	public ModelAndView getViewSchedule() {
		ModelAndView model = new ModelAndView();
		ArrayList<Department> depts = bookingsService.listDepartments();
		model.addObject("departments", depts);
			
		model.setViewName("/faculty/viewSchedule");
		return model;
		
	}
	
	@RequestMapping(value="/getScheduleForResource", method=RequestMethod.GET)
	public String getScheduleForResource(Model model,String getTT,String cur_date){
		
		List<TimeSlots> list = bookingsService.getTimeSlotsForDate(cur_date, getTT);
		
		if(list.size()==0) {
			model.addAttribute("msg","All slots are empty!");
			return "faculty/viewSchedule:: messageDiv";
		}else {
			model.addAttribute("ttForResource",list);
			return "faculty/viewSchedule:: resourceTT";
		}
	}
	
	@RequestMapping(value="/getViewOptions",method=RequestMethod.POST)
	public String getViewOptions(Model model,String dept,String rType,Integer minSeats) {
		
		if(minSeats==null) {
			minSeats=0;
		}
		ArrayList<Resource> options = bookingsService.listResourcesByDepartmentAndRTypeAndMinSeats(dept, rType, minSeats);

		if(options.isEmpty()) {
			model.addAttribute("err_msg","No suitable rooms/halls/classrooms were found.");
			return "faculty/viewSchedule:: messageDiv";
		}
		else {
			model.addAttribute("options",options);
			return "faculty/viewSchedule:: resourceOptionsTable";
		}
	}
	
	@Transactional
	@Modifying
	@RequestMapping(value="/viewBookingHistory",method=RequestMethod.GET)
	public ModelAndView getPreviousHistory() {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate.toString());
		
		long curTime = new java.util.Date().getTime();
		
		Time t = new Time(curTime);
		
		resourceRequestsRepository.deletePastRequests(sqlDate,t);
		
		ArrayList <ResourceRequests> historyRequests = resourceRequestsRepository.findByRequestBy(userName);
		if(!historyRequests.isEmpty()) {
			model.addObject("historyRequests",historyRequests);
		}
		
		ArrayList <TimeSlots> historyAccepted = timeSlotsRepository.findBySlotIncharge(userName);
		if(!historyAccepted.isEmpty()) {
			model.addObject("historyAccepted",historyAccepted);
		}
		
		if(historyRequests.isEmpty() && historyAccepted.isEmpty()) {
			model.addObject("msg","No History found!");
		}else if(historyRequests.isEmpty()) {
			model.addObject("msg", "No pending requests!");
		}else if(historyAccepted.isEmpty()) {
			model.addObject("msg","No accepted requests!");
		}
		
		model.setViewName("/faculty/viewBookingHistory");
		return model;
	}
	
	@Transactional
	@Modifying
	@RequestMapping(value="/deleteRequest",method=RequestMethod.POST)
	public String deleteRequest(Model model,Integer requestToDelete) {
		
		resourceRequestsRepository.deleteByRequestId(requestToDelete);
		
		return "/faculty/viewBookingHistory:: messageDiv";
	}
}