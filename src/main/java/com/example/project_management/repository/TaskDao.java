package com.example.project_management.repository;

import com.example.project_management.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Tasks , Integer> {

    @Query("SELECT m from Tasks m where m.projectId = :projectId")
    List<Tasks> fetchTasksByProjectId(Integer projectId);
}
