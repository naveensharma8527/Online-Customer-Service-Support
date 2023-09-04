package com.customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.DTO.OperatorDTO;
import com.customer.Entity.Department;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;
import com.customer.Exception.LoginException;
import com.customer.Service.AdminService;
import com.customer.Service.OperatorService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private OperatorService optService;
	   
	
	@PostMapping("/depart/add/{key}")
	public ResponseEntity<Department>  addDepartment(@Valid @RequestBody Department deprt, @PathVariable String key){
		     
		
		   
		
		  return new ResponseEntity<>(adminService.addDepartment(deprt, key), HttpStatus.CREATED);
	}
	
	@PutMapping("/depart/update/{key}")
	public ResponseEntity<Department>  updateDepartment(@Valid @RequestBody Department deprt, @PathVariable String key) throws LoginException, DepartmentException{
		     
		
		   
		
		  return new ResponseEntity<>(adminService.updateDepartment(deprt, key), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/depart/delete/{deptId}/{key}")
	private ResponseEntity<Department> deleteDepartment(@PathVariable Integer deptId, @PathVariable String key) throws LoginException, DepartmentException {
		 
		return new ResponseEntity<Department>(adminService.removeDepartment(deptId, key), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/depart/get/{deptId}/{key}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer deptId, @PathVariable String key){
		    
	   return new ResponseEntity<Department>(adminService.getDepartmentById(deptId, key), HttpStatus.ACCEPTED);
		
	}
	
	
	@PostMapping("/operator/add/{key}")
	public ResponseEntity<Operator>  addOPerator(@Valid @RequestBody Operator opt, @PathVariable String key){
		     
         return new ResponseEntity<Operator>(adminService.addOperator(opt, key), HttpStatus.ACCEPTED);
		 
	}
	
	@PutMapping("/operator/update/{key}")
	public ResponseEntity<Operator>   updateOperator(@Valid @RequestBody Operator opt, @PathVariable String key){
		   
		return new ResponseEntity<Operator>(adminService.updateOperator(opt, key), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/operator/delete/{key}")
	public ResponseEntity<Operator> deleteOperator(@RequestBody Integer optId, @PathVariable String key){
		   return new ResponseEntity<Operator>(adminService.deleteOperator(optId, key), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/operator/all/{key}")
	public ResponseEntity<List<Operator>> getAllOperator(@PathVariable String key){
		    return new ResponseEntity<List<Operator>>(adminService.getAllOperators(key), HttpStatus.OK);
	}
	
	
	@GetMapping("/operator/get/{id}/{key}")
	public ResponseEntity<Operator> getOperatorById(@PathVariable Integer id, @PathVariable String key){
		   return new ResponseEntity<Operator>(adminService.getOperatorById(id, key), HttpStatus.OK);
	}
	
	@GetMapping("/operator/getdept/{id}/{key}")
	public ResponseEntity<List<Operator>> getAllOperatorByDeptId(@PathVariable Integer id, @PathVariable String key){
		   return new ResponseEntity<List<Operator>>(adminService.getAllOperatorWithDeptId(id, key), HttpStatus.OK);
	}
	
	@PostMapping("/operator/assign/{key}")
	private ResponseEntity<OperatorDTO> assignDepartmentToOperator(@Valid @RequestBody OperatorDTO optDto, @PathVariable String key){
		  return new ResponseEntity<OperatorDTO>(adminService.assignDeptToOperator(optDto.getId(),optDto.getDept_id(), key), HttpStatus.OK);
	}
	
	
	
}
