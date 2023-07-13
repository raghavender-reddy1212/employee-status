package com.empstatus.service;

import java.util.List;

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
}
