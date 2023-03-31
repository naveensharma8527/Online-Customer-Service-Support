package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Admin;

@Repository
public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	
	
	public Admin findByEmail(String email);
	
	
	

}
