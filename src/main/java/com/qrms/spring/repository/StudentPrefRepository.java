package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.StudentPref;
import com.qrms.spring.queryBeans.PrefGroupByCourseStudent;

@Repository
public interface StudentPrefRepository extends JpaRepository<StudentPref, Integer>{
	
	
	ArrayList<StudentPref> findByUserName(String user_name);
	ArrayList<StudentPref> findByUserNameAndCourseId(String user_name,String courseId);
	ArrayList<StudentPref> findByCourseIdEquals(String electiveId);
	
	//JPQL, rs = resultSet
	@Query("SELECT "+
			"new com.qrms.spring.queryBeans.PrefGroupByCourseStudent(count(DISTINCT sp.userName),sp.courseId) "+
			"FROM StudentPref sp GROUP BY sp.courseId")
	List<PrefGroupByCourseStudent> findPrefsGroupByCourseStudent();


	void deleteByCourseId(String electiveIdOption);

}
