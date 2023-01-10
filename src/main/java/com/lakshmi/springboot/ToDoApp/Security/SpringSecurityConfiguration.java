package com.lakshmi.springboot.ToDoApp.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration
{

    private Logger logger = LoggerFactory.getLogger((getClass()));

    //Return reference to BCryptPasswordEncoder that will be used for InMemory authentication
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    //Use the BCryptPasswordEncoder for InMemoryUserDetailsManager

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
        logger.debug ("Into InMemoryUserDetailsManager");
        //Create a lambda function for encoder
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        //Reference the lambda function in UserDetails


        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("Nisha")
                .password("ilikethis")
                .roles("USER", "ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(userDetails);
    }
}
