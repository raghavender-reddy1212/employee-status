package com.empstatus.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.empstatus.model.Contact;
import com.empstatus.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	public ContactRepository contactRepository;
	
	// Post Operation
		public Contact createContact(Contact contact) {
			return contactRepository.save(contact);
		}
		
		// Get Operation - get contact with an id
		public Contact findContact(int id) {
			return contactRepository.findById(id).get();
		}
		
		// Get Operation - get all contacts
		public List<Contact> findContacts() {
			return contactRepository.findAll();
		}
		
		// Put Operation
		public Contact updateContact(int id, Contact contact) {
			contact.setId(id);
			return contactRepository.save(contact);
		}
		
		// Delete Operation
		public void deleteContact(int id) {
			contactRepository.delete(contactRepository.findById(id).get());
		}

		// Patch Operation
		public Contact patch(int id, Map<String, Object> tempContact) {

				Optional<Contact> contact = contactRepository.findById(id);
				tempContact.forEach((key, value) -> {
					Field field = ReflectionUtils.findField(Contact.class, key);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, contact.get(), value);
				});
				return contactRepository.save(contact.get());
			}

}
