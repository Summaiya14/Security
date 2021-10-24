package com.example.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.models.Locker;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Long>{

}
