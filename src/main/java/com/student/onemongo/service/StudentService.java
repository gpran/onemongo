package com.student.onemongo.service;

import com.student.onemongo.model.Student;
import org.bson.types.ObjectId;
import java.util.Collection;

public interface StudentService {
    /**
     * Method to create new students in the db using mongo-db repository.
     * @param students
     */
     void createStudent(Student students);

    /**
     * Method to fetch all students from the db using mongo-db repository.
     * @return
     */
     Collection<Student> getAllStudents();

    /**
     * Method to fetch student by id using mongo-db repository.
     * @param id
     * @return
     */
    //public Optional<Student> findStudentById(ObjectId id);

    /**
     * Method to delete student by id using mongo-db repository.
     * @param id
     */
     void deleteStudentById(ObjectId id);

    /**
     * Method to update student by id using mongo-db repository.
     * @param id
     */
     void updateStudent(Student student);

    /**
     * Method to delete all students using mongo-db repository.
     */
     void deleteAllStudents();

     Student findStudentBy_id(ObjectId db_id);
     Student getSelf(String username);
}
