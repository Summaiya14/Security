package com.example.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.models.LockerType;
import com.example.security.models.Member;
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
	
	public LockerType getLockerType(long lockerTypeId) {
		Optional<LockerType> lockerType = lockerTypeRepository.findById(lockerTypeId);
		return lockerType.get();
	}
	
	public void deleteLockerType(long lockerTypeId) {
		Optional<LockerType> lockerType = lockerTypeRepository.findById(lockerTypeId);
		lockerTypeRepository.delete(lockerType.get());	
	}
	
	public LockerType updateLockerType(long lockerTypeId, LockerType lockerTypeDetail) {
		Optional<LockerType> lockerTypeData = lockerTypeRepository.findById(lockerTypeId);
		LockerType lockerType = lockerTypeData.get();
		lockerType.setType(lockerTypeDetail.getType());
		lockerType.setStatus(lockerTypeDetail.getStatus());
		lockerTypeRepository.save(lockerType);
		return lockerType;
	}
	
}
