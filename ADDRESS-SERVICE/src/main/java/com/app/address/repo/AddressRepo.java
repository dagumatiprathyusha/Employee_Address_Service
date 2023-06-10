package com.app.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.address.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
