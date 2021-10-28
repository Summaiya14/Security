package com.example.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.Member;
import com.example.security.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/members")
	public ResponseEntity<List<Member>> getAll(){
		return ResponseEntity.ok(memberService.getAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/member")
	public ResponseEntity<Member> addMember(@RequestBody Member member){
		return ResponseEntity.ok(memberService.addMember(member));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/member/{memberId}")
	public ResponseEntity<Member> getMember(@PathVariable Long memberId){
		return ResponseEntity.ok(memberService.getMember(memberId));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/member/{memberId}")
	public void deleteMember(@PathVariable Long memberId){
		memberService.deleteMember(memberId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/member/{memberId}")
	public ResponseEntity<Member> updateMember(@PathVariable Long memberId, @RequestBody Member memberDetail){
		try {
			return ResponseEntity.ok(memberService.updateMember(memberId, memberDetail));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	

	}
	
}
