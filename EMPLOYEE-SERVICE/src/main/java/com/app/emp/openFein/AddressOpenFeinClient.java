package com.app.emp.openFein;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.emp.entity.AddressResponse;
//proxy
@FeignClient(name="ADDRESS-SERVICE")
public interface AddressOpenFeinClient {
	
	@GetMapping("/address/{id}")
	AddressResponse getAddressByEmpId(@PathVariable("id") long id);
	
	@GetMapping("/allAddress")
	List<AddressResponse> getAddress();
	
	@DeleteMapping("/delete/{id}")
	public void deleteAddressById(@PathVariable("id") long id);
}
