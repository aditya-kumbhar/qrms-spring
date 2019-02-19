package com.qrms.spring.resource;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.qrms.spring.model.PasswordResetToken;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.RoleRepository;
import com.qrms.spring.repository.UsersRepository;
import com.qrms.spring.service.EmailServiceImpl;
import com.qrms.spring.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private EmailServiceImpl emailObj;
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String userLogin() {
		return "login";
	}
	
	@GetMapping("/forgotPassword")
	public String forgotPass() {
		return "forgotPass";
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView resetToken(String email,HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView();
		String token = UUID.randomUUID().toString();		
		Users user = userService.findUserByEmail(email);
		
		if(user == null) {
			model.addObject("message","Invalid email-id");
			model.setViewName("forgotPass");
			return model;
		}
		userService.createPasswordTokenForUser(user, token);		
		String emailBody = constructEmail(request,user,token);
		
		try {
			emailObj.send("qrmsmail@gmail.com", user.getEmail(), "QRMS- Password Reset", emailBody);
			model.addObject("message","Password reset email has been sent");
			
		}catch(Exception e) {
			System.out.println("Error Sending Password Token Email: " + e.getMessage());
			model.addObject("message","Error Sending Password Token Email: " + e.getMessage());
		}
					
		model.setViewName("login");
		return model;
	}
	
	//redirects to this URL when email reset link is clicked & show reset Password form
	@RequestMapping(value = "/validateToken", method = RequestMethod.GET)
	public ModelAndView showChangePasswordPage( @RequestParam("id") String username, @RequestParam("token") String token) {
		ModelAndView model = new ModelAndView();
	
		String result = userService.validatePasswordResetToken(username, token);
	    if (result != null) {
	        model.addObject("message",result);
	        model.setViewName("login");
	        System.out.println(result);
	        return model;
	    }
	    model.addObject("username",username);
	    model.setViewName("resetPassword");
	    return model;
	}

	//POST URL to set new password
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ModelAndView updatePass(String password1, String h_username) {
		
		Users user = userService.findByUserName(h_username);
		userService.savePassword(user, password1);
		ModelAndView model = new ModelAndView();
		model.addObject("message","Password has been reset successfully. Login with your new password");
        model.setViewName("login");
        return model;

	}
	
	private String constructEmail(HttpServletRequest request,Users user, String token) {
		String url = "http://"+request.getLocalName()+":"+request.getLocalPort()+"/validateToken?id=" + user.getUserName() + "&token=" + token;
		String body = "Hi "+user.getFirstName()+",\nTo initiate the password reset process for your QRMS Account, click the link below:\n"+url+"\nIf clicking the link above doesn't work, please copy and paste the URL in a new browser window instead.\nSincerely, QRMS Team.";
		return body;
	}
	

}
