package com.example.security.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LockerType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lockerTypeId;
	private String type = "Basic";
	private String status;
	
	public LockerType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LockerType(Long lockerTypeId, String type, String status) {
		super();
		this.lockerTypeId = lockerTypeId;
		this.type = type;
		this.status = status;
	}

	public Long getLockerTypeId() {
		return lockerTypeId;
	}

	public void setLockerTypeId(Long lockerTypeId) {
		this.lockerTypeId = lockerTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LockerType [lockerTypeId=" + lockerTypeId + ", type=" + type + ", status=" + status + "]";
	}
	
	
	
}
