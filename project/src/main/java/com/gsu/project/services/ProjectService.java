package com.gsu.project.services;

import com.gsu.project.models.Project;

public interface ProjectService {
    public void saveProject(Project project);

    public void updateProject(int id, Project project);

    public void deleteProject(int id);
}