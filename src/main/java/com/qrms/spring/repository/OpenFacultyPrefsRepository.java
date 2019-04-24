package com.qrms.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.OpenFacultyPrefs;

@Repository
public interface OpenFacultyPrefsRepository extends JpaRepository<OpenFacultyPrefs, Integer> {

	OpenFacultyPrefs findByDeptId(String deptId);

}
