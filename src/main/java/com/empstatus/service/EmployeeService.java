package com.empstatus.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.empstatus.model.Address;
import com.empstatus.model.Employee;
import com.empstatus.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	// Post Operation
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// Get Operation - get all employees
	public List<Employee> findEmployees() {
		return employeeRepository.findAll();
	}

	// Get Operation - get employee with an id
	public Employee findEmployee(int id) {
		return employeeRepository.findById(id).get();
	}

	// Put Operation
	public Employee updateEmployee(Long id, Employee employee) {
		employee.setId(id);
		return employeeRepository.save(employee);
	}

	// Delete Operation
	public void deleteEmployee(int id) {
		employeeRepository.delete(employeeRepository.findById(id).get());
	}

	// Patch Operation
	public Employee patch(Long id, Map<String, Object> tempEmployee) {

		Optional<Employee> employee = employeeRepository.findById(id);
		tempEmployee.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Employee.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, employee.get(), value);
		});

		return employeeRepository.save(employee.get());
	}
	
	public Employee assignProfile(Long id, Address address) {
		Employee employee = employeeRepository.findById(id).get();
		employee.setAddress(address);
		return employeeRepository.save(employee);
	}

}
