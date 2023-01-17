package com.lakshmi.springboot.ToDoApp.Controller;



import com.lakshmi.springboot.ToDoApp.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//The Serivce class is defined as a Rest Controller to get the list of Todos
@RestController
@RequiredArgsConstructor
public class TodoAppRESTController
{

    private Logger logger = LoggerFactory.getLogger((getClass()));
    //Annotation @RequiredArgsConstructor creates the boilerplate to define the constructor for TodoAppRESTController with ToDoService as the parameter
    private final ToDoService toDoService;

    /*
    @RequestMapping ("api/GetTodos")
    public List getTodos()
    {
        //Return the list of Todos
        logger.debug("Rest Controller to return the list of Todos");
        // ToDoService toDoService = new ToDoService();

        List listofToDos = toDoService.getToDoList();
        return listofToDos;
    */
}
