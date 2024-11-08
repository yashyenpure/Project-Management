package com.example.project_management.service;


import com.example.project_management.bean.*;
import com.example.project_management.entity.Projects;

import java.util.List;

public interface ProjectService {

    Projects createProject(ProjectRequestBean projectRequestBean);

    List<ProjectBean> getProject();

    DeleteProjectResponseBean deleteProject(Integer id);

}
