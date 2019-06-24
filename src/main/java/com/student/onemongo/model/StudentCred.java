package com.student.onemongo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Document(collection= "student_list")
public class StudentCred {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    @Id
    private ObjectId _id;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;
    // Constructors
    public StudentCred() {}

}
