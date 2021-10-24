package com.example.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
