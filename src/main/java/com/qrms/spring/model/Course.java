package com.qrms.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Columns-
 * 
 * courseId
 * courseName
 * courseCredits
 * department
 * courseType
 * courseYear
 * courseSem
 * studAllocFlag
 * isTheory
 * noOfHours
 *  
 */
@Entity
@Table(name = "course")
public class Course {

	public Course(String courseId, String courseName, Integer courseCredits, Department department, char courseType,
			String courseYear, int courseSem, int studAllocFlag, int isTheory, int noOfHours) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCredits = courseCredits;
		this.department = department;
		this.courseType = courseType;
		this.courseYear = courseYear;
		this.courseSem = courseSem;
		this.studAllocFlag = studAllocFlag;
		this.isTheory = isTheory;
		this.noOfHours = noOfHours;
	}

	public Course() {

	}
	
	@Id
	@Column(name = "course_id")
	private String courseId;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "course_credits")
	private Integer courseCredits;

	// Child   of FK relation to Department -- do not cascade on delete/update
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;

	// Parent of FK relation to Electives -- do not cascade on delete/update
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	Set<Electives> electives = new HashSet<Electives>();

	// Parent of FK relation to StudentAllocs -- do not cascade on
	// delete/update
	@OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL)
	Set<StudentAllocCourse> course_Ids = new HashSet<StudentAllocCourse>();
	
	// Parent of FK relation to CoursePrerequisites -- do not cascade on
	// delete/update
	@OneToMany(mappedBy = "prerequisiteNo1", cascade = CascadeType.ALL)
	Set<CoursePrerequisites> prereqs1 = new HashSet<CoursePrerequisites>();

	// Parent of FK relation to CoursePrerequisites -- do not cascade on
	// delete/update
	@OneToMany(mappedBy = "prerequisiteNo2", cascade = CascadeType.ALL)
	Set<CoursePrerequisites> prereqs2 = new HashSet<CoursePrerequisites>();

	// Parent of FK relation to CourseCompanion -- do not cascade on
	// delete/update
	@OneToMany(mappedBy = "companionCourse", cascade = CascadeType.ALL)
	Set<CompanionCourse> companionCourses = new HashSet<CompanionCourse>();

	// Parent of FK relation to CourseCompanion -- do not cascade on
	// delete/update
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	Set<CompanionCourse> courses = new HashSet<CompanionCourse>();
	
	// O: Open Elective, E: Normal Elective R: regular course
	@Column(name = "course_type")
	private char courseType;

	@Column(name = "course_year")
	private String courseYear;

	@Column(name = "course_sem")
	private int courseSem;

	// 0 = allocation not yet started by admin
	// 1 = allocation has been started and students can give prefs
	@Column(name = "stud_allocation_flag")
	private int studAllocFlag = 0;

	@Column(name = "is_theory")
	private Integer isTheory;

	@Column(name = "no_of_hours")
	private Integer noOfHours;

	public Set<StudentAllocCourse> getCourse_Ids() {
		return course_Ids;
	}

	public void setCourse_Ids(Set<StudentAllocCourse> course_Ids) {
		this.course_Ids = course_Ids;
	}

	public Integer getIsTheory() {
		return isTheory;
	}

	public void setIsTheory(Integer isTheory) {
		this.isTheory = isTheory;
	}

	public Integer getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(Integer noOfHours) {
		this.noOfHours = noOfHours;
	}

	public int getStudAllocFlag() {
		return studAllocFlag;
	}

	public void setStudAllocFlag(int studAllocFlag) {
		this.studAllocFlag = studAllocFlag;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseCredits() {
		return courseCredits;
	}

	public void setCourseCredits(Integer courseCredits) {
		this.courseCredits = courseCredits;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public char getCourseType() {
		return courseType;
	}

	public void setCourseType(char courseType) {
		this.courseType = courseType;
	}

	public String getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public int getCourseSem() {
		return courseSem;
	}

	public void setCourseSem(int courseSem) {
		this.courseSem = courseSem;
	}
	
	public Set<CoursePrerequisites> getPrereqs1() {
		return prereqs1;
	}

	public void setPrereqs1(Set<CoursePrerequisites> prereqs1) {
		this.prereqs1 = prereqs1;
	}

	public Set<CoursePrerequisites> getPrereqs2() {
		return prereqs2;
	}

	public void setPrereqs2(Set<CoursePrerequisites> prereqs2) {
		this.prereqs2 = prereqs2;
	}
	
	public Set<Electives> getElectives() {
		return electives;
	}

	public void setElectives(Set<Electives> electives) {
		this.electives = electives;
	}

	public Set<CompanionCourse> getCompanionCourses() {
		return companionCourses;
	}

	public void setCompanionCourses(Set<CompanionCourse> companionCourses) {
		this.companionCourses = companionCourses;
	}

	public Set<CompanionCourse> getCourses() {
		return courses;
	}

	public void setCourses(Set<CompanionCourse> courses) {
		this.courses = courses;
	}

}
