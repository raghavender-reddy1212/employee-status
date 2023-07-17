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
import com.empstatus.model.Employee;
import com.empstatus.model.Vendor;
import com.empstatus.service.ContactService;
import com.empstatus.service.EmployeeService;
import com.empstatus.service.VendorService;

import jakarta.validation.Valid;

@RestController
public class VendorController {
	
	@Autowired
	public VendorService vendorService;
	
	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public ContactService contactService;
	
	@PostMapping("/vendors")
	ResponseEntity<Vendor> createVendor(@RequestBody @Valid Vendor vendor) {
		return new ResponseEntity<Vendor>(vendorService.createVendor(vendor), HttpStatus.OK);
	}
	
	@GetMapping("/vendors")
	ResponseEntity<List<Vendor>> getVendors() {
		return new ResponseEntity<List<Vendor>>(vendorService.findVendors(), HttpStatus.OK);
	}
	
	@GetMapping("/vendors/{id}")
	ResponseEntity<Vendor> getVendor(@PathVariable int id) {
		return new ResponseEntity<Vendor>(vendorService.findVendor(id), HttpStatus.OK);
	}
	
	@PutMapping("/vendors/{id}")
	ResponseEntity<Vendor> updateVendor(@PathVariable int id, @RequestBody Vendor vendor) {
		return new ResponseEntity<Vendor>(vendorService.updateVendor(id, vendor), HttpStatus.OK);
	}
	
	@DeleteMapping("/vendors/{id}")
	ResponseEntity<Void> deleteVendor(@PathVariable int id) {
		vendorService.deleteVendor(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("/vendors/{id}")
	ResponseEntity<Vendor> updateVendorData(@PathVariable long id, @RequestBody Map<String, Object> vendor) {
		return new ResponseEntity<Vendor>(vendorService.patch(id, vendor), HttpStatus.OK);
	}
	
	
	  @PutMapping("/vendors/{id}/employees/{employee_id}") ResponseEntity<Vendor>
	  addEmployee(@PathVariable long id, @PathVariable long employee_id) { Employee
	  employee = employeeService.findEmployee((int) id); return new
	  ResponseEntity<Vendor>(vendorService.addEmployee((int) id, employee),
	  HttpStatus.OK);
	  
	  }
	  
	  @PutMapping("/vendors/{id}/remove_employees/{employee_id}")
	  ResponseEntity<Vendor> removeEmployee(@PathVariable long id, @PathVariable
	  long employee_id) { Employee employee = employeeService.findEmployee((int)
	  id); return new ResponseEntity<Vendor>(vendorService.removeEmployee((int) id,
	  employee), HttpStatus.OK);
	  
	  }
	  
	  @PutMapping("/vendors/{id}/contacts/{contact_id}") ResponseEntity<Vendor>
	  addContact(@PathVariable long id, @PathVariable long contact_id) { Contact
	  contact = contactService.findContact((int)id); return new
	  ResponseEntity<Vendor>(vendorService.addContact((int) id, contact),
	  HttpStatus.OK); }
	  
	  @PutMapping("/vendors/{id}/remove_contacts/{contact_id}")
	  ResponseEntity<Vendor> removeContact(@PathVariable long id, @PathVariable
	  long contact_id) { Contact contact = contactService.findContact((int)id);
	  return new ResponseEntity<Vendor>(vendorService.removeContact((int) id,
	  contact), HttpStatus.OK); }
	 
}
