package com.example.project_management.serviceImpl;

import com.example.project_management.bean.*;
import com.example.project_management.entity.Projects;
import com.example.project_management.repository.ProjectsDao;
import com.example.project_management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectsDao projectsDao;
    @Override
    public Projects createProject(ProjectRequestBean projectRequestBean) {

        String title = projectRequestBean.getTitle();
        String description = projectRequestBean.getDescription();
        LocalDate dueDate = projectRequestBean.getDueDate();
        Projects projectResponse = new Projects();

        Projects projects = new Projects();
        projects.setDescription(description);
        projects.setTitle(title);
        projects.setDueDate(dueDate);
        projectResponse = projectsDao.save(projects);

        return projectResponse;





    }

    @Override
    public List<ProjectBean> getProject() {
        List<ProjectBean> projectBeans = new ArrayList<>();
        List<Projects> projects = new ArrayList<>();
        projects = projectsDao.findAll();
        for (Projects proj : projects){
            ProjectBean projectBean = new ProjectBean();
            projectBean.setDescription(proj.getDescription());
            projectBean.setTitle(proj.getTitle());
            projectBean.setId(proj.getProjectId());
            projectBeans.add(projectBean);

        }
        return projectBeans;

    }

    @Override
    public DeleteProjectResponseBean deleteProject(Integer id) {
        DeleteProjectResponseBean deleteProjectResponseBean = new DeleteProjectResponseBean();
        try {
            projectsDao.deleteById(id);
            deleteProjectResponseBean.setMessage("Deleted Successfully");
            return deleteProjectResponseBean;
        }
        catch (Exception e){
            deleteProjectResponseBean.setMessage("Delete Failed");
            return deleteProjectResponseBean;
        }

    }
}
