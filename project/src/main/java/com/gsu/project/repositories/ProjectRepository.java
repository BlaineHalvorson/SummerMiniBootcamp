package com.gsu.project.repositories;

import java.util.List;

import com.gsu.project.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByProjectNameContaining(String partialName);
}