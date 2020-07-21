package com.gsu.project.controllers;

import java.util.List;
import com.gsu.project.models.Project;
import com.gsu.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepo;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }

    @RequestMapping(value = "/projects/{name}", method = RequestMethod.GET)
    public List<Project> getAllProjectsByName(@PathVariable String name){
        return projectRepo.findAllByProjectNameContaining(name);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public void addProject(@RequestBody Project project){
        projectRepo.save(project);
    }
}