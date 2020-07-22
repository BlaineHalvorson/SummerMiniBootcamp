package com.gsu.project.services;

import java.util.Optional;
import com.gsu.project.models.Task;
import com.gsu.project.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Override
    public void saveTask(Task task) {
        // check if id exists, if yes, throw error, if no, add task
        taskRepo.save(task);
    }

    @Override
    public void updateTask(int id, Task task) {
        Optional<Task> taskOptional = taskRepo.findById(id);
        if (taskOptional.isPresent()) {
            task.setId(taskOptional.get().getId());
            taskRepo.save(task);
        }
    }

    @Override
    public void deleteTask(int id) {
        taskRepo.deleteById(id);
    }
    
}