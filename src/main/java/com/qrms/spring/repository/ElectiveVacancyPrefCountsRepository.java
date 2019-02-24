package com.qrms.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.ElectiveVacancyPrefCounts;

public interface ElectiveVacancyPrefCountsRepository extends JpaRepository<ElectiveVacancyPrefCounts, Integer> {
	ArrayList<ElectiveVacancyPrefCounts> findAll();
	ElectiveVacancyPrefCounts findByCourseId(String course_id);
}
