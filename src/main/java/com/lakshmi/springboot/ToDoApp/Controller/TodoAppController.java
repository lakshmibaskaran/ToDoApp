package com.lakshmi.springboot.ToDoApp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TodoAppController
{
    @RequestMapping("/TodoApp-jsp")
    //@ResponseBody
    public String testController()
    {
        //Mention only the name of the JSP file. Spring MVC will append and prepend the folder path
        //and file extension from application.properties
        System.out.println("Into testController");
        return "TodoHello";
    }
}
