package com.gsu.project.services;

import java.util.Optional;
import com.gsu.project.models.Project;
import com.gsu.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Override
    public void saveProject(Project project) {
        // check if id exists, if yes, throw error, if no, add project
        projectRepo.save(project);
    }

    @Override
    public void updateProject(int id, Project project) {
        Optional<Project> projectOptional = projectRepo.findById(id);
        if (projectOptional.isPresent()) {
            project.setId(projectOptional.get().getId());
            projectRepo.save(project);
        }
    }

    @Override
    public void deleteProject(int id) {
        projectRepo.deleteById(id);
    }
    
}