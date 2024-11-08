package com.example.project_management.service;

import com.example.project_management.bean.CreateTaskRequestBean;
import com.example.project_management.bean.CreateTaskResponseBean;
import com.example.project_management.bean.DeleteTaskResponseBean;
import com.example.project_management.entity.Tasks;

import java.util.List;

public interface TaskService {

    CreateTaskResponseBean createTask(CreateTaskRequestBean createTaskRequestBean , Integer projectId);

    List<Tasks> fetchTasks(Integer projectId);

    DeleteTaskResponseBean deleteTask(Integer taskId);

}
