package com.qrms.spring.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String userLogin() {
		return "login";
	}
		
	@GetMapping("/u/student/student-home")
	public String studentHome(){
		return "student/student_home"; 
	}
	
	@GetMapping("/u/faculty/faculty-home")
	public String facultyHome(){
		return "faculty/faculty_home"; 
	}
}
