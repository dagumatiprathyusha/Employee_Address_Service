package com.app.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.emp.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
