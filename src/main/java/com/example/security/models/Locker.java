package com.example.security.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lockerId;
	private Integer number;
	private Date createdDate = new Date();
	
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "locker")
	//private Member member;
	
	public Locker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Locker(Long lockerId, Integer number, Date createdDate) {
		super();
		this.lockerId = lockerId;
		this.number = number;
		this.createdDate = createdDate;
	}

	public Long getLockerId() {
		return lockerId;
	}

	public void setLockerId(Long lockerId) {
		this.lockerId = lockerId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", number=" + number + ", createdDate=" + createdDate + "]";
	}
	
	
	
	
}
