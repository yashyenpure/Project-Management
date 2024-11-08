package com.example.project_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    public Integer taskId;

    @Column(name = "text")
    public String text;

    @Column(name = "project_Id")
    public Integer projectId;

}
