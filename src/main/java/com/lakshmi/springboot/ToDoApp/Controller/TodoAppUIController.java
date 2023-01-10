package com.lakshmi.springboot.ToDoApp.Controller;

import com.lakshmi.springboot.ToDoApp.Model.ToDo;
import com.lakshmi.springboot.ToDoApp.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
@RequiredArgsConstructor //Use the annotation for lambok dependency injection
public class TodoAppUIController
{
    private Logger logger = LoggerFactory.getLogger((getClass()));
    private final ToDoService toDoService;

    @RequestMapping("/GetTodos")
    public String getTodosByUserId (HttpSession httpSession,ModelMap modelMap)
    {
        //Gets the list of Todos from the Service; adds it to the Model and sends it to the TodoList.jsp
        //List listOfTodos = toDoService.getToDoList();
        List listOfTodos = toDoService.getTodosByUserId((String)httpSession.getAttribute("name"));
        modelMap.addAttribute("todo", listOfTodos);
        return "TodoList";
    }

    //The RequestMapping /add-to do with GET Request Method is called when Add To do button is clicked in Todolist.jsp.
    // It uses the requestMethod GET since on clicking the Add To do button, the default GET method is invoked.
    @RequestMapping(value="/add-todo", method= RequestMethod.GET)

    //public String showTodos (HttpSession httpSession, ModelMap modelMap)
    public String showAddTodoPage (HttpSession httpSession, ModelMap modelMap)
    {
        logger.debug("In the GET controller method of add-todo");

        /*Since ToDo.jsp is associated to the command Bean ToDo, all methods that
        serve Todo.jsp should be referred by the command bean by using the two statements below
         */
        ToDo toDo = new ToDo(0,(String) httpSession.getAttribute("name"),"", LocalDate.now(), false );
        modelMap.put("todo", toDo);
        return "Todo";
    }

    //The RequestMapping /addtodo with POST method is called when the Submit Button is clicked in To do.jsp after a new To do is added.

    @RequestMapping(value="/add-todo", method= RequestMethod.POST)
    public String addTodo (HttpSession httpSession, ModelMap modelMap, @Valid ToDo toDo, BindingResult result)
    {
        logger.debug("In the POST controller method of add-todo");
        logger.debug("Username in session:" + httpSession.getAttribute("name"));
        logger.debug("Todo Description:" + toDo.getToDoDescription());

        //If there is a validation error from the bean, do not invoke addTodo. Stay in the current page.

        if (result.hasErrors())
        {
            logger.debug("There is a validation error, so return to Todo JSP page");
            String objectName = result.toString();
            System.out.println("ObjectName:" + objectName);
            modelMap.put("todo", new ToDo(0,(String) httpSession.getAttribute("name"),"", LocalDate.now(), false ));
            return "Todo";
        }

        //Call the addToDo method in toDoService Business calss to add the new To do.
        List todoList = toDoService.addToDo((String) httpSession.getAttribute("name"), toDo.getToDoDescription(), toDo.getToDoByDate());
        //Put the new To do in the modelMap and direct it to JSP
        modelMap.put("todo", todoList);
        return "TodoList";
    }


    //The RequestMapping delete-to do is enabled when the delete Button is clicked in To do.jsp
    @RequestMapping(value="/delete-todo")
    public String deleteTodo (@RequestParam int id, ModelMap modelMap)
    {
        logger.debug("Into Todo Delete");
        logger.debug("ID against the deleted row:" + id);
        toDoService.deleteToDo(id);
        logger.debug("Successfully deleted " + id);
        return "redirect:GetTodos";

    }


    //The RequestMapping update-to do is called when the Update Button is clicked in To do.jsp is clicked.
    //This method in controller is associated to GET
    //This method shows the To do page with the To do item chosen for update from the TodoList.
    @RequestMapping(value="/update-todo", method=RequestMethod.GET)
    public String showUpdateTodoPage (@RequestParam int id, ModelMap modelMap)
    {
        logger.debug("Into Todo Update");
        logger.debug("ID against the deleted row:" + id);
        ToDo toDo = toDoService.fetchToDoByID(id);
        modelMap.put("todo", toDo);
        return "Todo";
    }

    //The RequestMapping maps to the POST method of /update-to do. It is called when the user clicks on Submit after updating the description of a To Do
    @RequestMapping(value="/update-todo", method= RequestMethod.POST)
    public String updateTodo (HttpSession httpSession, ModelMap modelMap, @Valid ToDo toDo, BindingResult result)
    {
        logger.debug("In the POST controller method of update-todo");
        logger.debug("Todo Description:" + toDo.getToDoDescription());

        //If there is a validation error from the bean, do not invoke addTodo. Stay in the current page.

        if (result.hasErrors())
        {
            logger.debug("There is a validation error, so return to Todo JSP page");
            String objectName = result.toString();
            System.out.println("ObjectName:" + objectName);
            modelMap.put("todo", new ToDo(0,(String) httpSession.getAttribute("name"),toDo.getToDoDescription(), LocalDate.now(), false ));
            return "Todo";
        }

        
        String userName = (String) httpSession.getAttribute("name");
        String newDescription = toDo.getToDoDescription();
        LocalDate newDate = toDo.getToDoByDate();
        int toDoId = toDo.getToDoId();
        List todoList = toDoService.updateTodo(userName, toDoId, newDescription, newDate);
        modelMap.put("todo", todoList);
        return "TodoList";
    }


}
