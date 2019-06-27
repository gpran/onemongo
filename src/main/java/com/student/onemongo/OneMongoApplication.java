package com.student.onemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class OneMongoApplication {

	public static void main(String[] args) {

		System.setProperty("server.servlet.context-path", "/students");
		SpringApplication.run(OneMongoApplication.class, args);
	}

}
