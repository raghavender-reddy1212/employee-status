package com.empstatus.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "Vendor")
public class Vendor {
	
	@NotEmpty(message = "Vendor Name Cannot be Empty")
	@Column(unique = true)
	public String vendorName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long Id;
	public Boolean is_Client;
	public Long parentId = null;
	
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 @JoinColumn(name = "contact_vendor_id") private List<Contact> contact = new ArrayList<>();
	 
	
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 @JoinColumn(name = "emp_vendor_id") private List<Employee> employee = new ArrayList<>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getVendorName() {
		return vendorName;
	}
	
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public Boolean getIs_Client() {
		return is_Client;
	}
	
	public void setIs_Client(Boolean is_Client) {
		this.is_Client = is_Client;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
	  public List<Contact> getContact() { return contact; }
	  
	  public void setContact(List<Contact> contact) { this.contact = contact; }
	 
	
	  public List<Employee> getEmployee() { return employee; }
	  
	  public void setEmployee(List<Employee> employee) { this.employee = employee;}
	 
	
	
	  public void addContact(Contact cont) { contact.add(cont); }
	  
	  public void removeContact(Contact cont) { if (contact != null)
	  contact.remove(cont); }
	 
	
	
	  public void addEmployee(Employee emp) { employee.add(emp); }
	  
	  public void removeEmployee(Employee emp) { if (employee != null)
	  employee.remove(emp); }
	 

}
