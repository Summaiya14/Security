package com.example.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.security.models.Locker;
import com.example.security.models.Member;
import com.example.security.repositories.LockerRepository;
import com.example.security.repositories.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	Locker locker;
	
	public List<Member> getAll(){
		return memberRepository.findAll();
	}
	
	public Member addMember(Member member) {
		memberRepository.save(member);
		return member;
	}
	
	public Member getMember(long memberId) {
		Optional<Member> member = memberRepository.findById(memberId);
		return member.get();
	}
	
	public void deleteMember(long memberId) {
		Optional<Member> member = memberRepository.findById(memberId);
		memberRepository.delete(member.get());	
	}
	
	public Member updateMember(long memberId, Member memberDetail) {
		Optional<Member> memberData = memberRepository.findById(memberId);
		System.out.println(memberData.get().getLocker());
		if (memberData.get().getLocker() != null) {
			System.out.println("Already locker assigned!");
			return memberDetail;
		} 
		Member member = memberData.get();
		member.setName(memberDetail.getName());
		member.setEmail(memberDetail.getEmail());
		member.setPhone(memberDetail.getPhone());
		member.setLocker(memberDetail.getLocker());
		memberRepository.save(member);
		return member;
	}

}
