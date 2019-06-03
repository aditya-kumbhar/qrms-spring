package com.qrms.spring.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.StudentPref;
import com.qrms.spring.queryBeans.StudentPrefCountInfo;

public interface StudentPrefService {
	public void saveStudentPref(StudentPref studentPref, String username);
	public List<StudentPrefCountInfo> computeStudPrefTable();
	public void setStudentPrefs(String course1,String course2,String course3,String course4,String userName);
	public ModelAndView getStudentPrefs(String elective_id,String userName);
	public ModelAndView getElectiveId(String msg,String userName);
}
