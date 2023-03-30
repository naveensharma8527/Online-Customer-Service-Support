package com.customer.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.DTO.DepartmentDTO;

@RestController
public class AdminController {
	
	
	    @PostMapping("/admin/add/department")
	    public ResponseEntity<String>  addDepartment(@RequestBody DepartmentDTO deptDto){
	    	  return null;
	    }
	
}
