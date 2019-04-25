package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Electives;
import com.qrms.spring.model.StudentAcad;
import com.qrms.spring.model.StudentAllocCourse;

public interface StudentAllocCourseRepository extends JpaRepository<StudentAllocCourse, Integer> {
	ArrayList<StudentAllocCourse> findByCourseId(Course course_id);

	void deleteByCourseId(Course course);

	//JPQL
	@Query("UPDATE StudentAllocCourse sac SET "
			+ "sac.batchId=?2 "
			+ "WHERE sac.elective = ?1")
	void updateBatchIdByElectiveId(Electives elective,String batchId);

	ArrayList <StudentAllocCourse> findByElective(Electives elective);
//	public StudentAllocCourse(int id,String batchId, Course courseId,Electives elective,StudentAcad student,int prefNo ) {

	//select * from student_alloc_course where student in (select user_name as student from student_acad order by div_id);
	@Query("SELECT new StudentAllocCourse(sac.id,sac.batchId,sac.courseId,sac.elective,sac.student,sac.prefNo) from "
			+ "StudentAllocCourse sac where sac.elective = ?1")
//			+ " AND sac.student IN "
//			+ "SELECT com.qrms.spring.model.StudentAcad(sa.userName) FROM com.qrms.spring.model.StudentAcad sa "
//			+ "order by sa.divId")
	ArrayList <StudentAllocCourse> findByElectiveIdSortedByDiv(Electives elective);

	ArrayList<StudentAllocCourse> findByStudent(StudentAcad studentProfile);
}
