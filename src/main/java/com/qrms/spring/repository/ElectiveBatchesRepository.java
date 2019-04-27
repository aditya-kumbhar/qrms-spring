package com.qrms.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Course;
import com.qrms.spring.model.Department;
import com.qrms.spring.model.ElectiveBatches;

@Repository
public interface ElectiveBatchesRepository extends JpaRepository<ElectiveBatches, Integer> {

	List<ElectiveBatches> findByDepartment(Department dept);
	
	
	@Transactional
	@Modifying
	@Query("DELETE from ElectiveBatches eb where eb.electiveId in "
			+ "(SELECT el.electiveCourseId from com.qrms.spring.model.Electives el where el.course=?1)")
	void deleteByCourseId(Course course);
}
