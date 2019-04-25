package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.FacultyPref;

@Repository
public interface FacultyPrefRepository extends JpaRepository<FacultyPref, Integer>{
	ArrayList<FacultyPref> findByUserName(String user_name);

	ArrayList<FacultyPref> findByUserNameAndYear(String userName, String year);
	ArrayList<FacultyPref> findByElectiveId(String id);
	ArrayList<FacultyPref> findByCourseId(String id);
	
	@Query("SELECT "+
			"count(DISTINCT fp.userName) "+ 
			"FROM FacultyPref fp where fp.userName in "+
			"("
			+ "SELECT fa.userName FROM com.qrms.spring.model.FacultyAcad fa where fa.department = ?1"
			+ ")")
	int findFacultyPrefCountByDepartment(Department dept);
	
}
