package com.empstatus.model;


import java.util.ArrayList;
import java.util.List;


import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "Employee")
public class Employee {
	@NotEmpty(message = "Last Name Cannot be Empty")
	public String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	@NotEmpty(message = "Last Name Cannot be Empty")
	public String lastName;
	@Min(value = 18 , message = "Age cannot be Empty")
	int age;
	@NotEmpty(message = "Visa Status Cannot be Empty")
	public String visaStatus;
	@Past(message = "DOB Cannot be Present")
	public Date dob;
	@Email(message = "Please insert valid Email")
	public String email;
	@NotEmpty(message = "Phone Cannot be Empty")
	@Size(max = 10)
	public String phone;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "employee_id")
	private List<Address> address = new ArrayList<>();

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return Id;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getVisaStatus() {
		return visaStatus;
	}

	public Date getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}

	

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public void addAddresses(Address addr) {
		address.add(addr);
	}
	
	public void removeAddress(Address addr) {
		if (address != null)
			address.remove(addr);
	}


}
