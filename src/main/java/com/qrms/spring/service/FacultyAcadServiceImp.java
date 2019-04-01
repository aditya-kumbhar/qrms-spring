package com.qrms.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.Users;
import com.qrms.spring.queryBeans.FacultyUsers;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.UsersRepository;

@Service
public class FacultyAcadServiceImp implements FacultyAcadService{

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private FacultyAcadRepository facultyAcadRepository;
	
	@Override
	public ArrayList<FacultyUsers> getFacultyList(Department dept) {
		
		FacultyUsers facUser;
		ArrayList <FacultyUsers> facUserList = new ArrayList<FacultyUsers>();
		ArrayList <FacultyAcad> faculties = facultyAcadRepository.findByDepartmentEquals(dept);
		for(FacultyAcad faculty: faculties) {
			System.out.println("HI");
			facUser = new FacultyUsers();
			Users user = userRepository.findByUserName(faculty.getUserName()).get();
			facUser.setDesignation(faculty.getDesignation());
			facUser.setEmail(user.getEmail());
			facUser.setExp(faculty.getYearsOfExperience());
			facUser.setName(user.getFirstName()+" "+user.getLastName());
			facUser.setQualification(faculty.getQualification());
			facUser.setUserName(user.getUserName());
			facUserList.add(facUser);
		}
		return facUserList;
	}
	
}
