package com.empstatus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empstatus.model.Address;
import com.empstatus.model.Employee;
import com.empstatus.service.AddressService;
import com.empstatus.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/employees")
	ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>( employeeService.createEmployee(employee), HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.findEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return new ResponseEntity<Employee>( employeeService.findEmployee(id),HttpStatus.OK);
	}
	
	@PutMapping("/employees/{id}")
	ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PatchMapping("/employees/{id}")
	ResponseEntity<Employee> updateEmployeeData(@PathVariable long id, @RequestBody Map<String, Object> employee) {
		return new ResponseEntity<Employee>(employeeService.patch(id, employee), HttpStatus.OK);
	}
	
	
	@PutMapping("/employees/{id}/address/{address_id}")
	ResponseEntity<Employee> assignDetail(@PathVariable long id, @PathVariable int address_id) {
    	Address address = addressService.findAddress(address_id); 
    	System.out.println(address);
    	return new ResponseEntity<Employee>(employeeService.assignProfile(id, address), HttpStatus.OK);
    }

}
