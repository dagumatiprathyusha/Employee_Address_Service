package com.app.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.emp.entity.EmpResponse;
import com.app.emp.entity.Employee;
import com.app.emp.service.EmpServiceImpl;

@RestController
public class EmpController {
	 
	@Autowired
    EmpServiceImpl empservice;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmpResponse> getEmployeeDetails(@PathVariable("id") long id )
	{
		EmpResponse response= empservice.findByEmpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/employee/getAllEmps")
	public ResponseEntity<List<EmpResponse>> getAllEmpDetails()
	{
		List<EmpResponse> response=empservice.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable("id") long id)
{
		String deletedMessage=empservice.deleteEmp(id);
	return ResponseEntity.status(HttpStatus.OK).body(deletedMessage);
	
}

}
