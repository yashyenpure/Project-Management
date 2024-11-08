package com.example.project_management.bean;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskResponseBean {
    public Integer taskId;
    public String text;
    public Integer projectId;
}
