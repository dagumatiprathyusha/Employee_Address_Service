package com.app.emp.entity;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
       private long empId;
       private String empName;
       private String email;
       private String bloodGroup;
   
       
       
       
//       @OneToOne(cascade = CascadeType.ALL)
//       @JoinColumn(name="address_id")
//       private Address address;
//       
//       
//       
//	public Address getAddress() {
//		return address;
//	}
//
//
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}







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



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", bloodGroup=" + bloodGroup
				+ "]";
	}


}
