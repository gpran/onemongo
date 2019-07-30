package com.student.onemongo;

import com.student.onemongo.model.Student;
import com.student.onemongo.repositories.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class CommandLineAppStarter implements CommandLineRunner {


        @Autowired
        StudentRepository studentRepository;

        @Override
        public void run(String...args) throws Exception {
            Student admin = new Student();
            admin.setId(ObjectId.get());
            admin.setUName("mis");
            admin.setPassword("adminmis");
            admin.setRole("ADMIN");
            admin.setDate(new Date());
            admin.setAge(22);
            admin.setName("mis");
            admin.setStandard(12);
            admin.setSection("A");
            studentRepository.insert(admin);
        }
}
