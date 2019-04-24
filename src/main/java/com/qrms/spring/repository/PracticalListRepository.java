package com.qrms.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.qrms.spring.model.FacultyAcad;
import com.qrms.spring.model.PracticalList;

public interface PracticalListRepository extends JpaRepository<PracticalList, Integer> {

	@Transactional
	@Modifying
	@Query("delete from PracticalList p where p.facultyId in ?1")
	void deleteByFacultyIdList(List<String> facIdList);

}
