package com.qrms.spring.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.OpenFacultyPrefs;

@Repository
public interface OpenFacultyPrefsRepository extends JpaRepository<OpenFacultyPrefs, Integer> {

	OpenFacultyPrefs findByDeptId(String deptId);

	@Transactional
	@Modifying
	void deleteByDeptId(String deptId);

}
