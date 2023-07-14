package com.empstatus.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "Employee")
public class Employee {
	
	public String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	@NotBlank(message = "Last Name Cannot be Empty")
	public String lastName;
	@NotBlank(message = "Age Cannot be Empty")
	@Min(value = 18)
	int age;
	@NotBlank(message = "Visa Status Cannot be Empty")
	public String visaStatus;
	@NotBlank(message = "DOB Cannot be Empty")
	public Date dob;
	@NotBlank(message = "Email Cannot be Empty")
	@Size(max =50)
	public String email;
	@NotBlank(message = "Phone Cannot be Empty")
	@Size(max = 10)
	public String phone;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private List<Address> addressList = new ArrayList<>();
	
	public Employee() {
		
	}
	
	public Employee(String firstName, Long id, String lastName, int age, String visaStatus, Address address) {
		super();
		this.firstName = firstName;
		Id = id;
		this.lastName = lastName;
		this.age = age;
		this.visaStatus = visaStatus;
	}

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

	public List<Address> getAddressList() {
		return addressList;
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

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public void addAddresses(Address addr) {
		addressList.add(addr);
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", Id=" + Id + ", lastName=" + lastName + ", age=" + age
				+ ", visaStatus=" + visaStatus + "]";
	}

}
