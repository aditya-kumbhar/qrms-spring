package com.qrms.spring.resource;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Course;
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.CourseAndElectives;
import com.qrms.spring.queryBeans.FacPrefsList;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
import com.qrms.spring.repository.FacultyAcadRepository;

import org.json.JSONObject;

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
	
	@GetMapping("/home")
	public String facultyHome() {
		return "faculty/home";
	}
		
	@RequestMapping(value = "/givePreferenceChoice", method = RequestMethod.GET)
	public ModelAndView facultyPref(String msg) {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		
		model.setViewName("/faculty/facultyPref");
		
		return model;
	}
	
	@RequestMapping(value = "/getFacPrefForm", method = RequestMethod.GET)
	public String getFacPrefForm(Model model, String year) {
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(year);
		
		FacultyAcad currUserAcad = facultyAcadRepository.findByUserName(userName);
		
		ArrayList <FacultyPref> facultyPrefs = facultyPrefRepository.findByUserNameAndYear(currUserAcad.getUserName(),year);
		
		if(facultyPrefs.size()==2) {
			model.addAttribute("err_msg","Cannot give more that 2 preferences for single year");
			return "faculty/facultyPref :: messageDiv";
		}
		else {
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
						CourseAndElectives ce = new CourseAndElectives();
						ce.setCourse(elCourse);
						ce.setElective(el);
						resultSet.add(ce);
							
					}				
				}
				for(Course regCourse: regCourses) {
					CourseAndElectives ce = new CourseAndElectives();
					ce.setCourse(regCourse);			
					resultSet.add(ce);				
				}
			}
			model.addAttribute("resultSet",resultSet);
		}
		
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

}