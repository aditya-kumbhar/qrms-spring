package com.qrms.spring.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
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
	public String givePreference(Model model, String selectPref) {
		//Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(selectPref);
		
		return selectPref;
	}
	
	//--------------------------------------------------------------------------------------
	//MODIFY THIS
	//--------------------------------------------------------------------------------------
//	@RequestMapping(value = "/setFacultyPrefs", method = RequestMethod.POST)
//	public ModelAndView addPreferences(String course1,String course2,String course3,String course4,String course5, String course6) {
//		
//		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String userName = user.getUserName();
//		
//		
//		
//		Electives electives[] = {electivesRepository.findByElectiveCourseId(course1),electivesRepository.findByElectiveCourseId(course2),electivesRepository.findByElectiveCourseId(course3),electivesRepository.findByElectiveCourseId(course4)};
//		
//		for(int i = 0;i<4;i++) {
//			System.out.println(electives[i].getElectiveCourseId());
//			FacultyPref facultyPref = new StudentPref(userName,electives[i].getCourse().getCourseId(),electives[i],i+1);					
//			facultyPrefRepository.save(facultyPref);
//		}
//
//		
//		System.out.println(electivesRepository.findByElectiveCourseId(course1).getElectiveCourseId());
//		
//		ElectiveVacancyPrefCounts electiveVacancyPrefCounts = electiveVacancyPrefCountsRepository.findByElectiveId(electivesRepository.findByElectiveCourseId(course1).getElectiveCourseId());
//		
//		int prefCount = electiveVacancyPrefCounts.getPrefCount();
//		
//		System.out.println(prefCount);
//		electiveVacancyPrefCounts.setPrefCount(++prefCount);
//
//		electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);
//		
//		return getElectiveId("Your preferences for electives have been recorded!");
//		
//	}
	
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