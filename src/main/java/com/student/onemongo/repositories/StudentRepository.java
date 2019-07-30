/**
 * Mongo Repository Interface for Repository/Dao Layer
 * */

package com.student.onemongo.repositories;

import com.student.onemongo.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends MongoRepository <Student, ObjectId>/*, QuerydslPredicateExecutor<Student>*/ {
    Student findBy_id(ObjectId db_id);
    Student findByUsername(String username);
    //Student findByNameAndPassword(String uname, String password);

}
