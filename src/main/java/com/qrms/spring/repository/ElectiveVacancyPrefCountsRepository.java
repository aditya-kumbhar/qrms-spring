package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.ElectiveVacancyPrefCounts;

public interface ElectiveVacancyPrefCountsRepository extends JpaRepository<ElectiveVacancyPrefCounts, Integer> {
	ArrayList<ElectiveVacancyPrefCounts> findAll();
	ArrayList<ElectiveVacancyPrefCounts> findByCourseId(String course_id);
	ElectiveVacancyPrefCounts findByElectiveId(String elective_id);
	void deleteByCourseId(String courseId);
}
