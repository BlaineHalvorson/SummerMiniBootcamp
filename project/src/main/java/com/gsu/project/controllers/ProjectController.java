package com.gsu.project.controllers;

import java.util.List;
import com.gsu.project.models.Project;
import com.gsu.project.repositories.ProjectRepository;
import com.gsu.project.services.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectController {

    @Autowired
    ProjectServiceImp projectService;

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
        projectService.saveProject(project);
    }

    // PUT
    @RequestMapping(value="/projects", method=RequestMethod.PUT)
    public void updateProject(@PathVariable int id, @RequestBody Project project) {
        projectService.updateProject(id, project);
    }
    

    // DELETE
    @RequestMapping(value="/project/{id}", method=RequestMethod.DELETE)
    public void updateProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }
}