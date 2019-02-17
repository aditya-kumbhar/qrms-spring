package com.qrms.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class QrmsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrmsSpringApplication.class, args);
	}

}

