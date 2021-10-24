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
import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.Locker;
import com.example.security.service.LockerService;

@RestController
public class LockerController {
	
	@Autowired
	LockerService lockerService;
	
	@GetMapping("/lockers")
	public ResponseEntity<List<Locker>> getAll(){
		return ResponseEntity.ok(lockerService.getAll());
	}
	
	@PostMapping("/locker")
	public ResponseEntity<Locker> addLocker(@RequestBody Locker locker){
		return ResponseEntity.ok(lockerService.addLocker(locker));
	}
	
	@GetMapping("/locker/{lockerId}")
	public ResponseEntity<Locker> getLocker(@PathVariable Long lockerId){
		return ResponseEntity.ok(lockerService.getLocker(lockerId));
	}
	
	@DeleteMapping("/locker/{lockerId}")
	public void deleteLocker(@PathVariable Long lockerId){
		lockerService.deleteLocker(lockerId);
	}
	
	@PutMapping("/locker/{lockerId}")
	public ResponseEntity<Locker> updateLocker(@PathVariable Long lockerId, @RequestBody Locker lockerDetail){
		try {
			return ResponseEntity.ok(lockerService.updateLocker(lockerId, lockerDetail));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
