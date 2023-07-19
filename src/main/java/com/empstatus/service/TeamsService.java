package com.empstatus.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.empstatus.model.Employee;
import com.empstatus.model.Teams;
import com.empstatus.repository.TeamsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class TeamsService {
	
	@Autowired
	public TeamsRepository teamsRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Teams createTeam(Teams team) {
		return teamsRepository.save(team);
	}
	
	public List<Teams> getTeams() {
		TypedQuery<Teams> getAll = entityManager.createNamedQuery("getAllTeams", Teams.class);
		return getAll.getResultList();
	}
	
	public Teams getTeam(int id) {
		return teamsRepository.findById(id).get();
	}
	
	public Teams updateTeam(Long id, Teams team) {
		team.setId(id);
		return teamsRepository.save(team);
	}
	
	public void deleteTeam(int id) {
		Teams team = teamsRepository.findById(id).get();
		team.setDelete(true);
		teamsRepository.save(team);
	}
	
	public Teams patch(int id, Map<String, Object> tempTeam) {
		Optional<Teams> team = teamsRepository.findById((int)id);
		tempTeam.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Teams.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, team.get(), value);
		});

		return teamsRepository.save(team.get());
	}
	
	public Teams addEmployee(int id, Employee emp) {
		Teams team = teamsRepository.findById(id).get();
		team.addEmployeeToTeam(emp);
		return teamsRepository.save(team);
	}
	
	public Teams removeEmployee(int id, Employee emp) {
		Teams team = teamsRepository.findById(id).get();
		team.removeEmployeeFromTeam(emp);
		return teamsRepository.save(team);
	}

}
