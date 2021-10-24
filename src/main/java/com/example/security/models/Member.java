package com.example.security.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	private String name;
	private String email;
	private String phone;
	private Date createdDate = new Date();
	
	@OneToOne(targetEntity = Locker.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "locker_id")
	private Locker locker;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(Long memberId, String name, String email, String phone, Date createdDate) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.createdDate = createdDate;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", createdDate=" + createdDate + "]";
	}
	
	public Locker getLocker() {
		return locker;
	}
	
	public void setLocker(Locker locker) {
		this.locker = locker;
	}
	
}
