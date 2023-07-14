package com.empstatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empstatus.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
