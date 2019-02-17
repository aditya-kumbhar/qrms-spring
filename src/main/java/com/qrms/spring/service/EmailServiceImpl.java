package com.qrms.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
  
    @Autowired
    public JavaMailSender emailSender;
 
    @Async
	public void send(String from, String to, String title, String body) throws MailException, InterruptedException{
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(title); 
        message.setText(body);
        emailSender.send(message);
	
	}
}