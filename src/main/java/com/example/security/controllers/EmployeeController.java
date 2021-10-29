package com.example.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.Employee;
import com.example.security.models.Member;
import com.example.security.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public ResponseEntity<List<Employee>> getAll(){
		return ResponseEntity.ok(employeeService.getAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.addEmployee(employee));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/employee/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId){
		return ResponseEntity.ok(employeeService.getEmployee(employeeId));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{employeeId}")
	public void deleteEmployee(@PathVariable Long employeeId){
		employeeService.deleteEmployee(employeeId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employeeDetail){
		try {
			return ResponseEntity.ok(employeeService.updateEmployee(employeeId, employeeDetail));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	

	}
	
}
