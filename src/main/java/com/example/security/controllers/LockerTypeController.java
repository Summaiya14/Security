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

import com.example.security.models.LockerType;
import com.example.security.models.Member;
import com.example.security.service.LockerTypeService;

@RestController
public class LockerTypeController {
	
	@Autowired
	LockerTypeService lockerTypeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/lockertypes")
	public ResponseEntity<List<LockerType>> getAll(){
		return ResponseEntity.ok(lockerTypeService.getAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/lockertype")
	public ResponseEntity<LockerType> addLockerType(@RequestBody LockerType lockerType){
		return ResponseEntity.ok(lockerTypeService.addLockerType(lockerType));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/lockertype/{lockerTypeId}")
	public ResponseEntity<LockerType> getLockerType(@PathVariable Long lockerTypeId){
		return ResponseEntity.ok(lockerTypeService.getLockerType(lockerTypeId));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/lockertype/{lockerTypeId}")
	public void deleteLockerType(@PathVariable Long lockerTypeId){
		lockerTypeService.deleteLockerType(lockerTypeId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/lockertype/{lockerTypeId}")
	public ResponseEntity<LockerType> updateLockerType(@PathVariable Long lockerTypeId, @RequestBody LockerType lockerTypeDetail){
		try {
			return ResponseEntity.ok(lockerTypeService.updateLockerType(lockerTypeId, lockerTypeDetail));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	

	}
	
}
