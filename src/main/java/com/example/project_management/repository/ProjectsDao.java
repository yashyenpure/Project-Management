package com.example.project_management.repository;

import com.example.project_management.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectsDao extends JpaRepository<Projects , Integer> {

}
