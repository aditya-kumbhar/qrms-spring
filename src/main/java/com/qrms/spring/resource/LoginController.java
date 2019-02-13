package com.qrms.spring.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String userLogin() {
		return "login";
	}
		
	@GetMapping("/u/student/home")
	public String studentHome(){
		return "student/home"; 
	}
	
	@GetMapping("/u/faculty/home")
	public String facultyHome(){
		return "faculty/home"; 
	}
}
