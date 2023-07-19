package com.empstatus.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Teams")
@NamedQuery(name = "getAllTeams", query = "Select t from Teams t where isDelete = false")
public class Teams {
	
	@NotEmpty(message = "Team Name Cannot be Empty")
	@Column(unique = true)
	public String teamName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	public boolean isDelete = false;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id")
	private List<Employee> employees = new ArrayList<>();
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployeeToTeam(Employee emp) {
		employees.add(emp);
	}
	
	public void removeEmployeeFromTeam(Employee emp) {
		if(employees != null)
			employees.remove(emp);
	}
	
}
