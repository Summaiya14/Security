package com.example.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.models.LockerType;

@Repository
public interface LockerTypeRepository extends JpaRepository<LockerType, Long>{

}
