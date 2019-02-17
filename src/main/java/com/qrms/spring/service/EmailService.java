package com.qrms.spring.service;


public interface EmailService {
	void send(String from,String to, String title, String body);
}
