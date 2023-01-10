package com.lakshmi.springboot.ToDoApp.Service;

import com.lakshmi.springboot.ToDoApp.Model.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class ToDoService
{
//A To do Service that adds static values to ToDo List

    private Logger logger = LoggerFactory.getLogger((getClass()));
    private List<ToDo> toDoList = new ArrayList<ToDo>();

    //Set the ToDo List

    //Static value for Todolist ID
    static int todoListID=0;

    public List getToDoList()
    {
        logger.debug("Into ToDoService.getToDoList");
        toDoList.add(new ToDo(++todoListID, "Nisha", "Chess game", LocalDate.now().plusDays(1), false));
        toDoList.add(new ToDo(++todoListID, "Nisha", "Chess puzzle", LocalDate.now().plusDays(2), false));
        toDoList.add(new ToDo(++todoListID, "Nisha", "Have fun", LocalDate.now().plusDays(3), false));
        return toDoList;
    }

    //Get Todos based on UserId
    public List<ToDo> getTodosByUserId(String userid)
    {
        //Create a predicate that is a Lambda function that gets the list of todos based on the userid
        logger.debug("Extracting Todos for user:" + userid);
        toDoList = getToDoList();
        Predicate<? super ToDo> predicate = toDo -> toDo.getUserName().equalsIgnoreCase(userid);
        int numberOfTodos = toDoList.stream().filter(predicate).toList().size();
        return toDoList.stream().filter(predicate).toList();
    }

    public List addToDo(String userName, String description, LocalDate toDoByDate)
    {
        logger.debug("Into ToDoService.addToDo");
        logger.debug("Username: " + userName);
        logger.debug("Description:" + description);
        toDoList.add(new ToDo(++todoListID, userName, description,toDoByDate,false ));
        logger.debug("Total number of Todos:" + toDoList.size());
        return toDoList;
    }


    public void deleteToDo(int id)
    {
        logger.debug("Into ToDoService.deleteToDo");
        toDoList.remove(id-1);
    }

    //This method is called when Update button is clicked on the To Do List UI and to find the respective To do and display in the to do.jsp
    public ToDo fetchToDoByID(int id)
    {
        logger.debug("Into getTodo in TodoService.java");
        //Predicate is a Lambda function that gets a record from the List based on a column.
        Predicate<? super ToDo> predicate = toDo -> toDo.getToDoId() == id;
        ToDo toDo = toDoList.stream().filter(predicate).findFirst().get();
        return toDo;
    }

    //Called when a description of To do is updated from the front end
    public List updateTodo(String userName, int toDoId, String newToDoDescription, LocalDate newToDoDate)
    {
        logger.debug("ToDo ID to be updated:" + toDoId);
        logger.debug("New description:" + newToDoDescription);
        //On the To Do "List", identify the one with the id (used id-1 as the index starts with zero), and update with the new Description
        toDoList.set(toDoId-1, new ToDo(toDoId,userName, newToDoDescription, newToDoDate,false));
        return toDoList;
    }
}
