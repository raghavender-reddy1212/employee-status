package com.empstatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empstatus.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
