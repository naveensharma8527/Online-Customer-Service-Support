package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{

	
	   
}
