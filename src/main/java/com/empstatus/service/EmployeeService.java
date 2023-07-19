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
import com.empstatus.repository.AddressRepository;
import com.empstatus.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public AddressRepository addressRepository;
	
	@PersistenceContext
	EntityManager entityManager;

	// Post Operation
	public Employee createEmployee(Employee employee) {
		
		addressRepository.saveAll(employee.getAddress());
		return employeeRepository.save(employee);
	}

	// Get Operation - get all employees
	public List<Employee> findEmployees() {
		TypedQuery<Employee> getAll = entityManager.createNamedQuery("getAllEmployees", Employee.class);
		return getAll.getResultList();
		//return employeeRepository.findAll();
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
		Employee emp = employeeRepository.findById(id).get();
		emp.setDelete(true);
		employeeRepository.save(emp);
		//employeeRepository.delete(employeeRepository.findById(id).get());
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
	
	public Employee addAddress(Long id, Address address) {
		Employee employee = employeeRepository.findById(id).get();
		employee.addAddresses(address);
		return employeeRepository.save(employee);
	}
	
	public Employee removeAddress(Long id, Address address) {
		Employee employee = employeeRepository.findById(id).get();
		employee.removeAddress(address);
		return employeeRepository.save(employee);
	}

}
