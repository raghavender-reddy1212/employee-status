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

import com.empstatus.model.Contact;
import com.empstatus.service.ContactService;

import jakarta.validation.Valid;

@RestController
public class ContactController {
	
	@Autowired
	public ContactService contactService;
	
	@PostMapping("/contacts")
	ResponseEntity<Contact> createContact(@RequestBody @Valid Contact contact) {
		return new ResponseEntity<Contact>(contactService.createContact(contact), HttpStatus.OK);
	}
	
	@GetMapping("/contacts/{id}")
	ResponseEntity<Contact> findContact(@PathVariable int id) {
		return new ResponseEntity<Contact>(contactService.findContact(id), HttpStatus.OK);
	}
	
	@GetMapping("/contacts")
	ResponseEntity<List<Contact>> findContacts() {
		return new ResponseEntity<List<Contact>>(contactService.findContacts(), HttpStatus.OK);
	}

	@PutMapping("/contacts/{id}")
	ResponseEntity<Contact> updateContact(@PathVariable int id, @RequestBody Contact contact) {
		return new ResponseEntity<Contact>(contactService.updateContact(id, contact), HttpStatus.OK);
	}
	
	@DeleteMapping("/contacts/{id}")
	ResponseEntity<Void> deleteContact(@PathVariable int id) {
		contactService.deleteContact(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("/contacts/{id}")
	ResponseEntity<Contact> updateContactData(@PathVariable int id, @RequestBody Map<String, Object> contact) {
		return new ResponseEntity<Contact>(contactService.patch(id, contact), HttpStatus.OK);
	}
}
