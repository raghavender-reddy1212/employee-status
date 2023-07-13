package com.empstatus.model;

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
	

}
