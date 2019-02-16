package com.qrms.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories("com.qrms.spring.repository")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class QrmsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrmsSpringApplication.class, args);
	}

}

