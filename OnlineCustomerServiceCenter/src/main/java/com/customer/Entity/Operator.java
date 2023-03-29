package com.customer.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Operator {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "operatorGen")
	@SequenceGenerator(name="operatorGen",sequenceName = "ogen",allocationSize = 1,initialValue = 100)
	private Integer operatorId;
	@NotBlank(message = "First Name cannot be Blank")
	@NotEmpty(message = "First Name cannot be Empty")
	@NotNull(message = "First Name cannot be Null")
	private String firstName;
	@NotBlank(message = "Last Name cannot be Blank")
	@NotEmpty(message = "Last Name cannot be Empty")
	@NotNull(message = "Last Name cannot be Null")
	private String lastName;
	@Email
	@Column(unique = true)
	private String email;
	private String password;
	@Column(unique = true)
	private String mobile;
	private String city;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "operator")
	private List<Call> call=new ArrayList<>();
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dept_id")
	private Department department;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="solution_id")
//	private Solution solution;
	public Operator()
	{
		
	}
	
	public Operator(Integer operatorId,
		@NotBlank(message = "First Name cannot be Blank") @NotEmpty(message = "First Name cannot be Empty") @NotNull(message = "First Name cannot be Null") String firstName,
		@NotBlank(message = "Last Name cannot be Blank") @NotEmpty(message = "Last Name cannot be Empty") @NotNull(message = "Last Name cannot be Null") String lastName,
		@Email String email, String password, String mobile, String city, List<Call> call, Department department) {
	super();
	this.operatorId = operatorId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.city = city;
	this.call = call;
	this.department = department;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
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
	public List<Call> getCall() {
		return call;
	}
	public void setCall(List<Call> call) {
		this.call = call;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Operator [operatorId=" + operatorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + ", city=" + city + ", department=" + department + "]";
	}
	
	
}
