package com.gsu.project.controllers;

import com.gsu.project.models.Task;
import com.gsu.project.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;
    
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public void addTask(@RequestBody Task task){
        taskRepo.save(task);
    }

}