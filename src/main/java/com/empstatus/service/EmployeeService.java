package com.empstatus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empstatus.model.Employee;
import com.empstatus.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);

	}

	public List<Employee> findEmployees() {

		return employeeRepository.findAll();

	}

	public Employee findEmployee(int id) {
		
		Optional<Employee> temp = employeeRepository.findById(id);
		return temp.get();
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		//Optional<Employee> temp = employeeRepository.findById(id);
		employee.setId(id);
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.delete(employeeRepository.findById(id).get());
	}
}
