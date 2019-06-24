package com.student.onemongo.service;

import com.student.onemongo.model.Student;
import org.bson.types.ObjectId;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentService {
   // void saveStudent(Student student);
    /**
     * Method to create new employees in the db using mongo-db repository.
     * @param students
     */
    public void createStudent(Student students);

    /**
     * Method to fetch all employees from the db using mongo-db repository.
     * @return
     */
    public Collection<Student> getAllStudents();

    /**
     * Method to fetch employee by id using mongo-db repository.
     * @param id
     * @return
     */
    public Optional<Student> findStudentById(ObjectId id);

    /**
     * Method to delete employee by id using mongo-db repository.
     * @param id
     */
    public void deleteStudentById(ObjectId id);

    /**
     * Method to update employee by id using mongo-db repository.
     * @param id
     */
    public void updateStudent(Student student);

    /**
     * Method to delete all employees using mongo-db repository.
     */
    public void deleteAllStudents();

    Student findStudentBy_id(ObjectId db_id);
}
