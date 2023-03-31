package com.customer.Service;

import java.time.LocalDateTime;

import java.util.Optional;
import java.util.UUID;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.Admin;
import com.customer.Entity.CurrentUserSession;
import com.customer.Entity.Customer;
import com.customer.Entity.Login;
import com.customer.Entity.Operator;
import com.customer.Repository.AdminRepository;
import com.customer.Repository.CurrentUserSessionRepository;
import com.customer.Repository.CustomerRepository;
import com.customer.Repository.OperatorRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerRepository customerDao;

	@Autowired
	OperatorRepository operatorDao;

	@Autowired
	CurrentUserSessionRepository sessionDao;

	@Autowired
	AdminRepository adminDao;

	@Override
	public String loginUser(Login login) throws LoginException {

		CurrentUserSession currentUserSession;
		
		login.setUser_Type(login.getUser_Type().toUpperCase());

		// checking for customer
		if (login.getUser_Type().equals("CUSTOMER")) {

			Customer existCustomer = customerDao.findByEmail(login.getEmail());

			if (existCustomer == null)
				throw new LoginException("Please Enter a valid Email login");

			Optional<CurrentUserSession> validCustomerSession = sessionDao.findById(existCustomer.getCustomerId());

			if (validCustomerSession.isPresent()) {

				throw new LoginException("User allready Logged ");

			}

			if (existCustomer.getPassword().equals(login.getPassword())) {

				String key = UUID.randomUUID().toString();

				currentUserSession = new CurrentUserSession(existCustomer.getCustomerId(), key, LocalDateTime.now(),
						login.getUser_Type());

				sessionDao.save(currentUserSession);

				return key;
			} else
				throw new LoginException("Passowrd incorrect");
		}

		/// checking for Admin
		if (login.getUser_Type().equals("ADMIN")) {

			Admin existAdmin = adminDao.findByEmail(login.getEmail());
			if (existAdmin == null)
				throw new LoginException("Please Enter a valid loginS");

			Optional<CurrentUserSession> validAdminSessionOpt = sessionDao.findById(existAdmin.getAdminId());

			if (validAdminSessionOpt.isPresent()) {

				throw new LoginException("Admin already Logged in");

			}

			// Check Admin Password

			if (existAdmin.getPassword().equals(login.getPassword())) {

				String key = UUID.randomUUID().toString();

				currentUserSession = new CurrentUserSession(existAdmin.getAdminId(), key, LocalDateTime.now(),
						login.getUser_Type());

				sessionDao.save(currentUserSession);

				return key;
			} else
				throw new LoginException("Passowrd incorrect");
		}

		if (login.getUser_Type().equals("OPERATOR")) {

			Operator existingOperator = operatorDao.findByEmail(login.getEmail());
			if (existingOperator == null)
				throw new LoginException("Please Enter a valid loginS");

			java.util.Optional<CurrentUserSession> validOperatorSessionOpt = sessionDao
					.findById(existingOperator.getOperatorId());

			if (validOperatorSessionOpt.isPresent()) {

				throw new LoginException("User already Logged In with this Email");

			}

			if (existingOperator.equals(login.getPassword())) {

				String key = UUID.randomUUID().toString();

				currentUserSession = new CurrentUserSession(existingOperator.getOperatorId(), key, LocalDateTime.now(),
						login.getUser_Type());

				sessionDao.save(currentUserSession);

				return key;
			} else
				throw new LoginException("Passowrd incorrect");
		} else
			throw new LoginException("Please Enter a valid User");
		
		
		
	}

	@Override
	public String logoutUser(String Key) throws LoginException {

		CurrentUserSession checkUser = sessionDao.findByUuid(Key);

		if (checkUser == null) {
			throw new LoginException("Not Record Match with this id");
		}

		sessionDao.delete(checkUser);
		return "User LogOut Sucessfully";
	}

}
