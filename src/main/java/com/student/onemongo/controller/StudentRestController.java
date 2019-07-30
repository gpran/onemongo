/**
 * Rest Controller for /students/admin rest endpoint
 * To be used by "admin-role" user only
 * All CRUD operations are in this class
 * */

package com.student.onemongo.controller;

import com.student.onemongo.model.Student;
//import com.student.onemongo.repositories.StudentRepository;
import com.student.onemongo.util.Copier;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.student.onemongo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.Date;
//import java.sql.Timestamp;
import java.util.Collection;
//import java.util.List;


@RestController
@RequestMapping("/admin")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to save students in the db.
     * @param students
     * @return
     */
    @PostMapping(value= "/create")
    public Student create(@RequestBody Student students) {
        logger.debug("Saving student.");
        students.setId(ObjectId.get());
        students.setDate(new Date());
        students.setRole("USER");
        //Following Code makes custom UName
        // using Object ID mid 3 letters + start 4 letters of name + Object ID end 3 letters
        String pre = students.getId().substring(4,7);
        String post= students.getId().substring(21,24);
        String subName=students.getName().substring(0,4);
        //pre.concat(subName);
        //pre.concat(post);
        students.setUName(pre.concat(subName.concat(post)));
        //students.setUName(students.getId().substring(4,7).concat(students.getName().substring(0,4)).concat(students.getId().substring(21,24)));
        logger.debug("Creating student with username= {}.", students.getUName());
        //long time = new Date().getTime();
        //students.setDate(new Timestamp(time));
        studentService.createStudent(students);
        return students;
    }

    /**
     * Method to fetch all students from the db.
     * @return
     */
    @GetMapping(value= "/getall")
    public Collection<Student> getAll() {
        logger.debug("Getting all students.");
        return studentService.getAllStudents();
    }

    /**
     * Method to fetch student by id.
     * @param id
     * @return
     */
    /*@GetMapping(value= "/getbyid/{student-id}")
    public Optional<Student> getById(@PathVariable(value= "student-id") ObjectId id) {
        logger.debug("Getting student with student-id= {}.", id);
        return studentService.findStudentById(id);
    }
    */
    @GetMapping(value= "/getbyid/{student-id}")
    public Student getById(@PathVariable(value= "student-id") ObjectId id) {
        logger.debug("Getting student with student-id= {}.", id);
        return studentService.findStudentBy_id(id);
    }
    /**
     * Method to update delete by id.
     * @param id
     * @param student
     * @return
     */
    @PutMapping(value= "/update/{student-id}")
    public Student update(@PathVariable(value= "student-id") ObjectId id, @RequestBody Student student) {
        logger.debug("Updating student with student-id= {}.", id);
        student.setId(id);
        Student studentTemp = studentService.findStudentBy_id(id);
        //Cuastom Bean property functionality to copy not null elements fro, Request Object to Database extracted Object
        Copier copier = new Copier();
        copier.myCopyProperties(student,studentTemp);
        /*//student.setDate((studentTemp).get().getDate());
        student.setDate(studentTemp.getDate());
        //student.setDate(studentTemp.);
        student.setRole("USER");
        */
        studentService.updateStudent(studentTemp);
        return studentTemp;
        //return "Student record for student-id= " + id + " updated.";
    }

    /**
     * Method to delete student by id.
     * @param id
     * @return
     */
    @DeleteMapping(value= "/delete/{student-id}")
    public Student delete(@PathVariable(value= "student-id") ObjectId id) {
        Student studel = studentService.findStudentBy_id(id);
        //Optional<Student> studel = studentService.findStudentById(id);
        logger.debug("Deleting student with student-id= {}.", id);
        studentService.deleteStudentById(id);
        return studel;
        //return "Student record for student-id= " + id + " deleted.";
    }

    /**
     * Method to delete all students from the db.
     * @return
     */
    /*
    @DeleteMapping(value= "/deleteall")
    public String deleteAll() {
        logger.debug("Deleting all students.");
        studentService.deleteAllStudents();
        return "All student records deleted.";
    }
    */

    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") ObjectId id) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyStudentById(@PathVariable("id") ObjectId id, @Valid @RequestBody Student student) {
        student.setId(id);
        studentService.saveStudent(student);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Student createStudent(@Valid @RequestBody Student student) {

        return null;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable ObjectId id) {
        repository.delete(repository.findBydb_id(id));
    }
*/

    @GetMapping(value = "checkController")
    public String checkController() {
        return "Hello";
    }

}
