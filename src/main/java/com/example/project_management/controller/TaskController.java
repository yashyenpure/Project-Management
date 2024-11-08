package com.example.project_management.controller;


import com.example.project_management.bean.CreateTaskRequestBean;
import com.example.project_management.bean.CreateTaskResponseBean;
import com.example.project_management.bean.DeleteTaskResponseBean;
import com.example.project_management.entity.Tasks;
import com.example.project_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("projects/{projectId}/tasks")
    public CreateTaskResponseBean createTask(@RequestBody CreateTaskRequestBean createTaskRequestBean , @PathVariable Integer projectId){
        CreateTaskResponseBean createTaskResponseBean = new CreateTaskResponseBean();
        createTaskResponseBean = taskService.createTask(createTaskRequestBean , projectId);
        return createTaskResponseBean;

    }
    @GetMapping("projects/{projectId}/tasks")
    public List<Tasks> fetchTasks(@PathVariable Integer projectId){
        List<Tasks> result = taskService.fetchTasks(projectId);
        return result;

    }

    @DeleteMapping("deleteTask/{taskId}")
    public DeleteTaskResponseBean deleteTask(@PathVariable Integer taskId){

        DeleteTaskResponseBean deleteTaskResponseBean = taskService.deleteTask(taskId);
        return deleteTaskResponseBean;

    }

}
