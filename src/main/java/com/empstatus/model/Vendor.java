package com.empstatus.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "Vendor")
@NamedQuery(name = "getAllVendors", query = "Select v from Vendor v where isDelete = false")
public class Vendor {
	
	@NotEmpty(message = "Vendor Name Cannot be Empty")
	@Column(unique = true)
	public String vendorName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public boolean isClient;
	public boolean isDelete = false;
	public long parentId = 0;
	
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	 @JoinColumn(name = "contact_vendor_id") 
	 private List<Contact> contact = new ArrayList<>();
	 
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	 @JoinColumn(name = "emp_vendor_id") 
	 private List<Employee> employee = new ArrayList<>();
	 
	 @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	 @JoinColumn(name = "vendor_address_id", referencedColumnName = "id")
	 private Address address;

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isClient() {
		return isClient;
	}

	public void setClient(boolean isClient) {
		this.isClient = isClient;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public List<Contact> getContact() { 
		return contact; 
	}
	  
	public void setContact(List<Contact> contact) { 
		this.contact = contact; 
	}
	
	public List<Employee> getEmployee() { 
		return employee; 
	}
	  
	public void setEmployee(List<Employee> employee) { 
		this.employee = employee;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addContact(Contact cont) { 
		contact.add(cont); 
	}
	  
	public void removeContact(Contact cont) { 
		if (contact != null)
			contact.remove(cont); 
	}
	 
	public void addEmployee(Employee emp) { 
		employee.add(emp); 
	}
	  
	public void removeEmployee(Employee emp) { 
		if (employee != null)
			employee.remove(emp); 
	}

}
