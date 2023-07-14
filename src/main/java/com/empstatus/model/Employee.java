package com.empstatus.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {
	
	public String firstName;
	@Id
	@GeneratedValue
	public int Id;
	public String lastName;
	int age;
	public String visaStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private List<Address> addressList = new ArrayList<>();
	
	public Employee() {
		
	}
	
	public Employee(String firstName, int id, String lastName, int age, String visaStatus, Address address) {
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
	public int getId() {
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setId(int id) {
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
