package com.empstatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empstatus.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
