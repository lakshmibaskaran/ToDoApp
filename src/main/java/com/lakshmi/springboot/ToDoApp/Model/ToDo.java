package com.lakshmi.springboot.ToDoApp.Model;

import java.time.LocalDate;


public class ToDo
{
private int toDoId;
private String userName;
private String toDoDescription;
private LocalDate toDoByDate;
private boolean toDoActivityFinished;


    public ToDo(int toDoId, String userName, String toDoDescription, LocalDate toDoByDate, boolean toDoActivityFinished) {
        this.toDoId = toDoId;
        this.userName = userName;
        this.toDoDescription = toDoDescription;
        this.toDoByDate = toDoByDate;
        this.toDoActivityFinished = toDoActivityFinished;
    }


    public int getToDoId() {
        return toDoId;
    }

    public String getUserName() {
        return userName;
    }

    public String getToDoDescription() {
        return toDoDescription;
    }

    public LocalDate getToDoByDate() {
        return toDoByDate;
    }

    public boolean isToDoActivityFinished() {
        return toDoActivityFinished;
    }

    public void setToDoId(int toDoId) {
        this.toDoId = toDoId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToDoDescription(String toDoDescription) {
        this.toDoDescription = toDoDescription;
    }

    public void setToDoByDate(LocalDate toDoByDate) {
        this.toDoByDate = toDoByDate;
    }

    public void setToDoActivityFinished(boolean toDoActivityFinished) {
        this.toDoActivityFinished = toDoActivityFinished;
    }


}
