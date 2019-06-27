package com.student.onemongo.controller;


import com.student.onemongo.model.Student;
import com.student.onemongo.model.StudentCred;
import com.student.onemongo.service.StudentService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/portal")
public class UserController {
    @Autowired
    private StudentService studentService;

    Student current_user = new Student();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to sign up student in the db.
     * @param studentreg
     * @return
     */
    @PostMapping(value= "/create")
    public Student create(@RequestBody Student studentreg) {
        logger.debug("Registering new student.");
        studentreg.setId(ObjectId.get());
        studentreg.setDate(new Date());
        studentreg.setUName(studentreg.getId().substring(4,7).concat(studentreg.getName().substring(0,5)).concat(studentreg.getId().substring(21,24)));
        studentService.createStudent(studentreg);
        return studentreg;
    }

   /*
    @GetMapping(value = "/login")
    public String login(@RequestBody StudentCred studentsession) {
        String id = studentsession.get_id();
        logger.debug("User logged in with student-id= {}.", id);
        return "Logged In";
    }
    */

    /**
     * Method to fetch student by id.
     * @param id
     * @return
     */

    @GetMapping(value= "/seeinfo/{student-id}")
    public Student getById(@PathVariable(value= "student-id") ObjectId id) {
        logger.debug("Getting student with student-id= {}.", id);
        return studentService.findStudentBy_id(id);
    }
    /**
     * Method to update student self data by id.
     * @param id
     * @param student
     * @return
     */
    /*
    //Further R&D needed
    @PutMapping(value= "/updateself/{student-uname}")
    public Student update(@PathVariable(value= "student-uname") String uname, @RequestBody Student student) {
        logger.debug("Updating student with student-uname= {}.", id);
        student.setId(id);
        Student studentTemp = studentService.findStudentBy_id(id);
        //student.setDate((studentTemp).get().getDate());
        student.setDate(studentTemp.getDate());
        studentService.updateStudent(student);
        return student;
        //return "Student record for student-id= " + id + " updated.";
    }
    */


    @GetMapping(value = "checkController")
    public String checkController() {
        return "Hello";
    }

}
