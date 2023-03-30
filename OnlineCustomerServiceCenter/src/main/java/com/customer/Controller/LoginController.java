package com.customer.Controller;





import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Login;
import com.customer.Service.LoginService;


@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginservice;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCustomer(@RequestBody Login login) throws LoginException {
	
		return new ResponseEntity<String>(loginservice.loginUser(login), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> LogoutUser(@PathVariable String key) throws LoginException {
		
		return new ResponseEntity<String>(loginservice.logoutUser(key), HttpStatus.OK); 
	}

}
