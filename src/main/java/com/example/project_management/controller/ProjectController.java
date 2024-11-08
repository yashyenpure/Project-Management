package com.example.project_management.controller;


import com.example.project_management.bean.*;
import com.example.project_management.entity.Projects;
import com.example.project_management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/createProject")
    public Projects createProject(@RequestBody ProjectRequestBean projectRequestBean){

        Projects projects = new Projects();
        projects = projectService.createProject(projectRequestBean);
        return projects;


    }

    @GetMapping("/projects")
    public List<ProjectBean> getProjects(){

        List<ProjectBean> projectBeans = new ArrayList<>();
        projectBeans = projectService.getProject();
        return projectBeans;

    }

    @DeleteMapping("deleteProject/{id}")
    public DeleteProjectResponseBean deleteProjectResponseBean(@PathVariable Integer id){

        DeleteProjectResponseBean deleteProjectResponseBean = new DeleteProjectResponseBean();
        deleteProjectResponseBean = projectService.deleteProject(id);
        return deleteProjectResponseBean;

    }

}
