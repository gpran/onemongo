package com.student.onemongo.controller;


import com.student.onemongo.model.Student;
import com.student.onemongo.service.StudentService;
import com.student.onemongo.util.Copier;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portal")
public class UserController {
    @Autowired
    private StudentService studentService;

    Student current_user = new Student();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /*
    /**
     * Method to sign up student in the db.
     * @param studentreg
     * @return
     */

    /*
    @PostMapping(value= "/create")
    public Student create(@RequestBody Student studentreg) {
        logger.debug("Registering new student.");
        studentreg.setId(ObjectId.get());
        studentreg.setDate(new Date());
        studentreg.setUName(studentreg.getId().substring(4,7).concat(studentreg.getName().substring(0,5)).concat(studentreg.getId().substring(21,24)));
        studentService.createStudent(studentreg);
        return studentreg;
    }
    */

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

    @GetMapping(value= "/seeinfo")
    public Student getSelfRest(Authentication authentication) {
        Student student = studentService.getSelf(authentication.getName());
        logger.debug("Getting student with student-id= {}.");
        return student;
    }
    /**
     * Method to update student self data by id.
     * @param authentication
     * @param student
     * @return
     */

    //Further R&D needed
    @PutMapping(value= "/updatedata")
    public Student update(Authentication authentication , @RequestBody Student student) {
        String uname = authentication.getName();
        logger.debug("Updating student with student-uname= {}.", uname);
        Student studentTemp = studentService.getSelf(uname);
        student.setId(new ObjectId(studentTemp.getId()));
        Copier copier = new Copier();
        copier.myCopyProperties(student,studentTemp); // copies not null properties from Request Body
        studentService.updateStudent(studentTemp);
        return studentTemp;
    }



    @GetMapping(value = "checkController")
    public String checkController() {
        return "Hello";
    }

    /*
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getName() {
        return
    }
    */

}
