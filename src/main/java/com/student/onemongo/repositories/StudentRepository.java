/**
 * Mongo Repository Interface for Repository/Dao Layer
 * */

package com.student.onemongo.repositories;

import com.student.onemongo.model.Student;

//import org.springframework.beans.factory.annotation.Autowired;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository <Student, ObjectId>/*, QuerydslPredicateExecutor<Student>*/ {
    Student findBy_id(ObjectId db_id);

    Student findByUsername(String username);
    //@Query("{ 'name' : ?0 }")
    //List<Student> findUsersByName(String name);
    //Student findByNameAndPassword(String uname, String password);

}
