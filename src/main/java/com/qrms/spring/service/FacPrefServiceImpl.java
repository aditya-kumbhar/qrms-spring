package com.qrms.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.OpenFacultyPrefs;
import com.qrms.spring.queryBeans.FacPrefCountInfo;
import com.qrms.spring.repository.DepartmentRepository;
import com.qrms.spring.repository.FacultyAcadRepository;
import com.qrms.spring.repository.FacultyPrefRepository;
import com.qrms.spring.repository.OpenFacultyPrefsRepository;

@Service
public class FacPrefServiceImpl implements FacPrefService {

	@Autowired
	OpenFacultyPrefsRepository openFacultyPrefsRepository;
	
	@Autowired
	FacultyAcadRepository facultyAcadRepository;
	
	@Autowired
	FacultyPrefRepository facultyPrefRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<FacPrefCountInfo> computeFacPrefTable() {
		List<FacPrefCountInfo> fpList = new ArrayList<FacPrefCountInfo>();
		List<OpenFacultyPrefs> openFacPrefs = openFacultyPrefsRepository.findAll();
		
		for(OpenFacultyPrefs op : openFacPrefs) {
			Department dept = departmentRepository.findByDeptId(op.getDeptId());
			FacPrefCountInfo fp = new FacPrefCountInfo();
			fp.setDeptName(dept.getDeptId());
			if(op.getSemType() == 0)
				fp.setSemType("Even semesters");
			else
				fp.setSemType("Odd semesters");
			fp.setSubmitCount(facultyPrefRepository.findFacultyPrefCountByDepartment(dept));
			fp.setTotalFacultyCount(facultyAcadRepository.countFacultyByDepartment(dept));
			fpList.add(fp);
		}
		return fpList;
		
	}
	
}
