package com.empstatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empstatus.model.Employee;
import com.empstatus.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping(path="/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeeService.createEmployee(employee);
		
	}
	
	@GetMapping(path="/employees")
	
public List<Employee> getEmployees() {
		
		return employeeService.findEmployees();
		
	}

	@GetMapping(path = "/employees/{id}")

	public Employee getEmployee(@PathVariable int id) {

		return employeeService.findEmployee(id);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		
		return employeeService.updateEmployee(id, employee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
	
	

}
