/**
 * Model Bean java file for storing and accessing data in a Student Object
 *
 */

package com.student.onemongo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
//import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

// Mongo database annotation.
@Document(collection= "student_list")
public class Student {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    @Id
    //private int db_id;
    private ObjectId _id;

    private String username;
    private int age;
    private int standard;
    private String section;
    //@CreatedDate
    private Date date;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;

    // Constructors
    public Student() {}
/*
    public Student(ObjectId db_id, String name, int age, int standard, String section ) {
        this.db_id = db_id;
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.section = section;
    }
*/

    // Setter
    public void setId(ObjectId id) {
        this._id = id;
    }

    //Getter

    public String getId() {
        return _id.toHexString();
        //return db_id;
    }

    // Setter
    public void setName(String newName) {
        this.username = newName;
    }

    //Getter
    public String getName() {
        return username;
    }

    // Setter
    public void setAge(int newAge) {
        this.age = newAge;
    }

    //Getter
    public int getAge() {
        return age;
    }

    // Setter
    public void setStandard(int newStandard) {
        this.standard = newStandard;
    }

    //Getter
    public int getStandard() {
        return standard;
    }

    // Setter
    public void setSection(String newSection) {
        this.section = newSection;
    }

    //Getter
    public String getSection() {
        return section;
    }

    // Setter
    public void setDate(Date date) {
        this.date = date;
    }

    //Getter
    public Date getDate() {
        return date;
    }

    // Setter
    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    //Getter
    public String getPassword() {
        return password;
    }

    // Setter
    public void setRoles(String[] roles) {  this.roles = roles; }

    //Getter
    public String[] getRoles() {
        return roles;
    }

}
