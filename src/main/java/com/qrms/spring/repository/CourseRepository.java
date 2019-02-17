package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
