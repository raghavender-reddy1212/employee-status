package com.empstatus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empstatus.model.Address;
import com.empstatus.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	public AddressService addressService;
	
	@PostMapping("/address")
	ResponseEntity<Address> createAddress(@RequestBody Address address){
		return new ResponseEntity<Address>(addressService.createAddress(address), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/address/{id}")
	ResponseEntity<Address> getAddress(@PathVariable int id) {
		return new ResponseEntity<Address>(addressService.findAddress(id), HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping("/address")
	ResponseEntity<List<Address>> getAddresses(){
		return new ResponseEntity<List<Address>>(addressService.findAddresses(), HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping("/address/{id}")
	ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody Address address) {
		return new ResponseEntity<Address>(addressService.updateAddress(id, address), HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/address/{id}")
	ResponseEntity<Void> deleteAddress(@PathVariable int id) {
		addressService.deleteAddress(id);
		return new ResponseEntity<Void>(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
	
	@PatchMapping("/address/{id}")
	ResponseEntity<Address> updateAddressData(@PathVariable int id, @RequestBody Map<String, Object> address) {
		return new ResponseEntity<Address>(addressService.patch(id, address), HttpStatus.FOUND);
	}

}
