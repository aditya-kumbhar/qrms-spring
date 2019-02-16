package com.qrms.spring.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureResource {
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/admin")
	public String adminHello() {
		return "Hello, you are ADMIN hence you can view this page";
	}
	
	@PreAuthorize("hasAnyRole('STUDENT')")
	@GetMapping("/secured/student")
    public String studentHello() {
        return "Hello, you are STUDENT hence you can view this page";
    }
	
	@PreAuthorize("hasAnyRole('FACULTY')")
	@GetMapping("/secured/faculty")
    public String facultyHello() {
        return "Hello, you are FACULTY hence you can view this page";
    }
		
}