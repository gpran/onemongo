/**
 * Mongo Repository Interface for Repository/Dao Layer
 * */

package com.student.onemongo.repositories;

import com.student.onemongo.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository
public interface StudentRepository extends MongoRepository <Student, ObjectId>/*, QuerydslPredicateExecutor<Student>*/ {
    Student findBy_id(ObjectId db_id);

    Student findByUsername(String username);
    //@Query("{ 'name' : ?0 }")
    //List<Student> findUsersByName(String name);
    //Student findByNameAndPassword(String uname, String password);

}
