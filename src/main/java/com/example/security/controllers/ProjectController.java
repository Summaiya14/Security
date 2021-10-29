package com.example.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.Employee;
import com.example.security.models.Project;
import com.example.security.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/projects")
	public ResponseEntity<List<Project>> getAll(){
		return ResponseEntity.ok(projectService.getAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/project")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		return ResponseEntity.ok(projectService.addProject(project));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable Long projectId){
		return ResponseEntity.ok(projectService.getProject(projectId));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/project/{projectId}")
	public void deleteProject(@PathVariable Long projectId){
		projectService.deleteProject(projectId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectId}")
	public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestBody Project projectDetail){
		try {
			return ResponseEntity.ok(projectService.updateProject(projectId, projectDetail));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	

	}
	
	
}
