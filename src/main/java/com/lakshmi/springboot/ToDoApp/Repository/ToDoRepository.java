package com.lakshmi.springboot.ToDoApp.Repository;

import com.lakshmi.springboot.ToDoApp.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ToDoRepository extends JpaRepository<ToDo, Integer>
{
    public List<ToDo> findByUserName(String userName);

}
