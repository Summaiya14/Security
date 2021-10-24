package com.example.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.models.Locker;
import com.example.security.repositories.LockerRepository;

@Service
public class LockerService {

	@Autowired
	LockerRepository lockerRepository;
	
	public List<Locker> getAll(){
		return lockerRepository.findAll();
	}
	
	public Locker addLocker(Locker locker) {
		lockerRepository.save(locker);
		return locker;
	}
	
	public Locker getLocker(long lockerId) {
		Optional<Locker> locker = lockerRepository.findById(lockerId);
		return locker.get();
	}
	
	public void deleteLocker(long lockerId) {
		Optional<Locker> locker = lockerRepository.findById(lockerId);
		lockerRepository.delete(locker.get());	
	}
	
	public Locker updateLocker(long lockerId, Locker lockerDetail) {
		Optional<Locker> lockerData = lockerRepository.findById(lockerId);		
		Locker locker = lockerData.get();
		locker.setNumber(lockerDetail.getNumber());
		lockerRepository.save(locker);
		return locker;
	}

	
}
