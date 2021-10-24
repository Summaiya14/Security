package com.example.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.LockerType;
import com.example.security.service.LockerTypeService;

@RestController
public class LockerTypeController {
	
	@Autowired
	LockerTypeService lockerTypeService;
	
	@GetMapping("/lockertypes")
	public ResponseEntity<List<LockerType>> getAll(){
		return ResponseEntity.ok(lockerTypeService.getAll());
	}
	
	@PostMapping("/lockertype")
	public ResponseEntity<LockerType> addLockerType(@RequestBody LockerType lockerType){
		return ResponseEntity.ok(lockerTypeService.addLockerType(lockerType));
	}
	
}
