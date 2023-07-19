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

import com.empstatus.model.Employee;
import com.empstatus.model.Teams;
import com.empstatus.service.EmployeeService;
import com.empstatus.service.TeamsService;

import jakarta.validation.Valid;

@RestController
public  class TeamsController {
	
	@Autowired
	public TeamsService teamsService;
	
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping("/teams")
	ResponseEntity<Teams> createTeams(@RequestBody @Valid Teams team) {
		return new ResponseEntity<Teams>(teamsService.createTeam(team), HttpStatus.OK);
	}
	
	@GetMapping("/teams")
	ResponseEntity<List<Teams>> getTeams() {
		return new ResponseEntity<List<Teams>>(teamsService.getTeams(), HttpStatus.OK);
	}
	
	@GetMapping("/teams/{id}")
	ResponseEntity<Teams> getTeam(@PathVariable int id) {
		return new ResponseEntity<Teams>(teamsService.getTeam(id), HttpStatus.OK);
	}
	
	@PutMapping("/teams/{id}")
	ResponseEntity<Teams> updateTeam(@PathVariable int id, @RequestBody Teams team) {
		return new ResponseEntity<Teams>(teamsService.updateTeam((long) id, team), HttpStatus.OK);
	}
	
	@DeleteMapping("/teams/{id}")
	ResponseEntity<Void> deleteTeam(@PathVariable int id) {
		teamsService.deleteTeam(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("/teams/{id}")
	ResponseEntity<Teams> updateTeamsData(@PathVariable int id, @RequestBody Map<String, Object> team) {
		return new ResponseEntity<Teams>(teamsService.patch(id, team), HttpStatus.OK);
	}
	
	@PutMapping("/teams/{id}/employee/{emp_id}")
	ResponseEntity<Teams> addEmployee(@PathVariable long id, @PathVariable int emp_id) {
    	Employee emp = employeeService.findEmployee(emp_id); 
    	return new ResponseEntity<Teams>(teamsService.addEmployee((int)id, emp), HttpStatus.OK);
    }
	
	@PutMapping("/teams/{id}/remove_employee/{emp_id}")
	ResponseEntity<Teams> removeAddress(@PathVariable long id, @PathVariable int emp_id) {
    	Employee emp = employeeService.findEmployee(emp_id); 
    	return new ResponseEntity<Teams>(teamsService.removeEmployee((int)id, emp), HttpStatus.OK);
    }

}
