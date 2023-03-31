package com.customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Customer;
import com.customer.Entity.Issue;
import com.customer.Entity.Login;
import com.customer.Exception.CustomerException;
import com.customer.Service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
   
	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody Customer c){
		Customer customer = cs.registerCustomer(c);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@PutMapping("/changePassword")
	public ResponseEntity<String> register(@RequestBody Login l) throws CustomerException{
		String login = cs.changePassword(l);
		return new ResponseEntity<String>(login,HttpStatus.OK);
	}
	
	@GetMapping("/forgetPassword/{id}")
	public ResponseEntity<String> forgetPassword(@PathVariable Integer id) throws CustomerException{
		String customer = cs.forgetPassword(id);
		return new ResponseEntity<String>(customer,HttpStatus.OK);
	}
	
	
	@GetMapping("/emailPassword/{id}")
	public ResponseEntity<Customer> emailPassword(@PathVariable Integer id){
		Customer c = cs.emailPassword(id);
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@GetMapping("/viewIssue/{id}/{key}")
	public ResponseEntity<Issue> viewIssue(@PathVariable Integer id, @PathVariable String key){
		Issue issue = cs.viewissue(id, key);
		return new ResponseEntity<Issue>(issue,HttpStatus.OK);
	}
	
	@GetMapping("/viewIssues/{key}")
	public ResponseEntity<List<Issue>> viewIssues(@PathVariable String key){
		List<Issue> issues = cs.getAllIssue(key);
		return new ResponseEntity<List<Issue>>(issues,HttpStatus.OK);
	}
	
	@GetMapping("/reopenIssue/{id}/{key}")
	public ResponseEntity<String> reopenIssue(@PathVariable Integer id,@PathVariable String key){
		String message = cs.reopenIssue(id, key);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	
	

}
