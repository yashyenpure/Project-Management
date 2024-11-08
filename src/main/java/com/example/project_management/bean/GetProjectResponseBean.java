package com.example.project_management.bean;


import com.example.project_management.entity.Projects;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetProjectResponseBean {
    List<Projects> projects;

}
