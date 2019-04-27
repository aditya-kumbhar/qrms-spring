package com.qrms.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.queryBeans.PrefGroupByCourseStudent;
import com.qrms.spring.queryBeans.StudentCountByYearSem;
import com.qrms.spring.queryBeans.StudentPrefCountInfo;
import com.qrms.spring.repository.CourseRepository;
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
			
			si.setSubmitCount(p.getCount());
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
}
