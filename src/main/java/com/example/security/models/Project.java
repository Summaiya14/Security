package com.example.security.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	private String title;
	private Date createdDate = new Date();
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Long projectId, String title, Date createdDate) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.createdDate = createdDate;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title + ", createdDate=" + createdDate + "]";
	}
			

}
