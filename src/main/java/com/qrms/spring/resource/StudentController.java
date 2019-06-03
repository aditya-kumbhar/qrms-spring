package com.qrms.spring.resource;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Resource;
import com.qrms.spring.model.TimeSlots;
import com.qrms.spring.model.Users;
import com.qrms.spring.service.BookingsServiceImpl;
import com.qrms.spring.service.StudentHomeServiceImpl;
import com.qrms.spring.service.StudentPrefServiceImpl;

@Controller
@RequestMapping("/u/student")
public class StudentController {
	
	@Autowired
	private StudentHomeServiceImpl studHomeService;
	
	@Autowired
	private BookingsServiceImpl bookingsService;
		
	@Autowired
	private StudentPrefServiceImpl studPrefService;
	
	@GetMapping("/home")
	public ModelAndView studentHome() {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		return studHomeService.getStudentHome(userName);
	}
	
	@RequestMapping(value="/getElectiveId",method=RequestMethod.GET)
	public ModelAndView getElectiveId(String msg) {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		return studPrefService.getElectiveId(msg,userName);
	}
	
	@RequestMapping(value = "/getStudentPrefs", method = RequestMethod.GET)
	public ModelAndView studentPref(String elective_id) {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		return studPrefService.getStudentPrefs(elective_id,userName);
	}
	
	//Handle student preference form
	@RequestMapping(value = "/setStudentPrefs", method = RequestMethod.POST)
	public ModelAndView addPreferences(String course1,String course2,String course3,String course4) {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		studPrefService.setStudentPrefs(course1, course2, course3, course4,userName);
		return getElectiveId("Your preferences for electives have been recorded!");		
	}
	

	@RequestMapping(value = "/viewSchedule",method=RequestMethod.GET)
	public ModelAndView getViewSchedule() {
		ModelAndView model = new ModelAndView();
		ArrayList<Department> depts = bookingsService.listDepartments();
		model.addObject("departments", depts);
		model.setViewName("/student/viewSchedule");
		return model;
	}
	
	@RequestMapping(value="/getScheduleForResource", method=RequestMethod.GET)
	public String getScheduleForResource(Model model,String getTT,String cur_date){
		List<TimeSlots> list = bookingsService.getTimeSlotsForDate(cur_date, getTT);
		if(list.size()==0) {
			model.addAttribute("msg","All slots are empty!");	
			return "student/viewSchedule:: messageDiv";
		}else {
			model.addAttribute("ttForResource",list);
			return "student/viewSchedule:: resourceTT";
		}
	}
	
	@RequestMapping(value="/getTTForResourceForDate",method=RequestMethod.POST)
	public String getTTForResourceForDate(Model model,String booking_date,String getTT){
		List<TimeSlots> list = bookingsService.getTimeSlotsForDate(booking_date, getTT);
		if(list.isEmpty()) {
			model.addAttribute("msg","All slots are empty!");
			return "student/viewSchedule:: messageDiv";
		}else {
			model.addAttribute("ttForResource",list);
			return "student/viewSchedule:: resourceTT";
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
			return "student/viewSchedule:: messageDiv";
		}else {
			model.addAttribute("options",options);
			return "student/viewSchedule:: resourceOptionsTable";
		}
	}

}
