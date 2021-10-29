package com.example.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.models.Employee;
import com.example.security.models.Member;
import com.example.security.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	public Employee getEmployee(long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		return employee.get();
	}
	
	public void deleteEmployee(long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		employeeRepository.delete(employee.get());	
	}
	
	public Employee updateEmployee(long employeeId, Employee employeeDetail) {
		Optional<Employee> employeeData = employeeRepository.findById(employeeId);
		Employee employee = employeeData.get();
		employee.setName(employeeDetail.getName());
		employee.setEmail(employeeDetail.getEmail());
		employee.setPhone(employeeDetail.getPhone());
		employee.setProjects(employeeDetail.getProjects());
		employeeRepository.save(employee);
		return employee;
	}
	
}
