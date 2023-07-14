package com.empstatus.model;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.Date;
>>>>>>> fbb609263db6ce7f42f4de48e27a13f38b327d2d

import jakarta.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {
	
	public String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	public String lastName;
	int age;
	public String visaStatus;
	public Date dob;
	public String email;
	public String phone;
	
<<<<<<< HEAD
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
=======
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "Id")
	private Address address;
>>>>>>> fbb609263db6ce7f42f4de48e27a13f38b327d2d

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

	public Address getAddress() {
		return address;
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
<<<<<<< HEAD
	
	public List<Address> getAddressList() {
		return addressList;
=======

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
>>>>>>> fbb609263db6ce7f42f4de48e27a13f38b327d2d
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public void addAddresses(Address addr) {
		addressList.add(addr);
	}
<<<<<<< HEAD

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", Id=" + Id + ", lastName=" + lastName + ", age=" + age
				+ ", visaStatus=" + visaStatus + "]";
	}

=======
	
	
	
	
>>>>>>> fbb609263db6ce7f42f4de48e27a13f38b327d2d

}
