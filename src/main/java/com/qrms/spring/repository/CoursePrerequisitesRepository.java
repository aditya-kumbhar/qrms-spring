package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qrms.spring.model.CoursePrerequisites;

public interface CoursePrerequisitesRepository extends JpaRepository<CoursePrerequisites, Integer> {
	CoursePrerequisites findByCourseId(String c_id);
	void deleteByCourseId(String c_id);
}
