package com.empstatus.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.empstatus.model.Address;
import com.empstatus.model.Contact;
import com.empstatus.model.Employee;
import com.empstatus.model.Vendor;
import com.empstatus.repository.ContactRepository;
import com.empstatus.repository.EmployeeRepository;
import com.empstatus.repository.VendorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class VendorService {
	
	@Autowired
	public VendorRepository vendorRepository;
	
	@Autowired
	public ContactRepository contactRepository;
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Vendor createVendor(Vendor vendor) {
//		contactRepository.saveAll(vendor.getContact());
//		employeeRepository.saveAll(vendor.getEmployee());
		return vendorRepository.save(vendor);
	}
	
	public Vendor findVendor(int id) {
		return vendorRepository.findById(id).get();
	}
	
	public List<Vendor> findVendors() {
		TypedQuery<Vendor> getAll = entityManager.createNamedQuery("getAllVendors", Vendor.class);
		return getAll.getResultList();
		//return vendorRepository.findAll();
	}
	
	public Vendor updateVendor(int id, Vendor vendor) {
		vendor.setId((long)id);
		return vendorRepository.save(vendor);
	}
	
	public void deleteVendor(int id) {
		Vendor vend = vendorRepository.findById(id).get();
		vend.setDelete(true);
		vendorRepository.save(vend);
		//vendorRepository.delete(vendorRepository.findById(id).get());
	}
	
	public Vendor patch(long id, Map<String, Object> tempVendor) {
		Optional<Vendor> vendor = vendorRepository.findById((int) id);
		tempVendor.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Vendor.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, vendor.get(), value);
		});
		return vendorRepository.save(vendor.get());
	}
	
	
	  public Vendor addEmployee(Integer id, Employee emp) { 
		  Vendor vendor = vendorRepository.findById(id).get(); 
		  vendor.addEmployee(emp); 
		  return vendorRepository.save(vendor);
	  }
	  
	  public Vendor removeEmployee(int id, Employee emp) { 
		  Vendor vendor = vendorRepository.findById(id).get(); 
		  vendor.removeEmployee(emp); 
		  return vendorRepository.save(vendor); 
	  }
	  
	  public Vendor addContact(Integer id, Contact cont) { 
		  Vendor vendor = vendorRepository.findById(id).get(); 
		  vendor.addContact(cont); 
		  return vendorRepository.save(vendor); 
	  }
	  
	  public Vendor removeContact(int id, Contact cont) { 
		  Vendor vendor = vendorRepository.findById(id).get(); 
		  vendor.removeContact(cont); 
		  return vendorRepository.save(vendor); 
	  }
	  
	  public Vendor addAddress(int id, Address address) {
			Vendor vendor = vendorRepository.findById(id).get();
			vendor.setAddress(address);
			return vendorRepository.save(vendor);
		}
}
