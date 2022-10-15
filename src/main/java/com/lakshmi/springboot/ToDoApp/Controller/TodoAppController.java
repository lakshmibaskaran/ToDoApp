package com.lakshmi.springboot.ToDoApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoAppController
{

    @RequestMapping ("/TodoApp")
    @ResponseBody
    public String testController()
    {
        System.out.println ("Testing Controller");
        return "Testing Controller";
    }


}
