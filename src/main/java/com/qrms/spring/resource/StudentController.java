package com.qrms.spring.resource;


import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectiveVacancyPrefCountsRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentPrefRepository;

@Controller
@RequestMapping("/u/student")
public class StudentController {
	
	@Autowired
	private StudentPrefRepository studentPrefRepository;
		
	@Autowired
	private StudentAcadRepository studentAcadRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ElectiveVacancyPrefCountsRepository electiveVacancyPrefCountsRepository;
	
	@Autowired
	private ElectivesRepository electivesRepository;
	
	@GetMapping("/home")
	public String studentHome() {
		return "student/home";
	}
	
	@RequestMapping(value="/getElectiveId",method=RequestMethod.GET)
	public ModelAndView getElectiveId(String msg) {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		

		StudentAcad currUserAcad = studentAcadRepository.findByUserName(userName);
		
		System.out.println(currUserAcad.getUserName());
		
		ArrayList<Course> elective_ids = courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(currUserAcad.getSem(),currUserAcad.getYear(),'R',currUserAcad.getDepartment(),1,1);
		
		for (Course course : elective_ids) {
			System.out.println(course.getCourseName());
		}
		
		model.addObject("elective_ids",elective_ids);
		model.setViewName("/student/studentPref");
		
		System.out.println(msg);
		if(msg!=null)
			model.addObject("msg",msg);
		return model;
	}
	
	
	
	@RequestMapping(value = "/getStudentPrefs", method = RequestMethod.GET)
	public ModelAndView studentPref(@Valid String elective_id,String []elective_ids) {
		ModelAndView model = new ModelAndView();
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		System.out.println(userName);
		
		StudentAcad currUserAcad = studentAcadRepository.findByUserName(userName);
		
		ArrayList <StudentPref> studentPrefs = studentPrefRepository.findByUserNameAndCourseId(currUserAcad.getUserName(),elective_id);
		if(studentPrefs.size()!=0) {
			model.addObject("msg","Your preferences for electives have been recorded already!");
			model.setViewName("student/home");
			return model;
		} else {
			ArrayList<Electives> electiveList = electivesRepository.findByCourse(courseRepository.findByCourseId(elective_id)); 
			if(electiveList.size()==0) {
				System.out.println("No courses exist");
				String msg = "Please choose other elective-id!";
				return getElectiveId(msg);
			}else {
				System.out.println("Courses exist");
			}
			
			model.addObject("studentPref",new StudentPref());
			model.addObject("courseList", electiveList);
			model.addObject("course1",new String());
			model.addObject("course2",new String());
			model.addObject("course3",new String());
			model.addObject("course4",new String());
			model.addObject("elective_ids",elective_ids);
			model.setViewName("student/studentPref");
			return model;
		}
		
		
	}
	
	//Handle student preference form
	@RequestMapping(value = "/setStudentPrefs", method = RequestMethod.POST)
	public ModelAndView addPreferences(@Valid String course1,String course2,String course3,String course4) {
		
		ModelAndView model = new ModelAndView();	
		
		Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserName();
		
		System.out.println(course1);
		
		Electives electives[] = {electivesRepository.findByElectiveCourseId(course1),electivesRepository.findByElectiveCourseId(course2),electivesRepository.findByElectiveCourseId(course3),electivesRepository.findByElectiveCourseId(course4)};
		
		for(int i = 0;i<4;i++) {
			System.out.println(electives[i].getElectiveCourseId());
			StudentPref studentPref = new StudentPref(userName,electives[i].getCourse().getCourseId(),electives[i],i+1);					
			studentPrefRepository.save(studentPref);
		}

		
		System.out.println(electivesRepository.findByElectiveCourseId(course1).getElectiveCourseId());
		
		ElectiveVacancyPrefCounts electiveVacancyPrefCounts = electiveVacancyPrefCountsRepository.findByElectiveId(electivesRepository.findByElectiveCourseId(course1).getElectiveCourseId());
		
		int prefCount = electiveVacancyPrefCounts.getPrefCount();

		electiveVacancyPrefCounts.setPrefCount(++prefCount);

		electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);
		
		model.addObject("msg1","Your preferences for electives have been recorded!");
		model.setViewName("student/studentPref");
		
		return model;
	
	}
}
