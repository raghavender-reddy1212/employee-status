package com.empstatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empstatus.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
