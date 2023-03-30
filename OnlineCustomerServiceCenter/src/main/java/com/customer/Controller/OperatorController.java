package com.customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Customer;
import com.customer.Entity.Issue;

import com.customer.Entity.Status;
import com.customer.Service.OperatorService;

@RestController
@RequestMapping("/operator")
public class OperatorController {
	
	@Autowired
	private OperatorService oS;
	
	@PostMapping("/add-issue")
	public ResponseEntity<String> addCustomerIssueHandler(@RequestBody Issue issue) {
		
		String s = oS.AddCustomerIssue(issue);
		
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/update-issue")
	public ResponseEntity<String> updateIssueHandler(@RequestBody Issue issue) {
		String s = oS.UpdateIssue(issue);
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/close-issue/{issueid}")
	public ResponseEntity<String> closeIssueHandler(@PathVariable Integer issueid, @RequestBody Status status) {
		String s = oS.closeCustomerIssue(issueid, status);
		return ResponseEntity.ok(s);
	}
	
	@GetMapping("/get-customers")
	public ResponseEntity<List<Customer>> getCustomersHandler() {
		List<Customer> list = oS.findAllCustomer();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/customer/{cusId}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable Integer cusId) {
		Customer c = oS.findByCustomerId(cusId);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/customer/{fName}")
	public ResponseEntity<List<Customer>> getByFirstNameHandler(@PathVariable String fName) {
		List<Customer> c = oS.findCustomerByFirstName(fName);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/customer/{email}")
	public ResponseEntity<Customer> getByEmailHandler(@PathVariable String email) {
		Customer c = oS.findCustomerByEmail(email);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/customer/{mobNo}")
	public ResponseEntity<Customer> getByMobileHandler (@PathVariable String mobNo) {
		Customer c = oS.findCustomerByMobile(mobNo);
		return ResponseEntity.ok(c);
	}
}
