package com.empstatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empstatus.model.Teams;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}
