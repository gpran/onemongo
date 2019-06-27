package com.student.onemongo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().authorizeRequests()
                .antMatchers("/students/portal/**").hasRole("USER")
                .anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/students/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/students/portal/login").permitAll()
                .loginProcessingUrl("/students/admin/login").permitAll()
                .and().logout().permitAll();

        http.csrf().disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("mis")
                        .password("adminmis")
                        .roles("ADMIN")
                        .build();
        logger.debug("Setting Admin User");

        return new InMemoryUserDetailsManager(user);
    }

   /* @Override
    protected void configure(AuthenticationManager authenticationManager) throws Exception {
        authenticationManager.userDetailsService
    }
    */
}
