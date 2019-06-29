package com.student.onemongo.service.impl;

import com.student.onemongo.model.Student;
import com.student.onemongo.repositories.StudentRepository;
import com.student.onemongo.service.StudentService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    // The dao repository will use the Mongodb-Repository to perform the database operations.
    @Autowired
    StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student students) {
        studentRepository.insert(students);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentBy_id(ObjectId id) {
        logger.debug("Service Context :: Getting student with student-id= {}.", id);
        return studentRepository.findBy_id(id);
    }

    @Override
    public void deleteStudentById(ObjectId id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }


    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public Student getSelf(String username) {
        Student student = studentRepository.findByUsername(username);
        logger.debug("Username Found:: "+username);

        return student;

    }
}