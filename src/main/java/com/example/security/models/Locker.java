package com.example.security.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Locker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lockerId;
	private Integer number;
	private String status;
	private Date createdDate = new Date();

	@OneToOne(mappedBy = "locker", optional = true, cascade = CascadeType.ALL)
	@JsonBackReference
	private Member member;

	@ManyToOne(targetEntity = LockerType.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "locker_type_id")
	private LockerType lockerType;

	public Locker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Locker(Long lockerId, Integer number, String status, Date createdDate, Member member,
			LockerType lockerType) {
		super();
		this.lockerId = lockerId;
		this.number = number;
		this.status = status;
		this.createdDate = createdDate;
		this.member = member;
		this.lockerType = lockerType;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	
	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", number=" + number + ", status=" + status + ", createdDate="
				+ createdDate + ", member=" + member + ", lockerType=" + lockerType + "]";
	}

	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public LockerType getLockerType() {
		return lockerType;
	}

	public void setLockerType(LockerType lockerType) {
		this.lockerType = lockerType;
	}

}
