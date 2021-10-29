package com.example.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
