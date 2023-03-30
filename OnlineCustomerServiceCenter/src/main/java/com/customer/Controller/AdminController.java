package com.customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Department;
import com.customer.Exception.DepartmentException;
import com.customer.Exception.LoginException;
import com.customer.Service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	   
	
	@PostMapping("depart/add/{key}")
	public ResponseEntity<Department>  addDepartment(@RequestBody Department deprt, @PathVariable String key){
		     
		
		   
		
		  return new ResponseEntity<>(adminService.addDepartment(deprt, key), HttpStatus.CREATED);
	}
	
	@PutMapping("depart/update/{key}")
	public ResponseEntity<Department>  updateDepartment(@RequestBody Department deprt, @PathVariable String key) throws LoginException, DepartmentException{
		     
		
		   
		
		  return new ResponseEntity<>(adminService.updateDepartment(deprt, key), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/depart/delete/{key}")
	private ResponseEntity<Department> deleteDepartment(@RequestBody Integer deptId, @PathVariable String key) throws LoginException, DepartmentException {
		 
		return new ResponseEntity<Department>(adminService.removeDepartment(deptId, key), HttpStatus.ACCEPTED);
	}
	
}
