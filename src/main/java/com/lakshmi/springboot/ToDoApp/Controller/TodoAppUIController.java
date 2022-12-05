package com.lakshmi.springboot.ToDoApp.Controller;

import com.lakshmi.springboot.ToDoApp.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor //Use the annotation for lambok dependency injection
public class TodoAppUIController
{
    private Logger logger = LoggerFactory.getLogger((getClass()));
    private final ToDoService toDoService;

    @RequestMapping("/GetTodos")
    public String displayTodos (ModelMap modelMap)
    {
        List listOfTodos = toDoService.getToDoList();
        //modelMap.put("ListOfTodos", listOfTodos);
        modelMap.addAttribute("todo", listOfTodos);
        //return "TodoList";
        return "TodoList";
    }
}
