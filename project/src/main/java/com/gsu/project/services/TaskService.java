package com.gsu.project.services;

import com.gsu.project.models.Task;

public interface TaskService {
    public void saveTask(Task task);

    public void updateTask(int id, Task task);

    public void deleteTask(int id);
}