package com.lakshmi.springboot.ToDoApp.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

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

    //When a project is connected to H2, Springboot Security needs to be configured to disable CSRF and FrameOptions.
    //In order to make the project access H2, we are overriding the SecurityFilterChain to disable CSRF and headers.
    //Most of the coding here is a copy - paste from the tutorial and I don't have strong insight into this.

    //The parameter httpSecurity allows us to configure web based security.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        //Authorize all incoming requests. Any incoming request should be routed through Springboot Security login page
        http.authorizeHttpRequests(
                    auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults()); //Show a form login with defaults for username and password text boxes.
        //Disable CSRF for H2
        http.csrf().disable();
        //Disable headers because H2 uses headers and it needs to be explicitly disabled for Springboot Security
        http.headers().frameOptions().disable();
        return http.build(); //returns the Security filter chain
    }

}
