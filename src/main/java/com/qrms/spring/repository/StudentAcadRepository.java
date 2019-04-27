package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Department;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.queryBeans.StudentCountByYearSem;

@Repository
public interface StudentAcadRepository extends JpaRepository<StudentAcad, Integer> {
	
	StudentAcad findByUserName(String name);
	ArrayList<StudentAcad> findBySemEqualsAndYearEquals(int semester,String year);
	
	//JPQL
	@Query("SELECT "+
			"new com.qrms.spring.queryBeans.StudentCountByYearSem(count(sa.userName),sa.year,sa.sem) "+ 
			"FROM StudentAcad sa where "+
			"sa.year=?1 and sa.sem=?2 and sa.department=?3 "+
			"GROUP BY sa.sem,sa.year,sa.department")
	StudentCountByYearSem findStudentCountByYearSemDept(String year, int sem, Department dept);
	
	ArrayList<StudentAcad> findBySemEqualsAndYearEqualsAndDepartmentEquals(int semester, String year,
			Department department);
	ArrayList<StudentAcad> findByYearEqualsAndDepartmentEquals(String year, Department dept);
}
