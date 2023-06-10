package com.app.address.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.address.entity.Address;
import com.app.address.entity.AddressResponse;
import com.app.address.repo.AddressRepo;

@Service
public class AddressServiceImpl {

	@Autowired
	AddressRepo addressrepo;
	
	@Autowired
	ModelMapper modelmapper;
	
	public AddressResponse getAddressById(long id)
	{
		Address address=	addressrepo.findById(id).get();
		AddressResponse response=	modelmapper.map(address, AddressResponse.class);
		return response;
	}

	public List<AddressResponse> getAddress() {
	    List<Address> address = addressrepo.findAll();
	    List<AddressResponse> response = address.stream()
	        .map(a -> modelmapper.map(a, AddressResponse.class))
	        .collect(Collectors.toList());
	    return response;
	}
	
	public void deleteAddress(long id)
	{
		addressrepo.deleteById(id);
	}

}
