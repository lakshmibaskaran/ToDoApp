package com.lakshmi.springboot.ToDoApp.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class ToDo
{

@Id
@GeneratedValue
//@NotNull
private int toDoId;
private String userName;
@Size(min=10, message = "Description should be at least 10 characters")
private String toDoDescription;
//@FutureOrPresent
private LocalDate toDoByDate;
private boolean toDoActivityFinished;

@Transient
private Logger logger = LoggerFactory.getLogger((getClass()));

    public ToDo(int toDoId, String userName, String toDoDescription, LocalDate toDoByDate, boolean toDoActivityFinished)
    {
        this.toDoId = toDoId;
        this.userName = userName;
        this.toDoDescription = toDoDescription;
        this.toDoByDate = toDoByDate;
        this.toDoActivityFinished = toDoActivityFinished;
    }

    //JPA expects a default constructor for the Entity Bean.
    public ToDo() {
    }


    public int getToDoId()
    {
        return toDoId;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getToDoDescription()
    {
        return toDoDescription;
    }

    public LocalDate getToDoByDate()
    {
        return toDoByDate;
    }

    public boolean isToDoActivityFinished()
    {
        return toDoActivityFinished;
    }

    public void setToDoId(int toDoId)
    {
        this.toDoId = toDoId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setToDoDescription(String toDoDescription)
    {
        this.toDoDescription = toDoDescription;
    }

    public void setToDoByDate(LocalDate toDoByDate)
    {
        this.toDoByDate = toDoByDate;
    }

    public void setToDoActivityFinished(boolean toDoActivityFinished)
    {
        this.toDoActivityFinished = toDoActivityFinished;
    }


}
