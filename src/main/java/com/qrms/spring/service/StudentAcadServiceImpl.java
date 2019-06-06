package com.qrms.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.Divisions;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.StudentUsers;
import com.qrms.spring.repository.DivisionsRepository;
import com.qrms.spring.repository.StudentAcadRepository;
import com.qrms.spring.repository.UsersRepository;

@Component
public class StudentAcadServiceImpl implements StudentAcadService {

	@Autowired
	private StudentAcadRepository studentAcadRepository;

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private DivisionsRepository divisionsRepository;
	
	@Override
	public void saveStudentAcad(StudentAcad student, String username) {
		student.setUserName(username);
		studentAcadRepository.save(student);
	
	}

	@Override
	public ArrayList<StudentUsers> getStudentList(Department department, String year) {
		StudentUsers studUser;
		ArrayList <StudentUsers> studUserList = new ArrayList<StudentUsers>();
		ArrayList <StudentAcad> students = studentAcadRepository.findByYearEqualsAndDepartmentEqualsOrderByDivAsc(year, department);
		int i = 0;
		for(StudentAcad student: students) {
			i++;
			studUser = new StudentUsers();
			Users user = userRepository.findByUserName(student.getUserName()).get();
			studUser.setSrNo(i);
			studUser.setAggrMarks(student.getAggMarks());
			studUser.setUserName(student.getUserName());
			studUser.setDiv(student.getDiv().getDivName().toString());
			studUser.setEmail(user.getEmail());
			studUser.setName(user.getFirstName().concat(" ".concat(user.getLastName())));
			studUser.setRollNo(student.getRollno());
			studUser.setShift(student.getShift());
			studUserList.add(studUser);
		}
		return studUserList;
	}
	
	@Override
	public boolean validateAndSetStudDiv(StudentAcad s, String divName) {
		String divId = s.getYear() + s.getDepartment().getDeptId() + divName;
		Divisions div = divisionsRepository.findByDivId(divId);
		if(div!=null) {
			s.setDiv(div);
			s.setRollno(divId + s.getRollno());
			return true;
		}
		return false;
	}
	
}
