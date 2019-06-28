package com.student.onemongo;

import com.student.onemongo.model.Student;
import com.student.onemongo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class OneMongoApplication {
    @Autowired
    private static StudentService studentService;
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();


	public static void main(String[] args) {


	    System.setProperty("server.servlet.context-path", "/students");
		SpringApplication.run(OneMongoApplication.class, args);
		initialise();

	}

    public static void initialise() throws NullPointerException{

        final Logger logger = LoggerFactory.getLogger(OneMongoApplication.class);

        //Optional<Student> admin = studentService.getSelf("mis");
        //if(Objects.isNull(admin))
        if(Objects.nonNull(studentService.getSelf("mis"))){
            logger.warn("User Exists");

        }else{

            logger.debug("Creating Admin");
            Student admin = new Student();
            admin.setUName("mis");
            admin.setPassword(PASSWORD_ENCODER.encode("adminmis"));
            admin.setRole("ADMIN");
            admin.setDate(new Date());
            admin.setAge(22);
            admin.setName("mis");
            admin.setStandard(12);
            admin.setSection("A");
            studentService.createStudent(admin);
        }
    }


}
