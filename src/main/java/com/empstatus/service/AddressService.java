package com.empstatus.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.empstatus.model.Address;
import com.empstatus.model.Vendor;
import com.empstatus.repository.AddressRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class AddressService {
	
	@Autowired
	public AddressRepository addressRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	// Post Operation
	public Address createAddress(Address address) {
		return addressRepository.save(address);
	}
	
	// Get Operation - get address with an id
	public Address findAddress(int id) {
		return addressRepository.findById(id).get();
	}
	
	// Get Operation - get all addresses
	public List<Address> findAddresses() {
		TypedQuery<Address> getAll = entityManager.createNamedQuery("getAllAddresses", Address.class);
		return getAll.getResultList();
		//return addressRepository.findAll();
	}
	
	// Put Operation
	public Address updateAddress(int id, Address address) {
		address.setId(id);
		return addressRepository.save(address);
	}
	
	// Delete Operation
	public void deleteAddress(int id) {
		Address addr = addressRepository.findById(id).get();
		addr.setDelete(true);
		addressRepository.save(addr);
		//addressRepository.delete(addressRepository.findById(id).get());
	}

	// Patch Operation
	public Address patch(int id, Map<String, Object> tempAddress) {

			Optional<Address> address = addressRepository.findById(id);
			tempAddress.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Address.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, address.get(), value);
			});
			return addressRepository.save(address.get());
		}
}

