package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.Entity.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>	 {
        
	
	   
}
