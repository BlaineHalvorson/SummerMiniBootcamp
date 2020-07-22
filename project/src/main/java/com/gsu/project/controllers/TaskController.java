package com.gsu.project.controllers;

import com.gsu.project.models.Task;
import com.gsu.project.services.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    TaskServiceImp taskService;

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public void addTask(@RequestBody Task task){
        taskService.saveTask(task);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    public void updateTask(@PathVariable int id, @RequestBody Task task){
        taskService.updateTask(id, task);
    }

}