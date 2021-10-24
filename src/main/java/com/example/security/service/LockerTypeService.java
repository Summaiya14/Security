package com.example.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.models.LockerType;
import com.example.security.repositories.LockerTypeRepository;

@Service
public class LockerTypeService {

	@Autowired
	LockerTypeRepository lockerTypeRepository;
	
	public List<LockerType> getAll(){
		return lockerTypeRepository.findAll();
	}
	
	public LockerType addLockerType(LockerType lockerType) {
		lockerTypeRepository.save(lockerType);
		return lockerType;
	}
	
	
}
