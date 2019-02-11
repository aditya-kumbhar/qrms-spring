package com.qrms.spring.resource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.service.CustomUserDetailsService;

@Controller
@RequestMapping("/u/admin")
public class AdminController {
	
	@Autowired
	private CustomUserDetailsService userDetails;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/home")
	public String adminHome() {
		return "admin/home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUsers() {
		ModelAndView model = new ModelAndView();
		Users user = new Users();
		String string_role = new String();
		model.addObject("string_role",string_role);
		model.addObject("user",user);
		model.setViewName("admin/registerUsers");
		return model;
	}
	
	@RequestMapping(value = "/register_users", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid Users user, String role) {
		ModelAndView model = new ModelAndView();
		System.out.println(role);
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		
		Role userRole = roleRepository.findByRole(role);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		
		userDetails.saveUser(user);
		String string_role = new String();
		model.addObject("msg","User has been successfully registered");
		model.addObject("user",new Users());
		model.addObject("string_role",string_role);
		model.setViewName("admin/registerUsers");
		return model;
	}
	
	
}
