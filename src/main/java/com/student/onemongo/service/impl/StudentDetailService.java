package com.student.onemongo.service.impl;

import com.student.onemongo.model.Student;
import com.student.onemongo.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class StudentDetailService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);
        if (student == null) {
            logger.debug("User " + username + " Not Found");
            throw new UsernameNotFoundException(username + " Not Found");
        }
        return new org.springframework.security.core.userdetails.User(
                student.getUName(),
                student.getPassword(),
                AuthorityUtils.createAuthorityList(student.getRole()));
    }
}
