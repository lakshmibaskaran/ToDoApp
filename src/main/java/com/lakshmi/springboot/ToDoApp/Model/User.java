package com.lakshmi.springboot.ToDoApp.Model;


//A POJO object for User with username and password as attributes
/*
Add @Component annotation that declares the class as a Bean class
in Springboot framework
*/


import org.springframework.stereotype.Component;

@Component
public class User
{
    private String userName;
    private String password;

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
