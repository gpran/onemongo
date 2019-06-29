package com.student.onemongo;

import com.student.onemongo.model.Student;
import com.student.onemongo.repositories.StudentRepository;
import com.student.onemongo.service.StudentService;
import com.student.onemongo.service.impl.StudentDetailService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class OneMongoApplication {


	public static void main(String[] args) {


	    System.setProperty("server.servlet.context-path", "/students");
		SpringApplication.run(OneMongoApplication.class, args);
	}


}
