package com.qrms.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.ElectiveVacancyPrefCounts;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.queryBeans.PrefGroupByCourseStudent;
import com.qrms.spring.queryBeans.StudentCountByYearSem;
import com.qrms.spring.queryBeans.StudentPrefCountInfo;
import com.qrms.spring.repository.CourseRepository;
import com.qrms.spring.repository.ElectiveVacancyPrefCountsRepository;
import com.qrms.spring.repository.ElectivesRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.StudentPrefRepository;

@Service
public class StudentPrefServiceImpl implements StudentPrefService {
	
	@Autowired
	private StudentPrefRepository studentPrefRepository;

	@Autowired
	private StudentAcadRepository studentAcadRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ElectivesRepository electivesRepository;
	
	@Autowired
	private ElectiveVacancyPrefCountsRepository electiveVacancyPrefCountsRepository;
	
	
	@Override
	public void saveStudentPref(StudentPref student, String username) {
		student.setUserName(username);
		studentPrefRepository.save(student);
	
	}

	@Override
	public List<StudentPrefCountInfo> computeStudPrefTable() {
		StudentCountByYearSem totalStudentCount;
		
		PrefGroupByCourseStudent p;
		List<StudentPrefCountInfo> studCountInfo = new ArrayList<StudentPrefCountInfo>();
	
//		totalStudentCount = studentAcadRepository.findStudentCountByYearSemDept();
//		prefsPerElective = studentPrefRepository.findPrefsGroupByCourseStudent();
		Course c;
		
		List<Course> openCourses = courseRepository.findByStudAllocFlagNot(0);
		
//		for(PrefGroupByCourseStudent p: prefsPerElective) {
//			c = courseRepository.findByCourseId(p.getCourseId());
		for(Course openCourse: openCourses) {
			c = openCourse;
			totalStudentCount = studentAcadRepository.findStudentCountByYearSemDept(c.getCourseYear(),c.getCourseSem(),c.getDepartment());
			p = studentPrefRepository.findPrefsGroupByCourseStudent(c.getCourseId());
			StudentPrefCountInfo si = new StudentPrefCountInfo();
			si.setCourseId(c.getCourseId());
			si.setCourseName(c.getCourseName());
			si.setDeptId(c.getDepartment().getDeptId());
			si.setSem(c.getCourseSem());
			if(p!=null) {
				si.setSubmitCount(p.getCount());
			}else {
				si.setSubmitCount(0);
			}
			
			si.setTotalStudentCount(totalStudentCount.getCount());
			si.setYear(c.getCourseYear());
			studCountInfo.add(si);
//					openCourses.remove(c);
		}
			
		
//		for(Course openCourse: openCourses) {
//			StudentPrefCountInfo si = new StudentPrefCountInfo();
//			si.setCourseId(openCourse.getCourseId());
//			si.setCourseName(openCourse.getCourseName());
//			si.setDeptId(openCourse.getDepartment().getDeptId());
//			si.setSem(openCourse.getCourseSem());
//			si.setSubmitCount(0);
//			for(StudentCountByYearSem s: totalStudentCount) {
//				if(s.getSem() == openCourse.getCourseSem() && s.getYear().equals(openCourse.getCourseYear())) {
//					si.setTotalStudentCount(s.getCount());
//					break;
//				}
//			}
//			si.setYear(openCourse.getCourseYear());
//			studCountInfo.add(si);
//		}
		return studCountInfo;
	}

	@Override
	public void setStudentPrefs(String course1,String course2,String course3,String course4,String userName) {
		Electives electives[] = {electivesRepository.findByElectiveCourseId(course1),electivesRepository.findByElectiveCourseId(course2),electivesRepository.findByElectiveCourseId(course3),electivesRepository.findByElectiveCourseId(course4)};
		
		for(int i = 0;i<4;i++) {
			System.out.println(electives[i].getElectiveCourseId());
			StudentPref studentPref = new StudentPref(userName,electives[i].getCourse().getCourseId(),electives[i],i+1);					
			studentPrefRepository.save(studentPref);
		}

		ElectiveVacancyPrefCounts electiveVacancyPrefCounts = electiveVacancyPrefCountsRepository.findByElectiveId(electivesRepository.findByElectiveCourseId(course1).getElectiveCourseId());
		
		int prefCount = electiveVacancyPrefCounts.getPrefCount();
		
		electiveVacancyPrefCounts.setPrefCount(++prefCount);

		electiveVacancyPrefCountsRepository.save(electiveVacancyPrefCounts);
		
	}

	@Override
	public ModelAndView getStudentPrefs(String elective_id, String userName) {

		ModelAndView model = new ModelAndView();
		
		StudentAcad currUserAcad = studentAcadRepository.findByUserName(userName);
		
		ArrayList <StudentPref> studentPrefs = studentPrefRepository.findByUserNameAndCourseId(currUserAcad.getUserName(),elective_id);
		if(studentPrefs.size()!=0) 
			return getElectiveId("Your preferences for chosen elective have been recorded already!",userName);
		else {
			Course chosen_course = courseRepository.findByCourseId(elective_id);
			ArrayList<Electives> electiveList = electivesRepository.findByCourse(chosen_course); 
			if(electiveList.size()==0) {
				String msg = "Please choose other elective-id!";
				return getElectiveId(msg,userName);
			}
		
			ArrayList<Course> elective_ids = courseRepository.findByCourseSemAndCourseYearAndCourseTypeNotAndDepartmentAndIsTheoryAndStudAllocFlag(currUserAcad.getSem(),currUserAcad.getYear(),'R',currUserAcad.getDepartment(),1,1);
			model.addObject("chosen_course_name",chosen_course.getCourseName());
			model.addObject("chosen_course_id",chosen_course.getCourseId());
			model.addObject("elective_ids",elective_ids);
			model.addObject("studentPref",new StudentPref());
			model.addObject("courseList", electiveList);
			model.setViewName("student/studentPref");
			return model;
		}
	}

	@Override
	public ModelAndView getElectiveId(String msg, String userName) {
		ModelAndView model = new ModelAndView();
		StudentAcad currUserAcad = studentAcadRepository.findByUserName(userName);

		ArrayList<Course> elective_ids = courseRepository.findByCourseSemAndCourseYearAndCourseTypeAndDepartmentAndIsTheoryAndStudAllocFlag(currUserAcad.getSem(),currUserAcad.getYear(),'E',currUserAcad.getDepartment(),1,1);
		ArrayList<Course> open_elective_ids = courseRepository.findByCourseSemAndCourseYearAndCourseTypeAndIsTheoryAndStudAllocFlag(currUserAcad.getSem(),currUserAcad.getYear(),'O',1,1);
		
		elective_ids.addAll(open_elective_ids);
		
		model.addObject("elective_ids",elective_ids);
		model.setViewName("/student/studentPref");

		if(msg!=null)
			model.addObject("msg",msg);
		return model;
	}
	
	
}
