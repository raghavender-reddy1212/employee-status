package com.empstatus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Contact")
@NamedQuery(name = "getAllContacts", query = "Select c from Contact c where isDelete = false")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	@NotEmpty(message = "First Name Cannot be Empty")
	@Column(unique = true)
	public String firstName;
	@NotEmpty(message = "Last Name Cannot be Empty")
	@Column(unique = true)
	public String lastName;
	@Email(message = "Please insert valid Email")
	@Column(unique = true)
	public String email;
	@NotEmpty(message = "Phone Cannot be Empty")
	@Size(max = 10)
	@Column(unique = true)
	public String phone;
	public boolean isDelete = false;
	
	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getId() {
		return Id;
	}
	
	public void setId(int id2) {
		Id = id2;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
