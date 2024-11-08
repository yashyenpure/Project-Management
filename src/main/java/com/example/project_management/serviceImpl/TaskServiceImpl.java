package com.example.project_management.serviceImpl;

import com.example.project_management.bean.CreateTaskRequestBean;
import com.example.project_management.bean.CreateTaskResponseBean;
import com.example.project_management.bean.DeleteTaskResponseBean;
import com.example.project_management.entity.Tasks;
import com.example.project_management.repository.TaskDao;
import com.example.project_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;
    @Override
    public CreateTaskResponseBean createTask(CreateTaskRequestBean createTaskRequestBean , Integer projectId) {

        String text = createTaskRequestBean.text;
        Tasks tasks = new Tasks();
        tasks.setText(text);
        tasks.setProjectId(projectId);
        tasks  = taskDao.save(tasks);

        CreateTaskResponseBean createTaskResponseBean = new CreateTaskResponseBean();
        createTaskResponseBean.setTaskId(tasks.getTaskId());
        createTaskResponseBean.setText(tasks.getText());
        createTaskResponseBean.setProjectId(tasks.getProjectId());
        return createTaskResponseBean;


    }

    @Override
    public List<Tasks> fetchTasks(Integer projectId) {
        List<Tasks> tasks = taskDao.fetchTasksByProjectId(projectId);
        return tasks;

        }

    @Override
    public DeleteTaskResponseBean deleteTask(Integer taskId) {
        DeleteTaskResponseBean deleteTaskResponseBean = new DeleteTaskResponseBean();
        try {
            taskDao.deleteById(taskId);
            deleteTaskResponseBean.setMessage("Deleted Successfully");
        }
        catch (Exception e){
            deleteTaskResponseBean.setMessage("Delete failed");
        }
        return deleteTaskResponseBean;

    }
}

