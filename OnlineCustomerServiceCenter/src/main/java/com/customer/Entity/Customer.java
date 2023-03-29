package com.customer.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@NotBlank(message = "First Name cannot be Blank")
	@NotEmpty(message = "First Name cannot be Empty")
	@NotNull(message = "First Name cannot be Null")
	private String firstName;
	@NotBlank(message = "Last Name cannot be Blank")
	@NotEmpty(message = "Last Name cannot be Empty")
	@NotNull(message = "Last Name cannot be Null")
	private String lastName;
	@Column(unique = true)
	@Email
	private String email;
	@Column(unique = true)
	private String mobile;
	@NotBlank(message = "Password cannot be Blank")
	@NotEmpty(message = "Password cannot be Empty")
	@NotNull(message = "Password cannot be Null")
	private String password;
	private String city;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Issue> issue = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Call> call = new ArrayList<>();

	public Customer() {

	}

	public Customer(Integer customerId,
			@NotBlank(message = "First Name cannot be Blank") @NotEmpty(message = "First Name cannot be Empty") @NotNull(message = "First Name cannot be Null") String firstName,
			@NotBlank(message = "Last Name cannot be Blank") @NotEmpty(message = "Last Name cannot be Empty") @NotNull(message = "Last Name cannot be Null") String lastName,
			@Email String email, String mobile, String password, String city, List<Issue> issue, List<Call> call) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.city = city;
		this.issue = issue;
		this.call = call;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Issue> getIssue() {
		return issue;
	}

	public void setIssue(List<Issue> issue) {
		this.issue = issue;
	}

	public List<Call> getCall() {
		return call;
	}

	public void setCall(List<Call> call) {
		this.call = call;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + ", city=" + city + "]";
	}

}
