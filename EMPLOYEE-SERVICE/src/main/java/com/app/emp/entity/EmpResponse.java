package com.app.emp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class EmpResponse {

	private long empId;
	private String empName;
	private String email;
	private String bloodGroup;
	
	  @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
	private AddressResponse addressresponse;
	
	public AddressResponse getAddressresponse() {
		return addressresponse;
	}
	public void setAddressresponse(AddressResponse addressresponse) {
		this.addressresponse = addressresponse;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	
	
}
