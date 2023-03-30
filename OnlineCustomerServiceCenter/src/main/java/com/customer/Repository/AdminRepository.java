package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.Entity.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	
	
	public Admin findByEmail(String email);
	
	
	

}
