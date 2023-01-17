package com.lakshmi.springboot.ToDoApp.Service;

import com.lakshmi.springboot.ToDoApp.Model.ToDo;
import com.lakshmi.springboot.ToDoApp.Repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
@RequiredArgsConstructor //Use the annotation for lambok dependency injection
public class ToDoService
{
//A To do Service that adds static values to ToDo List

    private Logger logger = LoggerFactory.getLogger((getClass()));
    private List<ToDo> toDoList = new ArrayList<ToDo>();

    //Instantiate ToDoRepository so that the Business Service can access the methods in Repository
    //ToDoRepository is defined as private final to align with the needs of lombok RequiredArgsConstructor annotation
    private final ToDoRepository toDoRepository;


    //Set the ToDo List

    //Static value for Todolist ID
    static int todoListID=0;

     /*
     //This method is deprecated in exchange of getTodosByUserId
    public List getToDoList()
    {
        logger.debug("Into ToDoService.getToDoList");

        toDoList.add(new ToDo(++todoListID, "Nisha", "Chess game", LocalDate.now().plusDays(1), false));
        toDoList.add(new ToDo(++todoListID, "Nisha", "Chess puzzle", LocalDate.now().plusDays(2), false));
        toDoList.add(new ToDo(++todoListID, "Nisha", "Have fun", LocalDate.now().plusDays(3), false);

        //To get the list of Todos from the database
        toDoRepository.findByUserName("Nisha");
        return toDoList;
    }
    */


    //Get Todos based on UserId
    public List<ToDo> getTodosByUserId(String userName)
    {
        //Create a predicate that is a Lambda function that gets the list of todos based on the userid
        logger.debug("Extracting Todos for user:" + userName);

        /*
        //Removed because you don't need the predicate as you are no longer fetching from the static List.
        toDoList = getToDoList();
        Predicate<? super ToDo> predicate = toDo -> toDo.getUserName().equalsIgnoreCase(userid);
        int numberOfTodos = toDoList.stream().filter(predicate).toList().size();
        return toDoList.stream().filter(predicate).toList();
         */

        //To get the list of Todos from the database, call the findByUserName method in toDoRepository
        List <ToDo> toDoList = toDoRepository.findByUserName(userName);
        return toDoList;
    }

    public void addToDo(ToDo todo) {
        logger.debug("Description:" + todo.getToDoDescription());
        logger.debug("Target Date:" + todo.getToDoByDate());
        logger.debug("Todo id:" + todo.getToDoId());
        logger.debug("Todo Activity status:" + todo.isToDoActivityFinished());
        logger.debug("Username:" + todo.getUserName());
        toDoRepository.save(todo);
    }

    public void deleteToDo(int id)
    {
        logger.debug("Into ToDoService.deleteToDo");
        toDoRepository.deleteById(id);
        //toDoList.remove(id-1);
    }

    //This method is called when Update button is clicked on the To Do List UI and to find the respective To do and display in the to do.jsp
    public ToDo fetchToDoByID(int id)
    {
        logger.debug("Into getTodo in TodoService.java");
        /*
        //Predicate is a Lambda function that gets a record from the List based on a column.
        Predicate<? super ToDo> predicate = toDo -> toDo.getToDoId() == id;
        ToDo toDo = toDoList.stream().filter(predicate).findFirst().get();
        */

        //toDoRepository.findById(id).get();
        return toDoRepository.findById(id).get();
    }

    /*
    //Called when a description of To do is updated from the front end
    public List updateTodo(String userName, int toDoId, String newToDoDescription, LocalDate newToDoDate)
    {
        logger.debug("ToDo ID to be updated:" + toDoId);
        logger.debug("New description:" + newToDoDescription);
        //On the To Do "List", identify the one with the id (used id-1 as the index starts with zero), and update with the new Description
        //toDoList.set(toDoId-1, new ToDo(toDoId,userName, newToDoDescription, newToDoDate,false));
        toDoRepository.save(toDo)
        return toDoList;
    }
     */

    public void updateTodo(ToDo toDo)
    {
        logger.debug("Description:" + toDo.getToDoDescription());
        logger.debug("Target Date:" + toDo.getToDoByDate());
        logger.debug("Todo id:" + toDo.getToDoId());
        logger.debug("Todo Activity status:" + toDo.isToDoActivityFinished());
        logger.debug("Username:" + toDo.getUserName());
        toDoRepository.save(toDo);
    }
}
