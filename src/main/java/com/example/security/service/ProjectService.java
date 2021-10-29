package com.example.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.models.Project;
import com.example.security.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	public List<Project> getAll(){
		return projectRepository.findAll();
	}
	
	public Project addProject(Project project) {
		projectRepository.save(project);
		return project;
	}
	
	public Project getProject(long projectId) {
		Optional<Project> project = projectRepository.findById(projectId);
		return project.get();
	}
	
	public void deleteProject(long projectId) {
		Optional<Project> project = projectRepository.findById(projectId);
		projectRepository.delete(project.get());	
	}
	
	public Project updateProject(long projectId, Project projectDetail) {
		Optional<Project> projectData = projectRepository.findById(projectId);
		Project project = projectData.get();
		project.setTitle(projectDetail.getTitle());
		projectRepository.save(project);
		return project;
	}
	
	
}
