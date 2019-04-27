package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Electives;
import com.qrms.spring.model.StudentPref;
import com.qrms.spring.queryBeans.PrefGroupByCourseStudent;
import com.qrms.spring.queryBeans.PrefNumCountPerElective;

@Repository
public interface StudentPrefRepository extends JpaRepository<StudentPref, Integer>{
	
	
	ArrayList<StudentPref> findByUserName(String user_name);
	ArrayList<StudentPref> findByCourseIdEquals(String electiveId);
	
	//JPQL
	@Query("SELECT "+
			"new com.qrms.spring.queryBeans.PrefGroupByCourseStudent(count(DISTINCT sp.userName),sp.courseId) "+
			"FROM StudentPref sp where sp.courseId = ?1 GROUP BY sp.courseId")
	PrefGroupByCourseStudent findPrefsGroupByCourseStudent(String courseId);

	//JPQL: Count priority-wise number of preferences for each elective
	@Query("SELECT "+
			"new com.qrms.spring.queryBeans.PrefNumCountPerElective(count(sp.prefNo),sp.prefNo,sp.elective) "+
			"FROM StudentPref sp GROUP BY sp.prefNo,sp.elective")
	List<PrefNumCountPerElective> findPrefNumCountPerElective();

	void deleteByCourseId(String courseId);
	ArrayList<StudentPref> findByUserNameAndCourseId(String userName,String course_id);
	ArrayList<StudentPref> findByElective(Electives e);

}
