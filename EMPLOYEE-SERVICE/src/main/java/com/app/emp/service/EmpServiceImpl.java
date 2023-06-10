package com.app.emp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.emp.entity.AddressResponse;
import com.app.emp.entity.EmpResponse;
import com.app.emp.entity.Employee;
import com.app.emp.openFein.AddressOpenFeinClient;
import com.app.emp.repo.EmpRepo;

@Service
public class EmpServiceImpl {
    
	@Autowired
	EmpRepo emprepo;
	
	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	AddressOpenFeinClient addressClient;
	
//	@Value("${addressservice.base.url}")
//	private String addressBaseUrl;
	
	public EmpResponse findByEmpId(long id)
	{
		
		AddressResponse addressresponse=addressClient.getAddressByEmpId(id);
		Employee emp=emprepo.findById(id).get();
		EmpResponse empresponse=modelmapper.map(emp, EmpResponse.class);
	    empresponse.setAddressresponse(addressresponse);
		
		return empresponse;
	}
	
	public List<EmpResponse> getAllEmployees()
	{
		
		List<Employee> emps=emprepo.findAll();
		List<EmpResponse> empResponse=emps.stream().map(emp ->{AddressResponse address=addressClient.getAddressByEmpId(emp.getEmpId());
		                                                    EmpResponse response=  modelmapper.map(emp, EmpResponse.class);
		                                                    response.setAddressresponse(address);
		                                                    return response;}).collect(Collectors.toList());
		return empResponse;

		
	}
	
	public String deleteEmp(long id)
	{
		emprepo.deleteById(id);
		addressClient.deleteAddressById(id);
		return "Succesfully Deleted";
		
	}
}
