package com.example.project_management.bean;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjectRequestBean {
    private String title;
    private String description;
    private LocalDate dueDate;



}
