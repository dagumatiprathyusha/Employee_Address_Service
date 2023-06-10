package com.app.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.address.entity.AddressResponse;
import com.app.address.service.AddressServiceImpl;

@RestController
public class AddressController {
	
	@Autowired
	AddressServiceImpl addressService;
	
	@GetMapping("/address/{id}")
	public ResponseEntity<AddressResponse> getEmpAddress(@PathVariable("id") long id)
	{
		AddressResponse response=addressService.getAddressById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/address/allAdress")
	public ResponseEntity<List<AddressResponse>> getAllAddress()
	{
		List<AddressResponse> response= addressService.getAddress();
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@DeleteMapping("/address/delete/{id}")
	public void deleteAddressById(@PathVariable("id") long id)
	{
		addressService.deleteAddress(id);
	}

}
